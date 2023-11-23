package umc.spring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.User_mission;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MissionRequestDto;

public interface MissionCommandService{
    public Mission addMission(MissionRequestDto.addMissionDto request);

    public User_mission allocateMission(MissionRequestDto.allocateMissionDto request);
}
