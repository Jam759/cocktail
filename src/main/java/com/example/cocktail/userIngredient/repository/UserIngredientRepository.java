package com.example.cocktail.userIngredient.repository;

import com.example.cocktail.userIngredient.entity.UserIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIngredientRepository extends JpaRepository<UserIngredient, Long> {
}
