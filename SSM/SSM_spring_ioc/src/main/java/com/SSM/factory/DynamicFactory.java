package com.SSM.factory;

import com.SSM.dao.UserDao;
import com.SSM.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
