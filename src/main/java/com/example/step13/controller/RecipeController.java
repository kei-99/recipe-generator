package com.example.step13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.step13.service.RecipeService;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public String generateRecipe(@RequestBody String ingredients) {
        return recipeService.generateRecipe(ingredients);
    }
}
