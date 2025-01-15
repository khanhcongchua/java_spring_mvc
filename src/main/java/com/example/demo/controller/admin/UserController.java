package com.example.demo.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UploadService;
import com.example.demo.service.UserService;

import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;


@Controller
public class UserController {
    // DI: Dependancy Injection
    private final UserService userService;
    private final UploadService  uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(
        UserService userService, 
        UploadService  uploadService,
        PasswordEncoder passwordEncoder
    ) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/")
    public String getHomePage(Model model){
        List<User> arrUsers = this.userService.getAllUsersByEmail("nduykhanh650@gmail.com");
        System.out.println(arrUsers);
        model.addAttribute("eric", "test");
        model.addAttribute("hoidanit", "from with model");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model){
        List<User> users = this.userService.getAllUsers();
        System.out.println(">>>>check userlist : " + users);
        model.addAttribute("users1", users);//(gia tri nhan duoc ben  view, gia tri ben controller)
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/create")//GET
    public String getCreateUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }


    @RequestMapping("/admin/user/{id}")//GET
    public String getUserDetailPage(Model model, @PathVariable long id){
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user); 
        return "admin/user/detail";
    }

    @RequestMapping("/admin/user/update/{id}")//GET
    public String getUpdateUserPage(Model model, @PathVariable long id){
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser); 
        return "admin/user/update";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)//POST
    public String createUserPage(Model model, 
                                @Valid @ModelAttribute("newUser")  User hoidanit,
                                BindingResult newUserbindingResult,
                                @RequestParam("hoidanitFile") MultipartFile file
                                
                                )
                                
    {
        List<FieldError> errors = newUserbindingResult.getFieldErrors();
        for(FieldError error : errors){
            System.out.println( ">>>>>>>>>>>>>>>>>>>>>>>>>......" + error.getField() + "-" + error.getDefaultMessage() );
        }

        if(newUserbindingResult.hasErrors()){
            return "admin/user/create";
        }


        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");     
        String hashPassword = this.passwordEncoder.encode(hoidanit.getPassword());
        

        hoidanit.setAvatar(avatar);
        hoidanit.setPassword(hashPassword);
        hoidanit.setRole(this.userService.getRoleByName(hoidanit.getRole().getName()));

        //save user
        this.userService.handlSaveUser(hoidanit);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/user/update")//POST
    public String postUpdateUser(Model model,@ModelAttribute("newUser") User hoidanit){

        User currentUser = this.userService.getUserById(hoidanit.getId());
        
        if(currentUser != null){
            currentUser.setFullName(hoidanit.getFullName());
            currentUser.setAddress(hoidanit.getAddress());
            currentUser.setPhone(hoidanit.getPhone());

            this.userService.handlSaveUser(currentUser);
        }        
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")//GET
    public String getDeleteUserPage(Model model, @PathVariable long id){
        model.addAttribute("id", id); 

        // User user = new User();
        // user.setId(id);
        model.addAttribute("newUser", new User()); 

        return "admin/user/delete";
    }


    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.POST)//POST
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User eric){
        this.userService.deleteUserById(eric.getId());
        return "redirect:/admin/user";
    }
    
}

