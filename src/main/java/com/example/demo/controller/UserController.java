package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
public class UserController {


    // DI: Dependancy Injection
    private UserService userService;

    


    public UserController(UserService userService) {
        this.userService = userService;
    }




    @GetMapping("/")
    public String getHomePage(){
        return this.userService.handleHello();
    }
}
