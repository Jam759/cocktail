package com.example.cocktail.userIngredient.service.impl;

import com.example.cocktail.common.exception.NotFoundException;
import com.example.cocktail.userIngredient.dto.UserIngredientDtoConverter;
import com.example.cocktail.userIngredient.dto.request.AddUserIngredientRequest;
import com.example.cocktail.userIngredient.dto.request.UpdateUserIngredientRequest;
import com.example.cocktail.userIngredient.dto.response.GetUserIngredientResponse;
import com.example.cocktail.userIngredient.entity.UserIngredient;
import com.example.cocktail.userIngredient.repository.UserIngredientRepository;
import com.example.cocktail.userIngredient.service.UserIngredientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserIngredientServiceImpl implements UserIngredientService {

    private final UserIngredientRepository userIngredientRepository;

    @Override
    public List<GetUserIngredientResponse> getAllUserIngredients() {
        Long userId = null; //토큰에서 유저 아이디를 가져오는 로직 추가할거임

        List<UserIngredient> userIngredientList = userIngredientRepository.findByUserId(userId);

        return userIngredientList.stream()
                .map(UserIngredientDtoConverter::UserIngredientToGetUserIngredientResponse)
                .toList();
    }

    @Override
    public void addUserIngredient(AddUserIngredientRequest request) {
        UserIngredient userIngredient = UserIngredientDtoConverter.AddUserIngredientRequestToUserIngredient(request);
        userIngredientRepository.save(userIngredient);
    }

    @Override
    @Transactional
    public GetUserIngredientResponse updateUserIngredient(UpdateUserIngredientRequest request) {

        Long userId = null; //토큰에서 유저 아이디를 가져오는 로직 추가할거임

        UserIngredient userIngredient = userIngredientRepository.findByUserIdAndIngredientId(userId,request.getIngredientId())
                        .orElseThrow( () -> new NotFoundException("해당 유저혹은 재료를 소유하고 있지 않음 "+
                                "userId : "+userId+" ingredientId : "+request.getIngredientId()));

        userIngredient.update(request.getQuantity());
        userIngredientRepository.save(userIngredient);
        return UserIngredientDtoConverter.UserIngredientToGetUserIngredientResponse(userIngredient);
    }

    @Override
    public void deleteUserIngredient(Long ingredientId) {
        Long userId = null; //토큰에서 유저 아이디를 가져오는 로직 추가할거임

        if (!userIngredientRepository.existsByUserIdAndIngredientId(userId, ingredientId)) {
            throw new NotFoundException("재료를 찾을 수 없습니다. userId = " + userId+" ingredientId : "+ ingredientId);
        }
        userIngredientRepository.deleteByUserIdAndIngredientId(userId, ingredientId);
    }
}
