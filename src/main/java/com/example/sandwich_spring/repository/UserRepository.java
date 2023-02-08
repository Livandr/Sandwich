package com.example.sandwich_spring.repository;

import com.example.sandwich_spring.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{

    boolean existsByEmail(String email);
}
