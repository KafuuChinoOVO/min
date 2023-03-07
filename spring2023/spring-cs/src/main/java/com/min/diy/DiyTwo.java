package com.min.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DiyTwo {
    @Before("execution(* com.min.pojo.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("注解执行前");
    }
    @After("execution(* com.min.pojo.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("注解执行后");
    }
    @Around("execution(* com.min.pojo.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        Object proceed = jp.proceed();
        System.out.println("环绕后");
    }
}
