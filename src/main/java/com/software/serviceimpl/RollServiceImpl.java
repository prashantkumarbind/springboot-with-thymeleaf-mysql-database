package com.software.serviceimpl;

import com.software.dao.StudentDao;
import com.software.entity.Roll;
import com.software.entity.Student;
import com.software.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.OptionalLong;

@Component
public class RollServiceImpl implements RollService {

    @Autowired
    StudentDao studentDao;

    @Override
    public Student searchByRoll(Roll roll) {
        Student student=null;
        Optional<Student> opt = studentDao.findById(Integer.parseInt(roll.getRoll()));
        if(opt.isPresent())
        {
              student = opt.get();
        }
        return student;
    }
}
