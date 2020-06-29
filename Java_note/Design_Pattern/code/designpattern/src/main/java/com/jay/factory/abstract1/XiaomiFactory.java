package com.jay.factory.abstract1;

public class XiaomiFactory implements IProductFactory {
    @Override
    public IPhoneProduct iPhoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public IRouterProduct iRouterProduct() {
        return new XiaomiRouter();
    }
}
