package com.jay.mapper;

import com.jay.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    // query
    User queryUserById(@Param("id") int id);

    // update
    int updateUser(User user);
}
