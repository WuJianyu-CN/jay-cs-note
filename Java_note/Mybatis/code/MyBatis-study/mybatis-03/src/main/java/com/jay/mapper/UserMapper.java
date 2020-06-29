package com.jay.mapper;

import com.jay.pojo.User;

import java.util.List;

public interface UserMapper {
    // get all users
    List<User> getUserList();

    // get user by id
    User getUserById(int id);

    // insert a new user
    int addUser(User user);

    // update a user
    int updateUser(User user);

    // delete a user
    int deleteUser(int id);
}
