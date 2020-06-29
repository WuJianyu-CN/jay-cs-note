package com.jay.factory.simple;

import java.util.Objects;

/**
 * static factory pattern doesn't obey Open-Closed Principle
 * You have to modify CarFactory when you add a new car product
 */
public class CarFactory {

    public static Car getCar(String car) {
        if (Objects.equals(car, "wuling")) {
            return new WuLing();
        } else if (Objects.equals(car, "tesla")) {
            return new Tesla();
        } else {
            return null;
        }
    }

    public static Car getWuling() {
        return new WuLing();
    }

    public static Car getTesla() {
        return new Tesla();
    }

    public static Car getDazhong() {
        return new Dazhong();
    }
}
