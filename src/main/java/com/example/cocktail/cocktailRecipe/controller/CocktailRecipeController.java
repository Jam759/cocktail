package com.example.cocktail.cocktailRecipe.controller;

import com.example.cocktail.cocktailRecipe.dto.response.CocktailRecipeResponse;
import com.example.cocktail.cocktailRecipe.service.impl.CocktailRecipeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cocktail/recipe")
public class CocktailRecipeController {

    private final CocktailRecipeServiceImpl cocktailRecipeService;

    @GetMapping("/{cocktailName}")
    public ResponseEntity<CocktailRecipeResponse> findByCocktailName(@PathVariable String cocktailName) {
        return ResponseEntity.ok(cocktailRecipeService.findByCocktailName(cocktailName));
    }
}
