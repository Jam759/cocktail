package com.example.cocktail.userFavorite.repository;


import com.example.cocktail.userFavorite.document.UserFavorite;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserFavoriteRepository extends MongoRepository<UserFavorite,Long> {
}
