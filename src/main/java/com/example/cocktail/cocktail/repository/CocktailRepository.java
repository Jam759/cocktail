package com.example.cocktail.cocktail.repository;

import com.example.cocktail.cocktail.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRepository extends JpaRepository<Cocktail , Long> {
}
