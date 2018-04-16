package com.nyeong.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Title:  AspectUtil
 * Description: 面向切面AOP操作
 *
 * @Author: quanningzhen
 * @Date: 2018/4/16 上午11:51
 * @Version: 1.0
 **/

@Aspect
@Component
public class AspectUtil {

    private static final Logger logger = LoggerFactory.getLogger("com.gwon.aspect.HttpAspect");

    @Pointcut("execution(public * com.nyeong.controller.UserController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        request.getRequestURL();
        request.getMethod();
        request.getRemoteAddr();
        joinPoint.getSignature().getDeclaringTypeName();
        joinPoint.getSignature().getName();
        joinPoint.getArgs();
    }

    @After("log()")
    public void doAfter() {

    }

    @AfterReturning(returning = "basejson",pointcut = "log()")
    public void doAfterReturning(BaseJson basejson) {

    }
}
