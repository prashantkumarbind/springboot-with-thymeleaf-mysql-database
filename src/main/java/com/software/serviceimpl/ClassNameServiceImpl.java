package com.software.serviceimpl;

import com.software.dao.StudentDao;
import com.software.entity.Student;
import com.software.service.ClassNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassNameServiceImpl implements ClassNameService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> searchByClassName(String className) {
        return null;
    }
}
