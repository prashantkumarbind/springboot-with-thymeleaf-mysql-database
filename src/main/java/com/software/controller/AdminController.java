package com.software.controller;

import com.software.entity.Admin;
import com.software.serviceimpl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

        @Autowired
        AdminServiceImpl service;

        @ResponseBody
        @GetMapping("/check/{name}")
        public String check(@PathVariable String name) {

            return "Beta tumhara Name::"+name;
        }

        @GetMapping("/")
        public String adminLogin(Model model){
               Admin admin = new Admin();
               model.addAttribute("admin" , admin);
               System.err.println("step first");
               return "login.html";
        }

        @PostMapping("/admin")
        public String getAdminObject(@ModelAttribute ("admin") Admin admin){
            System.out.println("admin api calling===================================");
               boolean result = service.checkAdminLogin(admin);
               if(result)
               {
                   return "index.html";
               }
               return "login.html";
        }


}
