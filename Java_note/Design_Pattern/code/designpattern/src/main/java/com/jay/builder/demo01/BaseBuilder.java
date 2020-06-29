package com.jay.builder.demo01;

/**
 * abstract Builder: declare method
 */
public abstract class BaseBuilder {

    abstract void buildA();

    abstract void buildB();

    abstract void buildC();

    abstract void buildD();

    /**
     * accomplished
     */
    abstract Product getProduct();

}
