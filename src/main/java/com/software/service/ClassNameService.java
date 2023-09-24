package com.software.service;

import com.software.entity.Student;

import java.util.List;

public interface ClassNameService {

        List<Student> searchByClassName(String className);
}
