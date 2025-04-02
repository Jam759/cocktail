package com.example.cocktail.userFavorite.document.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Thumbnail{
    private Long cocktailId;
    private String cocktailName;
    private String cocktailImgPath;
}