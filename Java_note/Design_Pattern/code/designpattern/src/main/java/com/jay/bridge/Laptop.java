package com.jay.bridge;

/**
 * concrete computer: Laptop
 */
public class Laptop extends Computer {
    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Laptop");
    }
}
