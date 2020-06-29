package com.jay.demo01;

public class Landlord implements Rent{

    @Override
    public void rent() {
        System.out.println("Landlord rents a house.");
    }
}
