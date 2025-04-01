package com.example.cocktail.cocktailRecipe.document;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cocktail_recipe")
public class CocktailRecipe {

    @Id
    private Long cocktailId; // RDB 칵테일 ID 참조

    private List<Step> step; // 제조 순서

    private List<Long> ingredientId; // RDB의 재료 ID 참조
}

