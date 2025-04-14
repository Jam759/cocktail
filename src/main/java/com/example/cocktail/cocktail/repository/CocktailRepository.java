package com.example.cocktail.cocktail.repository;

import com.example.cocktail.cocktail.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CocktailRepository extends JpaRepository<Cocktail , Long> {

    List<Cocktail> findTop10ByOrderByRatingAsc();
    List<Cocktail> findTop10ByOrderByRatingDesc();

}
