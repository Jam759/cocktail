package com.example.cocktail.cocktail.dto;

import com.example.cocktail.cocktail.dto.response.GetCocktail;
import com.example.cocktail.cocktail.entity.Cocktail;

public class CocktailDtoConverter {

    public static GetCocktail cocktailToEntity(Cocktail entity){
        return GetCocktail.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .imgPath(entity.getImgPath())
                .build();
    }

}
