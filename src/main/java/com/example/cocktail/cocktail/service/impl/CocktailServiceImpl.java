package com.example.cocktail.cocktail.service.impl;

import com.example.cocktail.cocktail.dto.CocktailDtoConverter;
import com.example.cocktail.cocktail.dto.response.GetCocktail;
import com.example.cocktail.cocktail.entity.Cocktail;
import com.example.cocktail.cocktail.repository.CocktailRepository;
import com.example.cocktail.cocktail.service.CocktailService;
import com.example.cocktail.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CocktailServiceImpl implements CocktailService {

    private final CocktailRepository cocktailRepository;
    private final Map<String, Supplier<List<Cocktail>>> sortStrategy = Map.of(
            "ASC", cocktailRepository::findTop10ByOrderByRatingAsc,
            "DESC", cocktailRepository::findTop10ByOrderByRatingDesc
    );

    public GetCocktail getCocktailById(Long id){
        Cocktail cocktail = cocktailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 칵테일은 존재하지 않습니다. cocktailId : " + id));
        return CocktailDtoConverter.cocktailToEntity(cocktail);
    }

    public List<GetCocktail> getRaringCocktails(String order){
        Supplier<List<Cocktail>> supplier = sortStrategy.get(order.toUpperCase());

        if (supplier == null) {
            throw new IllegalArgumentException("정렬 기준은 'ASC' 또는 'DESC'만 허용됩니다.");
        }

        List<Cocktail> cocktailList = supplier.get();

        if (cocktailList.isEmpty()) {
            throw new NotFoundException("해당 정렬 기준에 맞는 칵테일이 존재하지 않습니다.");
        }

        return cocktailList.stream()
                .map(CocktailDtoConverter::cocktailToEntity)
                .toList();
    }







}
