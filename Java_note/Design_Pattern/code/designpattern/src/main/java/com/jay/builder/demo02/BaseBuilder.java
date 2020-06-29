package com.jay.builder.demo02;

/**
 * abstract builder
 */
public abstract class BaseBuilder {

    abstract BaseBuilder buildA(String message);

    abstract BaseBuilder buildB(String message);

    abstract BaseBuilder buildC(String message);

    abstract BaseBuilder buildD(String message);

    abstract Product getProduct();

}
