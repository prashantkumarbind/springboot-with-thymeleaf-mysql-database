package com.software.controller;

import com.software.entity.Roll;
import com.software.entity.Student;
import com.software.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RollController {

        Student student;
        @Autowired
        RollService service;

        @PostMapping("/checkbyroll")
        public String checkDataByRoll(@ModelAttribute("rollobject") Roll roll){
            System.err.println("checkbyroll executed*********************************************************");
               student = service.searchByRoll(roll);
               return "redirect:/rolldata";
        }

        @GetMapping("/rolldata")
        public String  rollDataSingle(Model model){
            System.err.println("roll data executed*********************************************************");
               model.addAttribute("aboutdata" ,student);
               return "viewdata.html";
        }
}
