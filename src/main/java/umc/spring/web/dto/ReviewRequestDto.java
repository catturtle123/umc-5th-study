package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistMarket;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.sql.Blob;


public class ReviewRequestDto {

    @Getter
    public static class addReviewDto {
        @NotNull
        private String name;
        @NotNull
        private String body;
        @NotNull
        private int reviewStar;

        private String picture;
        @NotNull
        private Long userId;
        @NotNull
        @ExistMarket
        private Long marketId;
    }

}
