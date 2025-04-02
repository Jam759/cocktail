package com.example.cocktail.cocktailRecipe.service.impl;

import com.example.cocktail.cocktailRecipe.document.CocktailRecipe;
import com.example.cocktail.cocktailRecipe.dto.CocktailRecipeDtoConverter;
import com.example.cocktail.cocktailRecipe.dto.response.CocktailRecipeResponse;
import com.example.cocktail.cocktailRecipe.repository.CocktailRecipeRepository;
import com.example.cocktail.cocktailRecipe.service.CocktailRecipeService;
import com.example.cocktail.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CocktailRecipeServiceImpl implements CocktailRecipeService{

    private final CocktailRecipeRepository recipeRepository;


    @Override
    @Cacheable(value = "cocktailRecipe", key = "#cocktailName")
    public CocktailRecipeResponse findByCocktailName(String cocktailName) {

        CocktailRecipe recipe = recipeRepository.findByCocktailName(cocktailName)
                .orElseThrow(() -> new NotFoundException("해당 ID의 사용자를 찾을 수 없습니다: "));

        return CocktailRecipeDtoConverter.entityToCocktailRecipeResponse(recipe);

    }
}
