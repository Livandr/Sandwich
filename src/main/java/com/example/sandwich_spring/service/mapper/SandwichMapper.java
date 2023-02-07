package com.example.sandwich_spring.service.mapper;

import com.example.sandwich_spring.models.dto.SandwichDTO;
import com.example.sandwich_spring.models.entity.Sandwich;
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
}
