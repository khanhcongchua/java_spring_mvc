package com.example.demo.controller.admin;

import java.text.AttributedCharacterIterator.Attribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;

@Controller
public class ProductController {
    
    @GetMapping("/admin/product")
    public String getProducts(){
        return "admin/product/show";  
    }



    @RequestMapping("/admin/product/create")//GET
    public String getCreateProductPage(Model model){
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }
}