package com.xicheng.filter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xichengxml
 * @date 2019/2/15 14:07
 */
public class MyFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        int serverPort = servletRequest.getServerPort();
        String requestURI = request.getRequestURI();
        LOGGER.info(requestURI + " invocation start, port: " + serverPort);

        // 本来的目的是向返回值后面加以下内容，结果直接返回了以下内容
        PrintWriter writer = servletResponse.getWriter();
        writer.append("This is added by filter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
