package com.jay.service;

import com.jay.dao.UserDaoImpl;
import com.jay.dao.UserDaoMysqlImpl;
import com.jay.dao.UserDaoSqlserverImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Test
    public void test1() {

        // Users have no need to know dao layer
        UserService userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoSqlserverImpl());
        userService.getUser();
    }


    @Test
    public void test2() {
        // new ApplicationContext: initiate spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // get bean: get instance from spring container
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");

        userServiceImpl.getUser();
    }
}