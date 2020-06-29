package com.jay.factory.abstract1;

public class HuaweiFactory implements IProductFactory {
    @Override
    public IPhoneProduct iPhoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public IRouterProduct iRouterProduct() {
        return new HuaweiRouter();
    }
}
