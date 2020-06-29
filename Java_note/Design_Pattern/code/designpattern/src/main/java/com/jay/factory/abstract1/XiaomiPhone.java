package com.jay.factory.abstract1;

public class XiaomiPhone implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("start xiaomi phone");
    }

    @Override
    public void shutdown() {
        System.out.println("shutdown start xiaomi phone");
    }

    @Override
    public void callup() {
        System.out.println("xiaomi phone call up");
    }

    @Override
    public void sendSMS() {
        System.out.println("xiaomi phone send SMS");
    }
}
