package com.jay.mapper;

import com.jay.pojo.User;
import com.jay.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void getUserLike() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.getUserLike("ja");
            users.forEach(System.out::println);
        }
    }

    @Test
    public void getUserList() {

        // step1: get sqlSession instance
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {

            // method1: get userMapper execute sql statement
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            for (User user : userList) {
                System.out.println(user);
            }
        }// close sqlSession
    }


    @Test
    public void getUserById() {

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = mapper.getUserById(1);
            System.out.println(user);

        }
    }

    @Test
    public void getUserById2() {

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("helloId", 1);
            map.put("name", "com.jay");

            User user = mapper.getUserById2(map);
            System.out.println(user);

        }
    }

    // update insert delete should commit transaction
    @Test
    public void addUser() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            int res = mapper.addUser(new User(4, "bob", "111222"));
            if (res > 0) {
                System.out.println("insert user success!");
            }

            // commit transaction
            sqlSession.commit();
        }
    }

    @Test
    public void addUser2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("userid", 5);
            map.put("userName", "peter");
            map.put("password", "111222");
            mapper.addUser2(map);

            sqlSession.commit();
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.updateUser(new User(4, "alice", "123123"));

            sqlSession.commit();
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUser(4);

            sqlSession.commit();
        }
    }

}
