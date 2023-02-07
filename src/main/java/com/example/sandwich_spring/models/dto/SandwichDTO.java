package com.example.sandwich_spring.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SandwichDTO {


    private Long id;
    private String name;
    private String desc;
    private double price;
}
