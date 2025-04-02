package com.example.cocktail.userFavorite.document;

import com.example.cocktail.userFavorite.document.classes.CocktailThumbnail;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document(collection = "user_favorites")
@AllArgsConstructor
public class UserFavorite {

    @Id
    private Long userId;

    private List<Long> cocktailIdList;

    public UserFavorite addFavoriteCocktail(Long cocktailId){
        cocktailIdList.add(cocktailId);
        return this;
    }

}
