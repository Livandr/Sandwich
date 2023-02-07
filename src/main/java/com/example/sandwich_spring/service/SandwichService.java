package com.example.sandwich_spring.service;

import com.example.sandwich_spring.models.dto.SandwichDTO;

import java.util.List;
public interface SandwichService {

    List<SandwichDTO> getAll();

    SandwichDTO getOne(Long id);
}
