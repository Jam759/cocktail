package com.example.cocktail.userFavorite.service.impl;

import com.example.cocktail.cocktail.entity.Cocktail;
import com.example.cocktail.cocktail.repository.CocktailRepository;
import com.example.cocktail.common.exception.DuplicatedException;
import com.example.cocktail.common.exception.NotFoundException;
import com.example.cocktail.userFavorite.document.UserFavorite;
import com.example.cocktail.userFavorite.dto.UserFavoriteDtoConverter;
import com.example.cocktail.userFavorite.dto.request.CreateUserFavoriteRequest;
import com.example.cocktail.userFavorite.dto.response.FavoriteCocktailsResponse;
import com.example.cocktail.userFavorite.repository.UserFavoriteRepository;
import com.example.cocktail.userFavorite.service.UserFavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFavoriteServiceImpl implements UserFavoriteService {

    private final UserFavoriteRepository userFavoriteRepository;
    private final CocktailRepository cocktailRepository;


    public CreateUserFavoriteRequest CreateUserFavorite(CreateUserFavoriteRequest request) {
        Long userId = 0L; // 실제로는 토큰을 통해 사용자 ID를 가져와야 함

        // 기존 사용자 즐겨찾기 조회, 없으면 새로 생성
        UserFavorite userFavorite = userFavoriteRepository.findById(userId)
                .orElseGet(() -> new UserFavorite(userId, new ArrayList<>()));

        // 중복 검사
        boolean isDuplicate = userFavorite.getCocktailIdList().stream()
                .anyMatch(favorite -> favorite.equals(request.getCocktailId()));

        if (isDuplicate) {
            throw new DuplicatedException("해당 칵테일은 이미 즐겨찾기한 칵테일입니다.");
        }

        // 중복이 없으면 추가
        userFavorite.getCocktailIdList().add(request.getCocktailId());
        userFavoriteRepository.save(userFavorite);

        // 응답 DTO 생성 및 반환
        return request;
    }

    public List<FavoriteCocktailsResponse> GetUserFavoriteCocktailList(){

        Long userId = 0L; // 실제로는 토큰을 통해 사용자 ID를 가져와야 함

        UserFavorite userFavorite = userFavoriteRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("현재 유저 즐겨찾기를 한 칵테일이 없음"));


        List<Cocktail> cocktailList = cocktailRepository.findAllById(userFavorite.getCocktailIdList());
        return UserFavoriteDtoConverter.EntityToFavoriteCocktailsResponseList(cocktailList);

    }


}