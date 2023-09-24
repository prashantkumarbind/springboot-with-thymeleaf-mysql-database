package com.software.service;

import com.software.entity.Student;

import java.util.List;

public interface NameService {

        List<Student> searchByName(String name);
}
