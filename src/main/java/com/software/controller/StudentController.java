package com.software.controller;

import com.software.entity.ClassName;
import com.software.entity.Name;
import com.software.entity.Roll;
import com.software.entity.Student;
import com.software.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

        static int rollnumber;
        static String name;
        @Autowired
        StudentService service;

        @GetMapping("/admission")
        public String insert(Model model){
            Student ob1 = new Student();
            model.addAttribute(("student"), ob1);
            return "admission.html";
        }

        @PostMapping("/save")
        public String save(@ModelAttribute("student") Student student){
               service.insert(student);
               return "redirect:/admission";
        }

        @GetMapping("/view")
        public String viewAllData(Model model){
               model.addAttribute("student", service.select());
               return "viewdata.html";
        }

        /* ======**========**========**====== search by roll =========**=========**==========**==========***/
        @GetMapping("/byroll")
        public String byroll(Model model){
               Student student = new Student();
               model.addAttribute("student",student);
               return "viewdata.html";
        }

        @GetMapping("/getrollobject")
        public String getRollObject(@ModelAttribute("student") Student student){
               System.err.println("Your Input Roll Number::"+student.getRoll());
               rollnumber = student.getRoll();
               return "redirect:/searchbyroll";
        }

        @GetMapping("/searchbyroll")
        public String searchbyroll(Model model){
               Student student = new Student();
               model.addAttribute("student", service.getById(rollnumber));
               return "viewdata.html";
        }

        /* ======**=======**=======** Search By Name====**======**=======**=====**======**=====*/
        @GetMapping("/byname")
        public String byName(Model model){
               Student student = new Student();
               model.addAttribute("student",student);
               return "redirect:/viewdata.html";
        }

        @GetMapping("/getnameobject")
        public String getNameObeject(@ModelAttribute("student") Student student){
               name = student.getName();
               System.out.println("Your input name is the ::"+student.getName());
               return "redirect:/searchbyname";
        }

        @GetMapping("/searchbyname")
        public String searchByName(Model model){
               Student student = new Student();
               model.addAttribute("student",service.getByName(name));
               return "viewdata.html";
        }
        /*  ==========**===========**========** Search By Class=======**======**=======**=====**=======*/

}
