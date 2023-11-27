package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.User;
import umc.spring.service.MemberCommandService;
import umc.spring.service.MemberQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.MissionResponseDto;
import umc.spring.web.dto.ReviewResponseDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ResponseDto<MemberResponseDto.JoinResultDTO> join(@RequestBody @Valid MemberRequestDto.JoinDto request) {
        User user = memberCommandService.joinMember(request);
        return ResponseDto.onSuccess(MemberConverter.toJoinResultDTO(user), Code.OK);
    }

    @GetMapping("/{memberId}/reviews")
    public ResponseDto<ReviewResponseDto.ReviewPreViewListDTO> getReviewListByMember(@PathVariable(name="memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page) {
        Page page1 = memberQueryService.getReviewListByMember(memberId, page);
        ReviewResponseDto.ReviewPreViewListDTO reviewPreViewListDTO = ReviewConverter.reviewPreViewListDTO(page1);
        return ResponseDto.onSuccess(reviewPreViewListDTO,Code.OK);
    }

    @GetMapping("/{memberId}/allocateMissions")
    public ResponseDto<MissionResponseDto.MissionPreviewList> getAllocateMission(@PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page) {
        Page page1 = memberQueryService.getMissionList(memberId, page);
        return ResponseDto.onSuccess(MissionConverter.missionPreViewListDTO(page1),Code.OK);
    }

    @GetMapping("/{memberId}/allocateCompleteMissions")
    public ResponseDto<MissionResponseDto.MissionPreviewList> getAllocateCompleteMission(@PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page) {
        Page page1 = memberQueryService.getCompleteMissionList(memberId, page);
        return ResponseDto.onSuccess(MissionConverter.missionPreViewListDTO(page1),Code.OK);
    }
}
