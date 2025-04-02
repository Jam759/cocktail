package com.example.cocktail.cocktailRecipe.repository;

import com.example.cocktail.cocktailRecipe.document.CocktailRecipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CocktailRecipeRepository extends MongoRepository<CocktailRecipe, Long> {
    Optional<CocktailRecipe> findByCocktailName(String CocktailName);
}
