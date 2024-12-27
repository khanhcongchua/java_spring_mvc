package com.example.demo.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {
    
    // @GetMapping("/client/product/{id}")
    // public String getProducts(Model model, @PathVariable long id){
    //     return "client/product/detail";  
    // }

    @GetMapping("/product/{id}")  
    public String getProductPage(Model model, @PathVariable long id) {  
        return "client/product/detail";  
    }

}
