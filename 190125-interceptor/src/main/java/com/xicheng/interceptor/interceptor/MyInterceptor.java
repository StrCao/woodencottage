package com.xicheng.interceptor.interceptor;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xichengxml
 * @date 2019/2/15 13:16
 * 实现打日志和统计请求时间的功能
 * GSON.toJson(request)程序卡死，堆溢出
 */
public class MyInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyInterceptor.class);
    private static final Gson GSON = new Gson();

    /**
     * 调用时间：HandlerMapping确定调用哪个handler对象之后，但是在HandlerAdapter调用handler之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        LOGGER.info(requestURI + " invocation start, requestParam: requestBody");
        long startTime = System.nanoTime();
        request.setAttribute("startTime", startTime);
        return true;
    }

    /**
     * 调用时间：HandlerAdapter调用handler之后，DispatcherServlet渲染视图之前
     *  Called after HandlerAdapter actually
     * invoked the handler, but before the DispatcherServlet renders the view.
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        long endTime = System.nanoTime();
        String requestURI = request.getRequestURI();
        LOGGER.info(requestURI + "invocation end, responseParam: responseBody");
        long startTtime = (long) request.getAttribute("startTime");
        request.setAttribute("runTime", endTime - startTtime);
    }

    /**
     * 调用时间：请求完成之后（即视图渲染完成之后）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LOGGER.info("All finished!");
    }
}
