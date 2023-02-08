package com.example.sandwich_spring.service;

import com.example.sandwich_spring.models.dto.IngredientDTO;


import java.util.List;

public interface IngredientService {

    List<IngredientDTO> getAll();
    IngredientDTO getOne(long id);

    void insert(String name);

    void delete(long id);

}
