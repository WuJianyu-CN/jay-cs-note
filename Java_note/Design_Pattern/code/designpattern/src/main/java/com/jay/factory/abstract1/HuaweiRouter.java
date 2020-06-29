package com.jay.factory.abstract1;

public class HuaweiRouter implements IRouterProduct{
    @Override
    public void start() {
        System.out.println("start huawei router");
    }

    @Override
    public void shutdown() {
        System.out.println("shutdown huawei router");
    }

    @Override
    public void openWifi() {
        System.out.println("huawei router open wifi");
    }

    @Override
    public void setting() {
        System.out.println("huawei router setting");
    }
}
