package com.example.sandwich_spring.service.Impl;

import com.example.sandwich_spring.models.dto.IngredientDTO;
import com.example.sandwich_spring.models.entity.Ingredient;
import com.example.sandwich_spring.repository.IngredientRepository;
import com.example.sandwich_spring.service.IngredientService;
import com.example.sandwich_spring.service.mapper.IngredientMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper){
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream()
                .map(ingredientMapper::toDTO)
                .toList();
    }

    @Override
    public IngredientDTO getOne(long id) {
        return ingredientRepository.findById(id)
                .map( ingredientMapper::toDTO )
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }
    @Override
    public void insert(String name) {
        Ingredient entity = new Ingredient();
        entity.setName(name);
        ingredientRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        if( !ingredientRepository.existsById(id) )
            throw new RuntimeException("Ingredient not found");

        ingredientRepository.deleteById(id);
    }



}
