package com.example.cocktail.cocktailRecipe.dto;


import com.example.cocktail.cocktailRecipe.document.CocktailRecipe;
import com.example.cocktail.cocktailRecipe.dto.response.CocktailRecipeResponse;


public class CocktailRecipeDtoConverter {

    public static CocktailRecipeResponse entityToCocktailRecipeResponse(CocktailRecipe recipe){
        return CocktailRecipeResponse.builder()
                .cocktailName(recipe.getCocktailName())
                .step(recipe.getStep())
                .ingredient(recipe.getIngredient())
                .build();
    }


}
