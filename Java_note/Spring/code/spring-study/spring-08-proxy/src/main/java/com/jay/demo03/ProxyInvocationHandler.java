package com.jay.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * automatically generate proxy instance
 *
 * @author jay
 */
public class ProxyInvocationHandler implements InvocationHandler {

    /**
     * proxy interface
     */
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    /**
     * generate proxy instance
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(),
                this
        );
    }

    /**
     * Processes a method invocation on a proxy instance and returns the result.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        showHouse();
        // dynamic proxy's essence: reflection
        Object result = method.invoke(rent, args);
        return result;
    }

    public void showHouse() {
        System.out.println("Agency shows house.");
    }
}
