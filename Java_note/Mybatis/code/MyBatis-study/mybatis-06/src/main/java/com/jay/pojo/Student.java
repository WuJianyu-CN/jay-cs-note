package com.jay.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;

    // student should associate a teacher
    private Teacher teacher;
}
