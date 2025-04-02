package com.example.cocktail.cocktailRecipe.service;

import com.example.cocktail.cocktailRecipe.dto.response.CocktailRecipeResponse;

public interface CocktailRecipeService {

    CocktailRecipeResponse findByCocktailName(String CocktailName);


}
