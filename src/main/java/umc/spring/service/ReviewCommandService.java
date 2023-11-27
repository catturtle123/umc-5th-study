package umc.spring.service;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDto;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDto.addReviewDto request);




}
