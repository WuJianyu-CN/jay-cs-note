package com.jay.factory.abstract1;

public class Client {
    public static void main(String[] args) {
        System.out.println("=======================xiaomi=======================");

        // xiaomi factory
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IPhoneProduct iPhoneProduct = xiaomiFactory.iPhoneProduct();
        iPhoneProduct.callup();
        iPhoneProduct.sendSMS();
        IRouterProduct iRouterProduct = xiaomiFactory.iRouterProduct();
        iRouterProduct.openWifi();
        iRouterProduct.setting();

        System.out.println("=======================huawei=======================");

        // xiaomi factory
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        IPhoneProduct iPhoneProduct1 = huaweiFactory.iPhoneProduct();
        iPhoneProduct1.sendSMS();
        iPhoneProduct1.callup();
        IRouterProduct iRouterProduct1 = huaweiFactory.iRouterProduct();
        iRouterProduct1.openWifi();
        iRouterProduct1.setting();
    }
}
