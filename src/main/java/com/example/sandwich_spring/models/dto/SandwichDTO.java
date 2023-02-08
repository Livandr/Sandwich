package com.example.sandwich_spring.models.dto;

import com.example.sandwich_spring.models.entity.Ingredient;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class SandwichDTO {
    private Long id;
    private String name;
    private String description;
    private double price;

    private Set<IngredientDTO> ingredients;

}
