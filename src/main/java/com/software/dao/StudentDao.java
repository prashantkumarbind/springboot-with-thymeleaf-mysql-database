package com.software.dao;

import com.software.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {

        Student findByName(String name);
}
