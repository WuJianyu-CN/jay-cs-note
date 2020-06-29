package com.jay.mapper;

import com.jay.pojo.User;
import com.jay.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UerMapperTest {

    @Test
    public void getUserList() {

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<User> users = mapper.getUserList();
            users.forEach(System.out::println);

        }
    }
}
