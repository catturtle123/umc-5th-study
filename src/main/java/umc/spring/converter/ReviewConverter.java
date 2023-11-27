package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Market;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDto.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDto.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getReviewStar())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDto.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewResponseDto.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDto.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }


}
