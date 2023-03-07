package com.min.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect//标注这个类是个切面
public class AnnotationPointCut {
    @Before("execution(* com.min.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("执行之前");
    }
    @After("execution(* com.min.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("执行之后");
    }
    //在环绕增强中，我i吗可以给定一个参数，代表我们要获取切入的点
    @Around("execution(* com.min.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");

        Signature signature = jp.getSignature();
        System.out.println(signature);
        //执行方法
        Object proceed = jp.proceed();

        System.out.println("环绕后");
    }
}
