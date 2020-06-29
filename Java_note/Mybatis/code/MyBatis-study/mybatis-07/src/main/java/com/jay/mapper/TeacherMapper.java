package com.jay.mapper;

import com.jay.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    // query all teachers
    List<Teacher> getTeachers();

    // query a specific teacher and its students' information
    Teacher getTeacher(@Param("tid") int tid);


    // query a specific teacher and its students' information
    Teacher getTeacher2(@Param("tid") int tid);
}
