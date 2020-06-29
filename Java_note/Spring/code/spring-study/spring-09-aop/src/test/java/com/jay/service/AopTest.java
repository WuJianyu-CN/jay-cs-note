package com.jay.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AopTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // dynamic proxy returns a interface
        UserService userService = context.getBean("userService", UserService.class);
        userService.insert();

    }

}