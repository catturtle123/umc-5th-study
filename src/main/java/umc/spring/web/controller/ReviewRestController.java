package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.service.ReviewCommandService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMarket;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

import javax.validation.Valid;

import static umc.spring.converter.ReviewConverter.reviewPreViewListDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ResponseDto<ReviewResponseDto.JoinResultDTO> addReview(@RequestBody @Valid ReviewRequestDto.addReviewDto request) {
        Review review = reviewCommandService.addReview(request);
        return ResponseDto.onSuccess(ReviewConverter.toJoinResultDTO(review), Code.OK);
    }






}
