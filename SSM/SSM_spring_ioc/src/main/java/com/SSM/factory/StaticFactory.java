package com.SSM.factory;

import com.SSM.dao.UserDao;
import com.SSM.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
