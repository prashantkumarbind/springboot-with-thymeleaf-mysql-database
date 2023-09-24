package com.software.controller;

import com.software.entity.Name;
import com.software.entity.Student;
import com.software.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NameController {

        List<Student> list;
        @Autowired
        NameService service;

        @PostMapping("/checkbyname")
        public String checkDataByName(@ModelAttribute("search") Name name){
               list = service.searchByName(name.getName());
               return "redirect:/namedata";
        }

        @GetMapping("/namedata")
        public String nameDataMultiple(Model model){
               model.addAttribute("aboutData", list);
               return "viewdata.html";
        }
}
