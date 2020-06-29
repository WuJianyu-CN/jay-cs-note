package com.jay.bridge;

/**
 * abstract Computer class
 */
public abstract class Computer {

    // composition, Brand
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void info() {
        brand.brandInfo();
    }
}
