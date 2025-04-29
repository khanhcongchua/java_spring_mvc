package com.example.demo.controller.client;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.domain.dto.RegisterDTO;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HomePageController {
    private ProductService productService;
    private UserService userService;
    private final PasswordEncoder passwordEncoder;



    public HomePageController(ProductService productService, UserService userService,PasswordEncoder passwordEncoder){
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    


    @GetMapping("/")
    public String getHomePage(Model model){
        List<Product> flowers = this.productService.getAllProducts();
        model.addAttribute("flowers1", flowers);//(gia tri nhan duoc ben  view, gia tri ben controller)
        return "client/homepage/show";
    }


    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("registerUser") @Valid RegisterDTO registerDTO,
                                BindingResult bindingresult
                                ) {
        

        if(bindingresult.hasErrors()){
            return "client/auth/register";
        }
        
        List<FieldError> errors = bindingresult.getFieldErrors();
        for(FieldError error : errors){
            System.out.println( ">>>>>>>>>>>>>>>>>>>>>>>>>......" + error.getField() + "-" + error.getDefaultMessage() );
        }
                            


        User user = this.userService.registerDTOtoUser(registerDTO);
        
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        

        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName("USER"));

        //save user
        this.userService.handlSaveUser(user);
        return "redirect:/login";

    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "client/auth/login";
    }

    


}
