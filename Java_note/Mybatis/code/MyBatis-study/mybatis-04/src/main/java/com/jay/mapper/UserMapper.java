package com.jay.mapper;

import com.jay.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // get user by id
    User getUserById(int id);

    // page limit
    List<User> getUserByLimit(Map<String, Integer> map);

    // page limit by row bounds
    List<User> getUserByRowBounds(Map<String, Integer> map);
}
