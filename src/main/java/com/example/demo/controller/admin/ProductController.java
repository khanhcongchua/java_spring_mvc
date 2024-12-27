package com.example.demo.controller.admin;

import java.text.AttributedCharacterIterator.Attribute;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.service.ProductService;
import com.example.demo.service.UploadService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService  uploadService;

    public ProductController(
        ProductService productService,
        UploadService  uploadService
    ){
        this.productService = productService;
        this.uploadService = uploadService;
    }
    
    @GetMapping("/admin/product")
    public String getProducts(){
        return "admin/product/show";  
    }



    @RequestMapping("/admin/product/create")//GET
    public String getCreateProductPage(Model model){
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }


    @RequestMapping(value = "/admin/product/create", method = RequestMethod.POST)//POST
    public String createProductPage(Model model, 
                                @Valid @ModelAttribute("newProduct")  Product flower,
                                BindingResult newProductbindingResult,
                                @RequestParam("hoidanitFile") MultipartFile file
                                
                                )
                                
    {
        List<FieldError> errors = newProductbindingResult.getFieldErrors();
        for(FieldError error : errors){
            System.out.println( ">>>>>>>>>>>>>>>>>>>>>>>>>......" + error.getField() + "-" + error.getDefaultMessage() );
        }

        if(newProductbindingResult.hasErrors()){
            return "admin/product/create";
        }


        String avatar = this.uploadService.handleSaveUploadFile(file, "products");     
        // String hashPassword = this.passwordEncoder.encode(hoidanit.getPassword());
        

        flower.setImage(avatar);
        // hoidanit.setPassword(hashPassword);
        // flower.setRole(this.productService.getRoleByName(flower.getRole().getName()));

        //save user
        this.productService.handlSaveProduct(flower);
        return "redirect:/admin/product";
    }


}