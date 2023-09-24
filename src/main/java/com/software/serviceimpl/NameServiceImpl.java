package com.software.serviceimpl;

import com.software.dao.StudentDao;
import com.software.entity.Student;
import com.software.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NameServiceImpl implements NameService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> searchByName(String name) {
        return null;
    }
}
