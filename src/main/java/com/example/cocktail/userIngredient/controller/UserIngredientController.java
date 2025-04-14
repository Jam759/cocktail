package com.example.cocktail.userIngredient.controller;

import com.example.cocktail.userIngredient.dto.request.AddUserIngredientRequest;
import com.example.cocktail.userIngredient.dto.request.UpdateUserIngredientRequest;
import com.example.cocktail.userIngredient.dto.response.GetUserIngredientResponse;
import com.example.cocktail.userIngredient.entity.UserIngredient;
import com.example.cocktail.userIngredient.service.impl.UserIngredientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/ingredients")
public class UserIngredientController {

    private final UserIngredientServiceImpl userIngredientService;

    @GetMapping
    public ResponseEntity<List<GetUserIngredientResponse>> getUserIngredients() {
        return ResponseEntity.ok(userIngredientService.getAllUserIngredients());
    }

    @PostMapping
    public ResponseEntity<Void> addUserIngredient(@RequestBody AddUserIngredientRequest request) {
        userIngredientService.addUserIngredient(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity<GetUserIngredientResponse> updateUserIngredient(@RequestBody UpdateUserIngredientRequest request) {
        return ResponseEntity.ok(userIngredientService.updateUserIngredient(request));
    }

    @DeleteMapping("/{ingredientId}")
    public ResponseEntity<Void> deleteUserIngredient(@PathVariable Long ingredientId) {
        userIngredientService.deleteUserIngredient(ingredientId);
        return ResponseEntity.noContent().build();
    }
}
