package com.jay.pojo;

import com.jay.config.JayConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JayConfig.class);
        User user = context.getBean("user", User.class);

        System.out.println(user);
    }
}