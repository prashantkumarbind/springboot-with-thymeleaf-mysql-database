package com.software.serviceimpl;

import com.software.dao.AdminDao;
import com.software.entity.Admin;
import com.software.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminServiceImpl implements AdminService {

        @Autowired
        AdminDao dao;

    @Override
    public boolean checkAdminLogin(Admin admin) {
        boolean result = false;
        System.out.println("input data :: "+admin);
        Optional<Admin> opt = dao.findById(admin.getPassword());
        System.out.println("select method already executed============="+opt);
        if(opt.isPresent())
        {
              System.out.println("isPresent method executed=================");
              Admin ob1 = opt.get();
              System.out.println("Admin Id number ::"+admin+"=="+ob1);
              if(ob1.getId().equalsIgnoreCase(admin.getId()) && ob1.getPassword().equalsIgnoreCase(admin.getPassword()))
              {
                  System.out.println("verified successfully");
                  result = true;
                  System.out.println("admin login success");
              }
        }
            return result;
    }
}
