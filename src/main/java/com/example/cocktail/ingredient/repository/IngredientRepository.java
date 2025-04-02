package com.example.cocktail.ingredient.repository;

import com.example.cocktail.ingredient.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
