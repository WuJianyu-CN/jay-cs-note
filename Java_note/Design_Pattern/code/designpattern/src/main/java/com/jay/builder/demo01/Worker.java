package com.jay.builder.demo01;

/**
 * concrete builder: worker
 */
public class Worker extends BaseBuilder {

    private Product product;

    public Worker() {
        product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("buildA");
        System.out.println("buildA");
    }

    @Override
    void buildB() {
        product.setBuildB("buildB");
        System.out.println("buildB");
    }

    @Override
    void buildC() {
        product.setBuildC("buildC");
        System.out.println("buildC");
    }

    @Override
    void buildD() {
        product.setBuildD("buildD");
        System.out.println("buildD");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
