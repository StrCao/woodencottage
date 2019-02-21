package com.xicheng.token.filter;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.google.gson.Gson;
import com.xicheng.token.entity.AccessEntity;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xichengxml
 * @date 2019/2/20 16:14
 * 设定只拦截access请求
 * 注：chain.doFileter()前后代码都会执行
 */
@WebFilter(urlPatterns = "/*")
public class AccessFilter implements Filter {

    private static final Gson GSON = new Gson();
    private static final String ROOT = "/";
    private static final List<String> staticList = new ArrayList<>();
    private static final String BLANK = "{}";

    /**
     * 过滤器不支持排除路径，因此将静态资源保存在list中
     */
    static {
        Collections.addAll(staticList, "/js", "/css");
    }

    /**
     * 过滤完之后body会消失，处理一下
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String body = getBody(req);
        req.setAttribute("body", body);
        String requestURI = req.getRequestURI();
        boolean valid = validateToken(body);
        boolean validataStaticRes = validateStaticResources(requestURI);
        // 放行根路径、静态资源
        if (valid || ROOT.equals(requestURI) || validataStaticRes) {
            chain.doFilter(request, response);
        } else {
            PrintWriter writer = response.getWriter();
            writer.append("Token校验失败");
        }
    }

    /**
     * 校验请求的资源是否静态资源
     * @param requestURI
     * @return
     */
    private boolean validateStaticResources(String requestURI) {
        for (String res: staticList) {
            if (requestURI.startsWith(res)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验token值和加密值是否一致, sign值可以用做密钥
     * @param body
     * @return
     */
    private boolean validateToken(String body) {
        if (StringUtils.isBlank(body) || BLANK.equals(body)) {
            return false;
        }
        AccessEntity accessEntity = GSON.fromJson(body, AccessEntity.class);
        String sign = accessEntity.getSign();
        String token = accessEntity.getToken();
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(token.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String encryptToken = new BigInteger(1, md.digest()).toString(16);
            return encryptToken.equals(sign);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 使用dubbo的IOUtils获取request中post的body内容
     * @param request
     * @return
     */
    private String getBody(ServletRequest request) {
        String body = null;
        try {
            ServletInputStream inputStream = request.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            body = IOUtils.read(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }
}
