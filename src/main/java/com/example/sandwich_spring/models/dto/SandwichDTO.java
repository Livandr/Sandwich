package com.example.sandwich_spring.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SandwichDTO {
    private Long id;
    private String name;
    private String description;
    private double price;

}
