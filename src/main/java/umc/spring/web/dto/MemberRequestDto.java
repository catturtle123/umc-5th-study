package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.enums.Gender;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberRequestDto {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String email;
        @ExistCategories
        List<Long> foodUserList;
    }

    @Getter
    public static class SearchMyReviewDto{
        @NotNull
        @CheckPage
        Integer memberId;
        @NotNull
        Integer pageId;
    }
}
