package com.example.sandwich_spring.service.mapper;

import com.example.sandwich_spring.models.dto.SandwichDTO;
import com.example.sandwich_spring.models.entity.Sandwich;
import com.example.sandwich_spring.models.form.SandwichInsertForm;
import org.springframework.stereotype.Service;

@Service
public class SandwichMapper {
    public SandwichDTO toDto(Sandwich entity){
        if(entity == null)
            return null;
        return SandwichDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();
    }

    public Sandwich toEntity(SandwichInsertForm form){

        if(form == null)
            return null;
        Sandwich sandwich = new Sandwich();

        sandwich.setName(form.getName());
        sandwich.setPrice(form.getPrice());
        sandwich.setDescription(form.getDesc());
        return sandwich;
    }
}
