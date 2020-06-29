package com.jay.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private int id;
    private String name;

    // a teacher should collect several students
    private List<Student> students;
}
