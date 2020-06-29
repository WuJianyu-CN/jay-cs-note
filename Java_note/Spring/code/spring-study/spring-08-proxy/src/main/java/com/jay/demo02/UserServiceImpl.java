package com.jay.demo02;


public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("Add a user.");
    }

    @Override
    public void delete() {
        System.out.println("Delete a user.");
    }

    @Override
    public void update() {
        System.out.println("Update a user.");
    }

    @Override
    public void query() {
        System.out.println("Query a user.");
    }
}
