package com.jay.service;

import com.jay.dao.UserDao;
import com.jay.dao.UserDaoImpl;
import com.jay.dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // dynamically injection
    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
