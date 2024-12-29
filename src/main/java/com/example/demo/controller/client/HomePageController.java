package com.example.demo.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;

@Controller
public class HomePageController {
    private ProductService productService;

    public HomePageController(ProductService productService){
        this.productService = productService;
    }
    


    @GetMapping("/")
    public String getHomePage(Model model){
        List<Product> flowers = this.productService.getAllProducts();
        model.addAttribute("flowers1", flowers);//(gia tri nhan duoc ben  view, gia tri ben controller)
        return "client/homepage/show";
    }


   
}
