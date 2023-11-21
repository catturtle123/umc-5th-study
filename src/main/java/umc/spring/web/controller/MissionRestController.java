package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.User_mission;
import umc.spring.service.MissionCommandService;
import umc.spring.service.ReviewCommandService;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.dto.MissionResponseDto;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ResponseDto<MissionResponseDto.JoinResultDTO> addMission(@RequestBody @Valid MissionRequestDto.addMissionDto request) {
        Mission mission = missionCommandService.addMission(request);
        return ResponseDto.onSuccess(MissionConverter.toJoinResultDTO(mission), Code.OK);
    }

    @PostMapping("/allocates")
    public ResponseDto<MissionResponseDto.AllocateResultDTO> allocate(@RequestBody @Valid MissionRequestDto.allocateMissionDto request) {
        User_mission userMission = missionCommandService.allocateMission(request);
        return ResponseDto.onSuccess(MissionConverter.toAllocateResultDto(userMission), Code.OK);
    }

}
