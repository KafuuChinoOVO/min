package com.min.pojo;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public void calculation() {
        System.out.println("调用calculation");
    }

    @Override
    public void calculation1() {
        System.out.println("调用calculation1");
    }

    @Override
    public void calculation2() {
        System.out.println("调用calculation2");
    }

    @Override
    public void calculation3() {
        System.out.println("调用calculation3");
    }
}
