package com.example.cocktail.cocktailReview.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CocktailReview {

    private Long userId;

    private Long cocktailId;

    private int rating;

    @Column(columnDefinition = "TEXT")
    private String comment;


}
