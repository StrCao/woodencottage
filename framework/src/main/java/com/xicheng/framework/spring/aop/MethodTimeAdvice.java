package com.xicheng.framework.spring.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * @author xichengxml
 * @date 2019/1/28 15:56
 */
@Aspect
@Component
public class MethodTimeAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodTimeAdvice.class);
    private static final int TIME_OUT = 60 * 1000;

    @Around("execution(* com.xicheng.framework.spring..*Service.*(..))")
    public Object invoke(ProceedingJoinPoint joinpoint) throws Throwable {
        StopWatch clock = new StopWatch();
        // 计时开始
        clock.start();
        // 获取类名和方法名
        String className = joinpoint.getClass().getName();
        Object[] args = joinpoint.getArgs();
        Object methodName = joinpoint.getThis();
        Object result = null;
        try {
            result = joinpoint.proceed(args);
        } catch (Throwable throwable) {
            LOGGER.info("Class:" + className + "--method:" + methodName + "--run error");
            throw throwable;
        } finally {
            clock.stop();
        }
        // 执行时间超过一分钟
        if (clock.getTime() > TIME_OUT) {
            LOGGER.info("Class:" + className + "--method:" + methodName + "--runTime:" + clock.getTime());
        }
        return result;
    }

    @AfterReturning("execution(* com.xicheng.framework.spring..*Service.*(..))")
    public void monitor() {
        System.out.println("I am invoked...");
    }
}
