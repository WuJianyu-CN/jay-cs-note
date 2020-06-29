package com.jay.service;

import com.jay.dao.UserDao;

public interface UserService {

    void setUserDao(UserDao userDao);

    void getUser();
}
