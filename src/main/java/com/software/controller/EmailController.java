package com.software.controller;


import com.software.entity.Email;
import com.software.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

          @Autowired
          EmailService service;
          @GetMapping("/email")
          public String email(Model model){
              Email email = new Email();
              model.addAttribute(("email"), email);
              return "forgot.html";
          }

          @PostMapping("/checkemail")
          public String checkEmail(@ModelAttribute("email") Email email){
                 boolean result = service.emailChecking(email.getEmail());
                 if(result==true)
                     return "redirect:/";
                 else
                     return "redirect:/email";
          }
}
