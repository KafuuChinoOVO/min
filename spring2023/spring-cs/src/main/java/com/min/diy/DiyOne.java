package com.min.diy;

import org.springframework.stereotype.Component;

@Component
public class DiyOne {
    public void before(){
        System.out.println("执行之前~");
    }
    public void after(){
        System.out.println("执行之后~");
    }
}
