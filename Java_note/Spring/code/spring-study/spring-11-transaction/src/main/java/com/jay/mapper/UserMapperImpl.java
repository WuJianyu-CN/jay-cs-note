package com.jay.mapper;

import com.jay.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int addUser(User user) {
        return sqlSessionTemplate.getMapper(UserMapper.class).addUser(user);

    }

    @Override
    public int deleteUser(int id) {
        return sqlSessionTemplate.getMapper(UserMapper.class).deleteUser(id);
    }

    @Override
    public List<User> selectUser() {
        User lily = new User(7, "lily", "123456");

        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        mapper.addUser(lily);
        mapper.deleteUser(7);
        return mapper.selectUser();
    }
}
