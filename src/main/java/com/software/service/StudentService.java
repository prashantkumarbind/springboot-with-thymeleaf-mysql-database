package com.software.service;

import com.software.entity.Student;

import java.util.List;

public interface StudentService {

        void insert(Student student);
        List<Student> select();
        void update(Student student);
        void delete(int roll);
        Student getById(int roll);
        Student getByName(String name);
}
