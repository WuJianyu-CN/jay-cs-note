package com.jay.bridge;

/**
 * concrete computer: Desktop
 */
public class Desktop extends Computer {
    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Desktop");
    }
}
