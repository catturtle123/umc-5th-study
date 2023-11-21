package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.base.Code;
import umc.spring.base.exception.handler.MarketCategoryHandler;
import umc.spring.base.exception.handler.MemberCategoryHandler;
import umc.spring.base.exception.handler.MissionCategoryHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.User_mission;
import umc.spring.repository.MarketRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.UserMissionRepository;
import umc.spring.web.dto.MissionRequestDto;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MarketRepository marketRepository;

    private final MissionRepository missionRepository;

    private final MemberRepository memberRepository;

    private final UserMissionRepository userMissionRepository;

    @Transactional
    @Override
    public Mission addMission(MissionRequestDto.addMissionDto request) {

        Market market = marketRepository.findById(request.getMarketId()).orElseThrow(()->{
            return new MarketCategoryHandler(Code.MARKET_NOT_FOUND);
        });
        Mission mission = MissionConverter.toMission(request, market);
        return missionRepository.save(mission);

    }

    @Transactional
    @Override
    public User_mission allocateMission(MissionRequestDto.allocateMissionDto request) {
        User user = memberRepository.findById(request.getUserId()).orElseThrow(()->{
            return new MemberCategoryHandler(Code.MEMBER_NOT_FOUND);
        });
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(()->{
            return new MissionCategoryHandler(Code.MISSION_NOT_FOUND);
        });

        User_mission userMission = MissionConverter.toUserMission(mission,user);

        userMissionRepository.save(userMission);

        return userMission;
    }
}
