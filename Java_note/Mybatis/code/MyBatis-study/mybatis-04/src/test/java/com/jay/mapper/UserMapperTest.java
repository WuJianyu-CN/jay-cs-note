package com.jay.mapper;

import com.jay.mapper.UserMapper;
import com.jay.pojo.User;
import com.jay.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

    @Test
    public void getUserById() {
        //  SELECT * FROM mybatis.user WHERE id = #{id}
        // TypeHandler
        // select id, name, pwd from mybatis.user where id = #{id}

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(3);
            System.out.println(user);
        }
    }

    @Test
    public void getUserByLimit() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Integer> map = new HashMap<>();
            map.put("startIndex", 1);
            map.put("pageSize", 3);
            List<User> users = mapper.getUserByLimit(map);

            users.forEach(System.out::println);
        }
    }

    @Test
    public void getUserByRowBounds() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            RowBounds rowBounds = new RowBounds(1, 2);
            List<User> users = sqlSession.selectList("com.jay.mapper.UserMapper.getUserByRowBounds", null, rowBounds);

            users.forEach(System.out::println);

        }
    }


    @Test
    public void testslf4j() {
        LOGGER.info("slf4j info");
        LOGGER.debug("slf4j debug");
        LOGGER.warn("slf4j warn");
        LOGGER.error("slf4j error");
    }
}
