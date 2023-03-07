package com.min.dao;

public class UserDaoOracleImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("Oracle调用");
    }
}
