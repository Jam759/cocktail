package com.example.cocktail.userFavorite.service.impl;

import com.example.cocktail.cocktail.entity.Cocktail;
import com.example.cocktail.cocktail.repository.CocktailRepository;
import com.example.cocktail.common.exception.DuplicatedException;
import com.example.cocktail.common.exception.NotFoundException;
import com.example.cocktail.userFavorite.document.UserFavorites;
import com.example.cocktail.userFavorite.dto.UserFavoriteDtoConverter;
import com.example.cocktail.userFavorite.dto.request.AddUserFavoriteRequest;
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


    public AddUserFavoriteRequest AddUserFavorite(AddUserFavoriteRequest request) {
        Long userId = null; // 실제로는 토큰을 통해 사용자 ID를 가져와야 함

        // 기존 사용자 즐겨찾기 조회, 없으면 새로 생성
        UserFavorites userFavorite = userFavoriteRepository.findById(userId)
                .orElseGet(() -> new UserFavorites(userId, new ArrayList<>()));

        // 중복 검사
        boolean isDuplicate = userFavorite.getCocktailIdList().stream()
                .anyMatch(favorite -> favorite.equals(request.getCocktailId()));

        if (isDuplicate) {
            throw new DuplicatedException("해당 칵테일은 이미 즐겨찾기한 칵테일입니다.");
        }

        // 중복이 없으면 추가
        userFavorite.addFavoriteCocktail(request.getCocktailId());
        userFavoriteRepository.save(userFavorite);

        // 응답 DTO 생성 및 반환
        return request;
    }

    public List<FavoriteCocktailsResponse> GetUserFavoriteCocktailList(){

        Long userId = null; // 실제로는 토큰을 통해 사용자 ID를 가져와야 함

        UserFavorites userFavorite = userFavoriteRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("현재 유저 즐겨찾기를 한 칵테일이 없음"));

        List<Cocktail> cocktailList = cocktailRepository.findAllById(userFavorite.getCocktailIdList());
        return UserFavoriteDtoConverter.EntityToFavoriteCocktailsResponseList(cocktailList);

    }

    public void deletedUserFavoriteCocktail(Long cocktailId){

        Long userId = null; // 실제로는 토큰을 통해 사용자 ID를 가져와야 함

        UserFavorites userFavorite = userFavoriteRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("유저를 찾을 수 없음 userId : "+ userId));

        userFavorite.deletedFavoriteCocktail(cocktailId);

    }


}