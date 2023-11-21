package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.Food_user;
import umc.spring.validator.ExistCategories;

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
        Gender gender;
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
}
