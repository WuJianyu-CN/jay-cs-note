package com.jay.demo03;

public class Client {

    public static void main(String[] args) {
        // real character
        Landlord landlord = new Landlord();

        // proxy character
        ProxyInvocationHandler invocationHandler = new ProxyInvocationHandler();

        invocationHandler.setRent(landlord);
        // get dynamic proxy
        Rent proxy = (Rent) invocationHandler.getProxy();

        proxy.rent();
    }
}
