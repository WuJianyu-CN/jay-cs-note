package com.jay.mapper;

import com.jay.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserLike(String value);

    // get all users
    List<User> getUserList();

    // get user by id
    User getUserById(int id);

    User getUserById2(Map<String, Object> map);

    // insert a new user
    int addUser(User user);

    int addUser2(Map<String, Object> map);

    // update a user
    int updateUser(User user);

    // delete a user
    int deleteUser(int id);
}
