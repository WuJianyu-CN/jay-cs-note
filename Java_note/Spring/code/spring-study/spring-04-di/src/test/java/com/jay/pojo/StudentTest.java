package com.jay.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");

        System.out.println(student);
        /*
         Student{name='Jay',
         address=Address{address='Nanjing'},
         books=[san guo yan yi, shui hu zhuan, xi you ji, hong lou meng],
         hobbies=[singing, coding, dancing],
         card={ID=111111222222223333, ICBC=123123},
         games=[LOL, KOF],
         wife='null',
         info={name=Jay, sid=MP1833034}}
         */
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user == user2);

    }
}