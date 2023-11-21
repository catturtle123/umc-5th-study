package umc.spring.converter;

import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.User_mission;
import umc.spring.web.dto.MarketRequestDto;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.dto.MissionResponseDto;

import java.time.LocalDateTime;

public class MissionConverter {
    public static Mission toMission(MissionRequestDto.addMissionDto request, Market market) {
        return Mission.builder()
                .name(request.getName())
                .point(request.getPoint())
                .content(request.getContent())
                .distinctNumber(request.getDistinctNumber())
                .isSuccess(false)
                .market(market)
                .build();
    }

    public static MissionResponseDto.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDto.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static User_mission toUserMission(Mission mission, User user) {
        return User_mission.builder()
                .mission(mission)
                .user(user)
                .build();
    }

    public static MissionResponseDto.AllocateResultDTO toAllocateDto(User_mission userMission) {
        return MissionResponseDto.AllocateResultDTO.builder()
                .missionId(userMission.getMission().getId())
                .userId(userMission.getUser().getId())
                .createAt(LocalDateTime.now())
                .build();
    }
}
