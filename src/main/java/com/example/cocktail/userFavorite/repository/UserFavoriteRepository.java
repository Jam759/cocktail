package com.example.cocktail.userFavorite.repository;


import com.example.cocktail.userFavorite.document.UserFavorites;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserFavoriteRepository extends MongoRepository<UserFavorites,Long> {
}
