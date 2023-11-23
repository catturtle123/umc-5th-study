package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.User;
import umc.spring.service.MemberCommandService;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ResponseDto<MemberResponseDto.JoinResultDTO> join(@RequestBody @Valid MemberRequestDto.JoinDto request) {
        User user = memberCommandService.joinMember(request);
        return ResponseDto.onSuccess(MemberConverter.toJoinResultDTO(user), Code.OK);
    }
}
