package com.software.controller;

import com.software.entity.ClassName;
import com.software.entity.Student;
import com.software.service.ClassNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClassNameController {

        List<Student> list;
        @Autowired
        ClassNameService service;

        @PostMapping("/checkbyclass")
        public String checkDataByClassName(@ModelAttribute("search") ClassName className){
               list = service.searchByClassName(className.getClassName());
               return "redirect:/classdata";
        }

        @GetMapping("/classdata")
        public String classDataMultiple(Model model){
               model.addAttribute("aboutdata", list);
               return "viewdata.html";
        }
}
