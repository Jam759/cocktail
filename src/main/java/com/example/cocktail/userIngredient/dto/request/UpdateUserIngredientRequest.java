package com.example.cocktail.userIngredient.dto.request;

import lombok.Getter;

@Getter
public class UpdateUserIngredientRequest {

    private Long ingredientId;
    private String quantity; //나중에 VALID작업 할때 필터링 필요
}
