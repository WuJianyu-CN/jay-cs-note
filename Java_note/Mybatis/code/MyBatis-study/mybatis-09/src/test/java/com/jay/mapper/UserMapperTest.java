package com.jay.mapper;

import com.jay.pojo.User;
import com.jay.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void queryUserById() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = mapper.queryUserById(1);
            System.out.println(user);
            System.out.println("=========================");

//            mapper.updateUser(new User(2, "alice", "123123"));

            System.out.println("sqlSesion.clearCache()");
            sqlSession.clearCache();

            System.out.println("=========================");
            User user2 = mapper.queryUserById(1);
            System.out.println(user2);
        }
    }

    @Test
    public void queryUserById2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user1 = mapper.queryUserById(1);
            System.out.println(user1);

            User user2 = mapper.queryUserById(1);
            System.out.println(user2);
        }

        System.out.println("=======================================");

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user1 = mapper.queryUserById(1);
            System.out.println(user1);

            User user2 = mapper.queryUserById(1);
            System.out.println(user2);
        }
    }

}