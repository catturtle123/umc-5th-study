package umc.spring.service;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

public interface MarketQueryService {
    Page<Review> getReviewListByMarket(Long StoreId, Integer page);
    Page<Mission> getMissionList(Long marketId, Integer page);
}
