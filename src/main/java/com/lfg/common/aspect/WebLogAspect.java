package com.lfg.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by lifengguang on 2017/2/4.
 */

@Aspect
@Service
public class WebLogAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("execution(public * com.lfg.controller..*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("请求信息:【url:"+request.getRequestURL()+", ip:"+request.getRemoteAddr()+", method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+
                ", args:"+ Arrays.toString(joinPoint.getArgs())+"】");

    }

    @AfterReturning(returning = "ret",pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable{
        logger.info("响应信息:【"+ ret+"耗时:"+(System.currentTimeMillis()-startTime.get())+"ms】");
    }

}
