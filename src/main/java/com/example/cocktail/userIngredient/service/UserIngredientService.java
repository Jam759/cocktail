package com.example.cocktail.userIngredient.service;

import com.example.cocktail.userIngredient.dto.request.AddUserIngredientRequest;
import com.example.cocktail.userIngredient.dto.request.UpdateUserIngredientRequest;
import com.example.cocktail.userIngredient.dto.response.GetUserIngredientResponse;
import com.example.cocktail.userIngredient.entity.UserIngredient;

import java.util.List;

public interface UserIngredientService {

    List<GetUserIngredientResponse> getAllUserIngredients();

    void addUserIngredient(AddUserIngredientRequest request);

    GetUserIngredientResponse updateUserIngredient(UpdateUserIngredientRequest request);

    void deleteUserIngredient(Long ingredientId);

}
