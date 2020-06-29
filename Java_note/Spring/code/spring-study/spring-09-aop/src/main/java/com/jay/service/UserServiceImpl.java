package com.jay.service;

public class UserServiceImpl implements UserService {

    @Override
    public void insert() {
        System.out.println("insert a new user.");
    }

    @Override
    public void delete() {
        System.out.println("delete a user.");
    }

    @Override
    public void update() {
        System.out.println("update a user.");
    }

    @Override
    public void select() {
        System.out.println("select a user.");
    }
}
