package com.jay.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.jay.service.*.*(..))")
    public void before() {
        System.out.println("============before method invocation=============");
    }

    @After("execution(* com.jay.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("============after method invocation==============");
    }

    @Around("execution(* com.jay.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before around");

        Signature signature = joinPoint.getSignature();
        System.out.println("signature: " + signature);

        Object proceed = joinPoint.proceed();
        System.out.println("proceed: " + proceed);
        System.out.println("after around");
    }
}
