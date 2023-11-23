package umc.spring.service;

import org.springframework.stereotype.Service;
import umc.spring.domain.User;
import umc.spring.web.dto.MemberRequestDto;


public interface MemberCommandService {

    public User joinMember(MemberRequestDto.JoinDto request);
}
