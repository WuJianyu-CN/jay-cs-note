package com.jay.factory.abstract1;

public class HuaweiPhone implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("start huawei phone");
    }

    @Override
    public void shutdown() {
        System.out.println("shutdown start huawei phone");
    }

    @Override
    public void callup() {
        System.out.println("huawei phone call up");
    }

    @Override
    public void sendSMS() {
        System.out.println("huawei phone send SMS");
    }
}
