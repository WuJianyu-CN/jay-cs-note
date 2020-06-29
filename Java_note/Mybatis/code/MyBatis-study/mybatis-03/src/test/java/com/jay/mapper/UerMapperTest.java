package com.jay.mapper;

import com.jay.mapper.UserMapper;
import com.jay.pojo.User;
import com.jay.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UerMapperTest {


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
}
