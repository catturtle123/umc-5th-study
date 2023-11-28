package umc.spring.converter;

import umc.spring.domain.User;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDto.JoinResultDTO toJoinResultDTO(User user) {
        return MemberResponseDto.JoinResultDTO.builder()
                .memberId(user.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(MemberRequestDto.JoinDto request){
        Integer genderInt = request.getGender();
        Gender gender = null;
        switch (genderInt) {
            case 0:
                gender = Gender.MALE;
                break;
            case 1:
                gender = Gender.FEMALE;
                break;
        }

        LocalDate localDate = LocalDate.of(request.getBirthYear(), request.getBirthMonth(), request.getBirthDay());

        return User.builder()
                .name(request.getName())
                .gender(gender)
                .address(request.getAddress())
                .birth(localDate)
                .foodUserList(new ArrayList<>())
                .email(request.getEmail())
                .build();
    }
}
