package com.min.diy;

import org.springframework.stereotype.Component;

@Component
public class DiyPointCut {
    public void before(){
        System.out.println("执行前");
    }
    public void after(){
        System.out.println("执行后");
    }
}
