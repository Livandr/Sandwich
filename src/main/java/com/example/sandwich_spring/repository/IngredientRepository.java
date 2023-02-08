package com.example.sandwich_spring.repository;

import com.example.sandwich_spring.models.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
