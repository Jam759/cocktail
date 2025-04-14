package com.example.cocktail.cocktail.controller;

import com.example.cocktail.cocktail.dto.response.GetCocktail;
import com.example.cocktail.cocktail.service.impl.CocktailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cocktail")
@RestController
@RequiredArgsConstructor
public class CocktailController {

    private final CocktailServiceImpl cocktailService;

    // 1. 특정 칵테일 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<GetCocktail> getCocktailById(@PathVariable Long id) {
        GetCocktail cocktail = cocktailService.getCocktailById(id);
        return ResponseEntity.ok(cocktail);
    }

    // 2. 평점 기준 상위/하위 10개 조회
    @GetMapping("/ranking")
    public ResponseEntity<List<GetCocktail>> getRatingCocktails(@RequestParam(defaultValue = "DESC") String order) {
        List<GetCocktail> cocktails = cocktailService.getRaringCocktails(order);
        return ResponseEntity.ok(cocktails);
    }

}
