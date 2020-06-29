package com.jay.mapper;

import com.jay.pojo.Teacher;
import com.jay.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MapperTest {

    @Test
    public void test() {

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            sqlSession.getMapper(TeacherMapper.class)
                    .getTeachers()
                    .forEach(System.out::println);
        }
    }

    @Test
    public void test1() {

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.getTeacher(1);
            System.out.println(teacher);
        }
    }

    @Test
    public void test2() {

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.getTeacher2(1);
            System.out.println(teacher);
        }
    }
}
