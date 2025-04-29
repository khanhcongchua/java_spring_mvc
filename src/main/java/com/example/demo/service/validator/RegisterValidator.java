

package com.example.demo.service.validator;



import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.RegisterDTO;
import com.example.demo.service.UserService;

import jakarta.validation.ConstraintValidator;  
import jakarta.validation.ConstraintValidatorContext;  

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {  


    private final UserService userService;


    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }


    @Override  
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {  
        boolean valid =  true;

        //check if pass field is match
        if(!user.getPassword().equals(user.getConfirmPassword())){
            context.buildConstraintViolationWithTemplate("Password không khớp khà khà khà") //bao loi gi
            .addPropertyNode("confirmPassword") //truong can bao loi
            .addConstraintViolation()
            .disableDefaultConstraintViolation();
            valid = false;

        }


        // check if email does exist 
        if(this.userService.checkEmailExist(user.getEmail())){
            context.buildConstraintViolationWithTemplate("Email đã tồn tại rồi") //bao loi gi
            .addPropertyNode("email") //truong can bao loi
            .addConstraintViolation()
            .disableDefaultConstraintViolation();
            valid = false;

        }


        return valid;



    }  
}