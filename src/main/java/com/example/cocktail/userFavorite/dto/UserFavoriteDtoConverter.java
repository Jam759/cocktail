package com.example.cocktail.userFavorite.dto;


import com.example.cocktail.cocktail.entity.Cocktail;
import com.example.cocktail.userFavorite.document.UserFavorite;
import com.example.cocktail.userFavorite.document.classes.Thumbnail;
import com.example.cocktail.userFavorite.dto.response.FavoriteCocktailsResponse;

import java.util.List;
import java.util.stream.Collectors;

public class UserFavoriteDtoConverter {

    public static List<FavoriteCocktailsResponse> EntityToFavoriteCocktailsResponseList(List<Cocktail> cocktailList){
        return cocktailList.stream()
                .map(cocktail -> FavoriteCocktailsResponse.builder()
                        .cocktailThumbnail(List.of(Thumbnail.builder()
                                .cocktailId(cocktail.getId())
                                .cocktailName(cocktail.getName())
                                .cocktailImgPath(cocktail.getImgPath())
                                .build()))
                        .build())
                .collect(Collectors.toList());
    }

}
