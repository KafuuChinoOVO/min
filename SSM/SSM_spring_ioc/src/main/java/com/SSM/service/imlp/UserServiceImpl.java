package com.SSM.service.imlp;

import com.SSM.dao.UserDao;
import com.SSM.dao.impl.UserDaoImpl;
import com.SSM.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }

    public void setUserDao(UserDaoImpl userDao) {
    }
}
