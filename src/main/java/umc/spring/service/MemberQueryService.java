package umc.spring.service;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

public interface MemberQueryService {
    Page<Review> getReviewListByMember(Long memberId, Integer page);

    Page<Mission> getMissionList(Long memberId, Integer page);

    Page<Mission> getCompleteMissionList(Long memberId, Integer page);
}
