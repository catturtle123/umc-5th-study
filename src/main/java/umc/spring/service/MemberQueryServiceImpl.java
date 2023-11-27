package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.mapping.User_mission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Review> getReviewListByMember(Long memberId, Integer page) {
        User member = memberRepository.findById(memberId).get();

        Page<Review> ReviewPageByMember = reviewRepository.findAllByUser(member, PageRequest.of(page,10));

        return ReviewPageByMember;
    }

    @Override
    public Page<Mission> getMissionList(Long memberId, Integer page) {
        User member = memberRepository.findById(memberId).get();
        List<User_mission> userMissionList = member.getUserMissionList();
        List<Mission> missions = userMissionList.stream()
                .filter(u -> !u.getMission().isSuccess())
                .map(User_mission::getMission)
                .collect(Collectors.toList());
        Page<Mission> missions1 = MissionConverter.toPage(missions, PageRequest.of(page, 10));

        return missions1;
    }

    @Override
    public Page<Mission> getCompleteMissionList(Long memberId, Integer page) {
        User member = memberRepository.findById(memberId).get();
        List<User_mission> userMissionList = member.getUserMissionList();

        List<Mission> missions = userMissionList.stream()
                .filter(u -> u.getMission().isSuccess())
                .map(User_mission::getMission)
                .collect(Collectors.toList());


        Page<Mission> missions1 = MissionConverter.toPage(missions, PageRequest.of(page, 10));
        return missions1;
    }


}
