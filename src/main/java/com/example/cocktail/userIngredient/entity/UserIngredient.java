package com.example.cocktail.userIngredient.entity;


import com.example.cocktail.common.entity.BaseEntity;
import jakarta.persistence.*;

@Entity
public class UserIngredient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ingredientId;

    @Column(length = 20)
    private String name;

    @Column(length = 50)
    private String quantity;

}
