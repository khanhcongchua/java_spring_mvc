

package com.example.demo.service.validator;



import com.example.demo.domain.dto.RegisterDTO;

import jakarta.validation.ConstraintValidator;  
import jakarta.validation.ConstraintValidatorContext;  

public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {  
    @Override  
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {  
        boolean valid =  true;

        //check if pass field is match
        if(!user.getPassword().equals(user.getConfirmPassword())){
            context.buildConstraintViolationWithTemplate("Password mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm") //bao loi gi
            .addPropertyNode("confirmPassword") //truong can bao loi
            .addConstraintViolation()
            .disableDefaultConstraintViolation();
            valid = false;

        }


        return valid;



    }  
}