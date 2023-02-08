package com.example.sandwich_spring.models.form;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterForm {

    @NotBlank
    @Email
    private String username;

    @NotBlank
    @Min(4)
    private String password;

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotNull
    @Past
    private LocalDate birthdate;

}
