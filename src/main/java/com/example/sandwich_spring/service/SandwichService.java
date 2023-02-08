package com.example.sandwich_spring.service;

import com.example.sandwich_spring.models.dto.SandwichDTO;
import com.example.sandwich_spring.models.form.SandwichInsertForm;
import com.example.sandwich_spring.models.form.SandwichUpdateForm;

import java.util.List;
public interface SandwichService {

    List<SandwichDTO> getAll();

    SandwichDTO getOne(Long id);


    void insert(SandwichInsertForm form);

    void update(Long id, SandwichUpdateForm form);


}
