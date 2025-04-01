package com.example.cocktail.ingredient.entity;

import com.example.cocktail.ingredient.entity.enums.IngredientCategory;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    @Enumerated(EnumType.STRING)
    private IngredientCategory category;

}
