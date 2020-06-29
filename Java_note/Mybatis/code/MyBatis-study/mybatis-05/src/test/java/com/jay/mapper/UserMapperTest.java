package com.jay.mapper;

import com.jay.pojo.User;
import com.jay.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void getUsers() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            // using reflect
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.getUsers();

            users.forEach(System.out::println);
        }
    }

    @Test
    public void getUserById() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            // using reflect
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);

            System.out.println(user);
        }
    }


    @Test
    public void addUser() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.addUser(new User(6, "peter", "123123"));

        }
    }

    @Test
    public void updateUser() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.updateUser(new User(6, "alice", "123456"));
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.deleteUser(6);
        }
    }

}
