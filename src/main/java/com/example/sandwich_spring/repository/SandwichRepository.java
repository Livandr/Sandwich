package com.example.sandwich_spring.repository;

import com.example.sandwich_spring.models.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich, Long> {

}
