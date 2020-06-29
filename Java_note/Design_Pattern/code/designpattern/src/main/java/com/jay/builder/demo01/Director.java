package com.jay.builder.demo01;

/**
 * director
 */
public class Director {

    /**
     * define build process sequence
     */
    public Product build(BaseBuilder builder) {
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();

        return builder.getProduct();
    }
}
