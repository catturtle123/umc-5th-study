package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.repository.MarketRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class MarketQueryServiceImpl implements MarketQueryService{

    private final ReviewRepository reviewRepository;
    private final MarketRepository marketRepository;
    private final MissionRepository missionRepository;
    @Override
    public Page<Review> getReviewListByMarket(Long marketId, Integer page) {
        Market store = marketRepository.findById(marketId).get();

        Page<Review> storePage = reviewRepository.findAllByMarket(store, PageRequest.of(page, 10));
        return storePage;
    }

    @Override
    public Page<Mission> getMissionList(Long marketId, Integer page) {
        Market market = marketRepository.findById(marketId).get();

        Page<Mission> missionListByMarket = missionRepository.findAllByMarket(market, PageRequest.of(page, 10));
        return missionListByMarket;
    }
}
