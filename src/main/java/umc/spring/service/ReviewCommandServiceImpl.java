package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.base.Code;
import umc.spring.base.exception.handler.MarketCategoryHandler;
import umc.spring.base.exception.handler.MemberCategoryHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Market;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.repository.MarketRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDto;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;

    private final MarketRepository marketRepository;

    private final ReviewRepository reviewRepository;

    @Transactional
    @Override
    public Review addReview(ReviewRequestDto.addReviewDto request) {
        User user = memberRepository.findById(request.getUserId()).orElseThrow(()->{
            return new MemberCategoryHandler(Code.MEMBER_NOT_FOUND);
        });
        Market market = marketRepository.findById(request.getMarketId()).orElseThrow(()->{
            return new MarketCategoryHandler(Code.MARKET_NOT_FOUND);
        });
        Review review = ReviewConverter.toReview(request, market, user);

        return reviewRepository.save(review);
    }
}
