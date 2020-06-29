package com.jay.factory.method;

public class MobikeFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Mobike();
    }
}
