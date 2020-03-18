package com.ordersystem.controller;

import com.ordersystem.entity.Admin;
import com.ordersystem.entity.User;
import com.ordersystem.repository.AdminRepository;
import com.ordersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    /*多态的体现*/
    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type){
        Object object = null;
        switch (type){
            case "user":
                object =  this.userRepository.login(username,password);
                break;
            case "admin":
                object = this.adminRepository.login(username,password);
                break;
        }
        return object;
    }

}
