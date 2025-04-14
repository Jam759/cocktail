package com.example.cocktail.cocktail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Cocktail {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imgPath;

    private Integer rating; // min : 0  max : 5

}
