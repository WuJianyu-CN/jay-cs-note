package com.jay.pojo;

public class User2 {
    private String name;
    private String address;

    public User2() {
        System.out.println("User2's constructor");
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
