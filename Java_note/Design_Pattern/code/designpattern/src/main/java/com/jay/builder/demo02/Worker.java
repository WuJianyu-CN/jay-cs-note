package com.jay.builder.demo02;

public class Worker extends BaseBuilder {
    private Product product;

    public Worker() {
        this.product = new Product();
    }

    @Override
    BaseBuilder buildA(String message) {
        product.setBuildA(message);
        return this;
    }

    @Override
    BaseBuilder buildB(String message) {
        product.setBuildB(message);
        return this;
    }

    @Override
    BaseBuilder buildC(String message) {
        product.setBuildC(message);
        return this;
    }

    @Override
    BaseBuilder buildD(String message) {
        product.setBuildD(message);
        return this;
    }

    @Override
    Product getProduct( ) {
        return product;
    }
}
