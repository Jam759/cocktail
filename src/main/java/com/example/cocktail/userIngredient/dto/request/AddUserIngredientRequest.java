package com.example.cocktail.userIngredient.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserIngredientRequest {
    private Long ingredientId;
    private String ingredientName;
    private String quantity; //나중에 VALID작업 할때 필터링 필요

}
