package com.jay.factory.simple;

public class Consumer {
    public static void main(String[] args) {
        // interface and implementation class
//        Car car1 = new WuLing();
//        Car car2 = new Tesla();

        // 2. get car from CarFactory
        Car car1 = CarFactory.getCar("wuling");
        Car car2 = CarFactory.getCar("tesla");

        car1.name();
        car2.name();
    }
}
