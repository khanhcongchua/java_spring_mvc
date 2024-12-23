package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Controller
public class UserController {
    // DI: Dependancy Injection
    private final UserService userService;

    public UserController(UserService userService
    ) {
        this.userService = userService;
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
        return "admin/user/table-user";
    }

    @RequestMapping("/admin/user/create")//GET
    public String getCreateUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }


    @RequestMapping("/admin/user/{id}")//GET
    public String getUserDetailPage(Model model, @PathVariable long id){
        model.addAttribute("id", id); 
        return "admin/user/show";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)//POST
    public String createUserPage(Model model, @ModelAttribute("newUser") User hoidanit){
        this.userService.handlSaveUser(hoidanit);
        return "redirect:/admin/user";
    }
    
}


// @RestController
// public class UserController {


//     // DI: Dependancy Injection
//     private UserService userService;

//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @GetMapping("/")
//     public String getHomePage(){
//         return this.userService.handleHello();
//     }
// }
