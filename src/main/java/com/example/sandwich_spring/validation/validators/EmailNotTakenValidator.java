package com.example.sandwich_spring.validation.validators;

import com.example.sandwich_spring.service.UserService;
import com.example.sandwich_spring.validation.constraint.EmailNotTaken;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class EmailNotTakenValidator implements ConstraintValidator<EmailNotTaken, String> {
    private final UserService userService;
    public EmailNotTakenValidator(UserService userService){
        this.userService = userService;
    }
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context){
        return userService.checkEmailNotTaken(email);
    }
}
