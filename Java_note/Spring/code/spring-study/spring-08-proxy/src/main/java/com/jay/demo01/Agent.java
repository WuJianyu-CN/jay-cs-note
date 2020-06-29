package com.jay.demo01;

public class Agent implements Rent {
    private Landlord landlord;

    public Agent() {
    }

    public Agent(Landlord landlord) {
        this.landlord = landlord;
    }

    public void showHouse() {
        System.out.println("Agent shows you the house.");
    }

    public void agencyFee() {
        System.out.println("Agent charges agency fee.");
    }

    public void signContrast() {
        System.out.println("Agent signs a contrast with you.");
    }

    @Override
    public void rent() {
        showHouse();
        agencyFee();
        signContrast();
        landlord.rent();
    }
}
