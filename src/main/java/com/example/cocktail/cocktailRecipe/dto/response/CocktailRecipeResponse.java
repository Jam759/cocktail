package com.example.cocktail.cocktailRecipe.dto.response;

import com.example.cocktail.cocktailRecipe.document.classes.Step;
import com.example.cocktail.cocktailRecipe.document.classes.NeededIngredient;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CocktailRecipeResponse {

    private String cocktailName;

    private List<Step> step;

    private List<NeededIngredient> ingredient;


    @Builder
    public CocktailRecipeResponse(String cocktailName, List<Step> step , List<NeededIngredient> ingredient){

        this.cocktailName = cocktailName;
        this.step = step;
        this.ingredient = ingredient;

    }

}
