package com.jay.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class HelloTest {

    @Test
    public void hello() {
        // get spring context instance, Instantiating a Container
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // Spring container manages all objects
        Hello hello = (Hello) context.getBean("hello");

        System.out.println(hello);
    }

}