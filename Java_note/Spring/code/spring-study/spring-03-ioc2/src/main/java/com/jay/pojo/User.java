package com.jay.pojo;

public class User {
    private String name;
    private String address;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
        System.out.println("User's constructor with two parameters");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void show() {
        System.out.println("Hello " + name + " in " + address);
    }
}
