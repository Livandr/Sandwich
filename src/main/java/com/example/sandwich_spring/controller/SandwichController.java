package com.example.sandwich_spring.controller;

import com.example.sandwich_spring.service.SandwichService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;

    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    //GET - http://localhost:8080/sandwich/all
    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("list", sandwichService.getAll());
        return "sandwich/display-all";
    }
}
