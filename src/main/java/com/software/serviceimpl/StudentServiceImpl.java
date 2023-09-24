package com.software.serviceimpl;


import com.software.dao.StudentDao;
import com.software.entity.Student;
import com.software.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceImpl implements StudentService {
        int no;
        @Autowired
        StudentDao dao;

        @Override
        public void insert(Student student) {
                List<Student> list = dao.findAll();
                System.err.println("Value first time no=================== :"+no);
                for(Student val : list)
                {
                        no = val.getRoll();
                }
                no++;
                System.err.println("Value second time no=================== :"+no);
                student.setRoll(no);
                Student str = dao.save(student);
                System.out.println(student);

               if(str!=null)
                       System.out.println("Data Successfully inserted in database================================");
               else
                       System.out.println("Data not inserted in database================================");
        }

        @Override
        public List<Student> select() {
                List<Student> list = dao.findAll();
                return list;
        }

        @Override
        public void update(Student student) {

        }

        @Override
        public void delete(int roll) {

        }

        @Override
        public Student getById(int roll) {
                Student student = null;
                Optional<Student> opt = dao.findById(roll);
                if(opt.isPresent())
                {
                     student = opt.get();
                }
                return student;
        }

        @Override
        public Student getByName(String name) {
                Student student = new Student();
                student = dao.findByName(name);
                return student;
        }
}
