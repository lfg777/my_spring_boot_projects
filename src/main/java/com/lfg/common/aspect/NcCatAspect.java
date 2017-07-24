package com.lfg.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by guiqingqing on 2017/3/15.
 */
@Aspect
@Component
@Order(2)
public class NcCatAspect {

    /**
     * cat拦截处理
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(@com.lfg.annotations.NcCat * *(..))")
    public Object cat(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object retVal = null;
        try {
            System.out.println("=========around aspect is expected");
            retVal = pjp.proceed();
        } catch (Exception e) {
            throw e;
        } finally {

        }
        return retVal;
    }
}