package umc.spring.converter;

import umc.spring.domain.Market;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDto.addReviewDto request, Market market, User member) {
        return Review.builder()
                .name(request.getName())
                .picture(request.getPicture())
                .body(request.getBody())
                .reviewStar(request.getReviewStar())
                .market(market)
                .user(member)
                .build();
    }

    public static ReviewResponseDto.JoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDto.JoinResultDTO.builder()
                .reviewId(review.getId())
                .createAt(LocalDateTime.now())
                .build();
    }
}
