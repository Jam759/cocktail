package com.example.cocktail.userIngredient.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserIngredient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ingredientId;

    @Column(length = 20)
    private String ingredientName;

    @Column(length = 50)
    private String quantity;

    @Builder
    public UserIngredient( Long ingredientId, String ingredientName, String quantity){
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
    }

    public UserIngredient update(String quantity){
        this.quantity = quantity;
        return this;
    }

}
