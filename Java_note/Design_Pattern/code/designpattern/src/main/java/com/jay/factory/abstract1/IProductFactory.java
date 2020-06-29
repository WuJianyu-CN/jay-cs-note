package com.jay.factory.abstract1;

/**
 * abstract product factory
 */
public interface IProductFactory {
    // produce phone
    IPhoneProduct iPhoneProduct();

    // produce router
    IRouterProduct iRouterProduct();
}
