package com.example.cocktail.userFavorite.controller;


import com.example.cocktail.userFavorite.dto.request.AddUserFavoriteRequest;
import com.example.cocktail.userFavorite.dto.response.FavoriteCocktailsResponse;
import com.example.cocktail.userFavorite.service.impl.UserFavoriteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorite")
@RequiredArgsConstructor
public class UserfavoriteController {

    private final UserFavoriteServiceImpl userFavoriteService;

    @GetMapping()
    public ResponseEntity<List<FavoriteCocktailsResponse>> userFavorites() {
        List<FavoriteCocktailsResponse> request = userFavoriteService.GetUserFavoriteCocktailList();
        return ResponseEntity.ok(request);
    }

    @PostMapping()
    public ResponseEntity<AddUserFavoriteRequest> addUserFavorite(AddUserFavoriteRequest request) {
        AddUserFavoriteRequest response =userFavoriteService.AddUserFavorite(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/{cocktailId}")
    public ResponseEntity<Void> deletedUserFavorite(@PathVariable Long cocktailId){
        userFavoriteService.deletedUserFavoriteCocktail(cocktailId);
        return ResponseEntity.ok().build();
    }

}
