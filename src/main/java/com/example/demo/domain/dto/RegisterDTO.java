package com.example.demo.domain.dto;

import com.example.demo.service.validator.RegisterChecked;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@RegisterChecked
public class RegisterDTO {

    @NotNull
    @Size(min = 2, message = "Your firstName have must than 2 char:>>>")
    private String firstName;

    @NotNull
    @Size(min = 2, message = "Your lastName have must than 2 char:>>>")
    private String lastName;

    @NotNull
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    
    @NotNull
    @Size(min = 6, message = "Password have must than 6 char:>>>")
    private String password;
    private String ConfirmPassword;

    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return ConfirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    
}
