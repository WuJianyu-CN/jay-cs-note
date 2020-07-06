package com.jay.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl = context.getBean("bookServiceImpl", BookServiceImpl.class);
        bookServiceImpl.queryAllBook().forEach(System.out::println);
    }

}