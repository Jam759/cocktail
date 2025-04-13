package com.example.cocktail.userFavorite.document;

import com.example.cocktail.common.exception.NotFoundException;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Optional;

@Getter
@Document(collection = "user_favorites")
@AllArgsConstructor
public class UserFavorites {

    @Id
    private Long userId;

    private List<Long> cocktailIdList;

    public void addFavoriteCocktail(Long cocktailId){
        cocktailIdList.add(cocktailId);
    }

    public void deletedFavoriteCocktail(Long cocktailId) {
        boolean removed = cocktailIdList.remove(cocktailId);
        if (!removed) {
            throw new NotFoundException("즐겨찾기에 해당 칵테일이 존재하지 않습니다.");
        }
    }



}
