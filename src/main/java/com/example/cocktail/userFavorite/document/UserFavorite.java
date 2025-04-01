package com.example.cocktail.userFavorite.document;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user_favorites")
public class UserFavorite {

    @Id
    private String id; // 또는 userId를 @Id로 사용할 수도 있음

    private Long userId;

    private List<Long> cocktailIdList;

}
