package com.example.demo.service.validator;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;  
import jakarta.validation.Payload;  
import com.example.demo.service.validator.StrongPasswordValidator;

@Constraint(validatedBy = RegisterValidator.class)  
@Target({ ElementType.TYPE })   //TYPE pham vi la class
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface RegisterChecked {  
    String message() default "User Register Invalidation Failed"; 

    Class<?>[] groups() default {};  
    
    Class<? extends Payload>[] payload() default {};  
}
