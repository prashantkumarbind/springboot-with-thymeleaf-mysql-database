package com.software.serviceimpl;

import com.software.service.EmailService;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {


    @Override
    public boolean emailChecking(String email) {
        if(email.equals("india@gmail.com"))
            return true;
        else
            return false;
    }
}
