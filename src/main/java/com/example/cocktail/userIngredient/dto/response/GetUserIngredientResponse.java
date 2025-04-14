package com.example.cocktail.userIngredient.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetUserIngredientResponse {

    private Long ingredientId;
    private String ingredientName;
    private String quantity;

    @Builder
    public GetUserIngredientResponse(Long ingredientId, String ingredientName, String quantity){
        this.ingredientName = ingredientName;
        this.ingredientId = ingredientId;
        this.quantity = quantity;
    }

}
