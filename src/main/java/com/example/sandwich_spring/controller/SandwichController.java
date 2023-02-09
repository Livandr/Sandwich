package com.example.sandwich_spring.controller;

import com.example.sandwich_spring.models.dto.IngredientDTO;
import com.example.sandwich_spring.models.dto.SandwichDTO;
import com.example.sandwich_spring.models.form.SandwichInsertForm;
import com.example.sandwich_spring.models.form.SandwichUpdateForm;
import com.example.sandwich_spring.service.IngredientService;
import com.example.sandwich_spring.service.SandwichService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;
    private final IngredientService ingredientService;

    public SandwichController(SandwichService sandwichService, IngredientService ingredientService) {
        this.sandwichService = sandwichService;
        this.ingredientService = ingredientService;
    }

    //GET - http://localhost:8080/sandwich/all
    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("list", sandwichService.getAll());
        return "sandwich/display-all";
    }

    //GET - http://localhost:8080/sandwich/one
    @GetMapping("/{id:[0-9]+}")
    public String getOne(Model model,@PathVariable long id){

        model.addAttribute("sandwich", sandwichService.getOne(id));
        return "sandwich/display-one";
    }
    @GetMapping("/add")
    public String insertForm(Model model){
        model.addAttribute("form",new SandwichInsertForm());
        model.addAttribute("ingredients", ingredientService.getAll());
        return "sandwich/insert-form";
    }

    @PostMapping("/add")
    public String processInsertForm(@ModelAttribute("form") @Valid SandwichInsertForm form, BindingResult bindingResult){
            if(bindingResult.hasErrors()){
                return "sandwich/insert-form";
            }
            sandwichService.insert(form);
            return "redirect:/sandwich/all";
        }

    @GetMapping("/{id:[0-9]+}/update")
    public String updateForm(Model model, @PathVariable long id) {
        SandwichUpdateForm form = new SandwichUpdateForm();
        SandwichDTO sandwich = sandwichService.getOne(id);
        form.setName(sandwich.getName());
        form.setPrice(sandwich.getPrice());
        form.setDesc(sandwich.getDescription());
        form.setIngredientsId(
                sandwich.getIngredients().stream()
                        .map(IngredientDTO::getId)
                        .toList()
        );

        model.addAttribute("form", form);
        model.addAttribute("id", id);
        model.addAttribute("ingredients", ingredientService.getAll());

        return "sandwich/update-form";
    }

    @PostMapping("/{id:[0-9]+}/update")
    public String processUpdateForm(
            @PathVariable Long id,
            @ModelAttribute("form") @Valid SandwichUpdateForm form,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            return "sandwich/update-form";
        }
        sandwichService.update(id, form);
        return "redirect:/sandwich/" + id;
    }



}
