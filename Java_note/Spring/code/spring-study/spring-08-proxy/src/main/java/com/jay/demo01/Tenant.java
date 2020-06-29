package com.jay.demo01;

public class Tenant {
    public static void main(String[] args) {
        Landlord landlord = new Landlord();

        Agent agent = new Agent(landlord);
        agent.rent();
    }
}
