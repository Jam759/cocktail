package com.example.cocktail.cocktailRecipe.document;

import com.example.cocktail.cocktailRecipe.document.classes.NeededIngredient;
import com.example.cocktail.cocktailRecipe.document.classes.Step;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cocktail_recipe")
public class CocktailRecipe {

    @Id
    private Long cocktailId; // RDB 칵테일 ID 참조

    private String cocktailName;

    private List<Step> step; // 제조 순서

    private List<NeededIngredient> ingredient; // RDB의 재료 ID 참조  LIST<MAP<재료이름, 재료필요량>>

}

