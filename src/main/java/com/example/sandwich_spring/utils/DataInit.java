package com.example.sandwich_spring.utils;

import com.example.sandwich_spring.models.entity.Ingredient;
import com.example.sandwich_spring.models.entity.Sandwich;
import com.example.sandwich_spring.models.entity.User;
import com.example.sandwich_spring.repository.IngredientRepository;
import com.example.sandwich_spring.repository.SandwichRepository;
import com.example.sandwich_spring.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
@Log4j2
public class DataInit implements InitializingBean {
    private final IngredientRepository ingredientRepository;
    private final SandwichRepository sandwichRepository;
    private final UserRepository userRepository;

    public DataInit(SandwichRepository sandwichRepository, UserRepository userRepository,
                    IngredientRepository ingredientRepository){
        this.sandwichRepository = sandwichRepository;
        this.userRepository = userRepository;


        this.ingredientRepository = ingredientRepository;
    }
    @Override
    public void afterPropertiesSet() throws Exception{
        log.info("-- INITIALIZING DB DATA --");

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("tomate");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("pesto");
        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("houmous");
        Ingredient ingredient4 = new Ingredient();
        ingredient4.setName("huile d'olive");

        ingredient1 = ingredientRepository.save(ingredient1);
        ingredient2 = ingredientRepository.save(ingredient2);
        ingredient3 = ingredientRepository.save(ingredient3);
        ingredient4 = ingredientRepository.save(ingredient4);


        Sandwich s1 = new Sandwich();
        s1.setName("Italien");
        s1.setPrice(4.5);
        s1.setDescription("Les bons gouts de l'Italie");
        s1.setIngredients(
                Set.of(
                        ingredient1,
                        ingredient2
                )
        );

        Sandwich s2 = new Sandwich();
        s2.setName("Houmous");
        s2.setPrice(4.5);
        s2.setDescription("Houmous/sésame");
        s2.setIngredients(
                Set.of(
                        ingredient3,
                        ingredient4
                )
        );

        s1 = sandwichRepository.save(s1);
        s2 = sandwichRepository.save(s2);

        User user = new User();

        user.setEmail("user@customer.be");
        user.setPassword("pass");
        user.setRole("CUSTOMER");
        user.setFirstname("user");
        user.setLastname("customer");
        user.setBirthdate(LocalDate.EPOCH);

        user = userRepository.save(user);

        log.info("-- DATA INIT FINISHED --");
    }

}
