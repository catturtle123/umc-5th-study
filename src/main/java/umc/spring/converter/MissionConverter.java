package umc.spring.converter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.mapping.User_mission;
import umc.spring.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDto.AllocateResultDTO toAllocateResultDto(User_mission userMission) {
        return MissionResponseDto.AllocateResultDTO.builder()
                .missionId(userMission.getMission().getId())
                .userId(userMission.getUser().getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static MissionResponseDto.MissionPreview missionPreview(Mission mission){
        return MissionResponseDto.MissionPreview.builder()
                .name(mission.getName())
                .point(mission.getPoint())
                .isSuccess(mission.isSuccess())
                .content(mission.getContent())
                .distinctNumber(mission.getDistinctNumber())
                .build();
    }

    public static MissionResponseDto.MissionPreviewList missionPreViewListDTO(Page<Mission> missionList){
        List<MissionResponseDto.MissionPreview> missionPreviewList = missionList.stream()
                .map(MissionConverter::missionPreview).collect(Collectors.toList());

        return MissionResponseDto.MissionPreviewList.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewList.size())
                .missionPreviewList(missionPreviewList)
                .build();
    }

    public static Page<Mission> toPage(List<Mission> missionList, PageRequest pageRequest) {

        int total = missionList.size();


        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), total);
        List<Mission> sublist = missionList.subList(start, end);


        Page<Mission> page = new PageImpl<>(sublist, pageRequest, total);

        return page;
    }

}
