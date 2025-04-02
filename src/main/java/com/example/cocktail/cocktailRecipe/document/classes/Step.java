package com.example.cocktail.cocktailRecipe.document.classes;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Step {
    private int order;
    private String description;

    @Builder
    public Step(int order, String description){
        this.order = order;
        this.description = description;
    }
}
