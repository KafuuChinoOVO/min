package com.min.pojo;

public class Proxys implements UserService {
    private UserServiceImpl userServiceImpl;


    public Proxys(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void calculation() {
        System.out.println("11");
        userServiceImpl.calculation();
    }

    @Override
    public void calculation1() {

    }

    @Override
    public void calculation2() {

    }

    @Override
    public void calculation3() {

    }
}
