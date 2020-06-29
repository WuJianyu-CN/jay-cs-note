package com.jay.mapper;

import com.jay.pojo.Student;

import java.util.List;

public interface StudentMapper {

    // return all student information, associate with teacher information
    List<Student> getStudent();

    List<Student> getStudent2();
}
