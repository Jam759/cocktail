package com.example.cocktail.userIngredient.dto;

import com.example.cocktail.userIngredient.dto.request.AddUserIngredientRequest;
import com.example.cocktail.userIngredient.dto.response.GetUserIngredientResponse;
import com.example.cocktail.userIngredient.entity.UserIngredient;

public class UserIngredientDtoConverter {

    public static GetUserIngredientResponse UserIngredientToGetUserIngredientResponse(UserIngredient entity) {
        return GetUserIngredientResponse.builder()
                .ingredientId(entity.getIngredientId())
                .ingredientName(entity.getIngredientName())
                .quantity(entity.getQuantity())
                .build();
    }

    public static UserIngredient AddUserIngredientRequestToUserIngredient(AddUserIngredientRequest request){
        return UserIngredient.builder()
                .ingredientId(request.getIngredientId())
                .ingredientName(request.getIngredientName())
                .quantity(request.getQuantity())
                .build();
    }

}
