package com.example.cocktail.userFavorite.dto.response;


import com.example.cocktail.userFavorite.document.classes.Thumbnail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class FavoriteCocktailsResponse {

    private List<Thumbnail> cocktailThumbnail;

}
