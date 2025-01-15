package com.example.demo.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;

@Controller
public class ItemController {
    
    // @GetMapping("/client/product/{id}")
    // public String getProducts(Model model, @PathVariable long id){
    //     return "client/product/detail";  
    // }
    private ProductService productService;

    public ItemController(ProductService productService){
        this.productService = productService;
    }
    

    @GetMapping("/product/{id}")  
    public String getItemPage(Model model, @PathVariable long id) {  
        Product flower = this.productService.getProductById(id).get();
        model.addAttribute("flower", flower); 
        return "client/product/detail";
    }
    



}
