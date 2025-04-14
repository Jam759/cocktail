package com.example.cocktail.cocktail.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
public class GetCocktail {

    private Long id;
    private String name;
    private String description;
    private String imgPath;

    @Builder
    public GetCocktail(Long id, String name, String description, String imgPath){
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
    }

}
