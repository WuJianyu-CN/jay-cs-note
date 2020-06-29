package com.jay.mapper;

import com.jay.pojo.Student;
import com.jay.pojo.Teacher;
import com.jay.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MapperTest {
    @Test
    public void test1() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher1 = mapper.getTeacher(1);
            System.out.println(teacher1);
        }
    }

    @Test
    public void studentMapper() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = mapper.getStudent();

            students.forEach(System.out::println);
        }
    }

    @Test
    public void studentMapper2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = mapper.getStudent2();

            students.forEach(System.out::println);
        }
    }

}