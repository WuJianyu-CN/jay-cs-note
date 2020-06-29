package com.jay.demo04;

import com.jay.demo02.UserService;
import com.jay.demo02.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        ProxyInvocationHandler invocationHandler = new ProxyInvocationHandler();
        invocationHandler.setTarget(userService);

        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.query();
    }

}
