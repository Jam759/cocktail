package com.example.cocktail.cocktailReview.repository;

import com.example.cocktail.cocktailReview.entity.CocktailReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailReviewRepository extends JpaRepository<CocktailReview, Long> {
}
