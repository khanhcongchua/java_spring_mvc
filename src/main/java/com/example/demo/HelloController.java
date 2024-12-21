package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }


    @GetMapping("/admin")
    public String admin() {
        return "Just Admin Access this admin page";
    }

    @GetMapping("/user")
    public String user() {
        return "Just User access this user page";
    }
    
    
}