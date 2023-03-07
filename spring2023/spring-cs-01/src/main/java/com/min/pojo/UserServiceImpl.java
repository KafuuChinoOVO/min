package com.min.pojo;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加数据");
    }

    @Override
    public void delete() {
        System.out.println("删除数据");
    }

    @Override
    public void update() {
        System.out.println("更新数据");
    }

    @Override
    public void select() {
        System.out.println("查找数据");
    }
}
