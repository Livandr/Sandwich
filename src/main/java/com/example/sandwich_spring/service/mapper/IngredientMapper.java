package com.example.sandwich_spring.service.mapper;

import com.example.sandwich_spring.models.dto.IngredientDTO;
import com.example.sandwich_spring.models.entity.Ingredient;
import com.example.sandwich_spring.models.entity.Sandwich;
import com.example.sandwich_spring.models.form.SandwichInsertForm;
import org.springframework.stereotype.Service;

@Service
public class IngredientMapper {

    public IngredientDTO toDTO(Ingredient entity){
        if(entity == null)
            return null;

        return IngredientDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}
