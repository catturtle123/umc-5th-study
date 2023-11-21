package umc.spring.converter;

import umc.spring.domain.User;
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
        return User.builder()
                .name(request.getName())
                .gender(request.getGender())
                .address(request.getAddress())
                .birth(LocalDate.parse(""+request.getBirthYear()+"-"+request.getBirthMonth()+"-"+request.getBirthDay()))
                .foodUserList(new ArrayList<>())
                .email(request.getEmail())
                .build();
    }
}
