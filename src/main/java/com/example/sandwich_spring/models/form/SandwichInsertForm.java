package com.example.sandwich_spring.models.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class SandwichInsertForm {

    @Size(min = 4, max = 20)
    private String name;
    private String desc;
    private double price;

}
