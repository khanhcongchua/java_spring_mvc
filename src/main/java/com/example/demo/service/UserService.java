package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;


    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }


    public List<User> getAllUsersByEmail(String email){
        return this.userRepository.findOneByEmail(email);
    }


    public User handlSaveUser(User user){
        User eric = this.userRepository.save(user);
        System.out.println(eric);
        return eric;

    }
}
