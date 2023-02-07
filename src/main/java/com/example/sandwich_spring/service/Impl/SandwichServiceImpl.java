package com.example.sandwich_spring.service.Impl;

import com.example.sandwich_spring.models.dto.SandwichDTO;
import com.example.sandwich_spring.models.entity.Sandwich;
import com.example.sandwich_spring.repository.SandwichRepository;
import com.example.sandwich_spring.service.SandwichService;
import com.example.sandwich_spring.service.mapper.SandwichMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichServiceImpl implements SandwichService {
    private final SandwichRepository sandwichRepository;
    private final SandwichMapper mapper;

    public SandwichServiceImpl(SandwichRepository sandwichRepository, SandwichMapper mapper) {
        this.sandwichRepository = sandwichRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SandwichDTO> getAll() {
        return sandwichRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public SandwichDTO getOne(Long id) {
        return sandwichRepository.findById(id)
                .map( mapper::toDto)
                .orElseThrow(() -> new RuntimeException("sandwich not found"));
    }
}
