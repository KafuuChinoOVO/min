package com.min.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//等于<bean id="user" class="com.min.pojo.User"/>
//@component 组件
@Component
public class User {
    //等于<property name="name" value="min"/>
    @Value("min")
    public String name;
}
