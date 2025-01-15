package com.example.demo.service.validator;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;  
import jakarta.validation.Payload;  
import com.example.demo.service.validator.StrongPasswordValidator;

@Constraint(validatedBy = StrongPasswordValidator.class)  
@Target({ ElementType.METHOD, ElementType.FIELD })  //METHOD FIELD pham vi la truong
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface StrongPassword {  
    String message() default "Must be 8 characters long and contain at least one special character."; 

    Class<?>[] groups() default {};  
    
    Class<? extends Payload>[] payload() default {};  
}