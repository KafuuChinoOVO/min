package com.SSM.demo;

import com.SSM.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new FileSystemXmlApplicationContext("D:\\project\\SSM\\SSM_spring_ioc\\src\\main\\resources\\applicationContext.xml");
//        UserService userService = app.getBean(UserService.class);
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
