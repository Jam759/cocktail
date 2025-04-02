package com.example.cocktail.userFavorite.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateUserFavoriteRequest {

    @NotBlank(message = "cocktailId는 비어있을 수 없습니다.")
    private Long cocktailId;
    @NotBlank(message = "cocktailName는 비어있을 수 없습니다.")
    private String cocktailName;

    //    @NotBlank(message = "imagePath는 비어있을 수 없습니다.")
//    @Pattern(
//            regexp = "^https://my-bucket\\.s3\\.amazonaws\\.com/[a-zA-Z0-9-_/]+\\.(jpg|png|jpeg|gif)$",
//            message = "유효하지 않은 이미지 경로입니다. 예: https://my-bucket.s3.amazonaws.com/cocktail1.jpg"
//    )  나중에 추가
    private String imagePath;

}
