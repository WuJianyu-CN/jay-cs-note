package com.jay.factory.abstract1;

public class XiaomiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("start xiaomi router");
    }

    @Override
    public void shutdown() {
        System.out.println("shutdown xiaomi router");
    }

    @Override
    public void openWifi() {
        System.out.println("xiaomi router open wifi");
    }

    @Override
    public void setting() {
        System.out.println("xiaomi router setting");
    }
}
