package com.example.cocktail.userIngredient.repository;

import com.example.cocktail.userIngredient.entity.UserIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserIngredientRepository extends JpaRepository<UserIngredient, Long> {
    // 특정 사용자(userId)의 재료 목록 조회
    List<UserIngredient> findByUserId(Long userId);

    Optional<UserIngredient> findByUserIdAndIngredientId(Long userId, Long ingredientId);

    boolean existsByUserIdAndIngredientId(Long userId, Long ingredientId);

    void deleteByUserIdAndIngredientId(Long userId, Long ingredientId);

}
