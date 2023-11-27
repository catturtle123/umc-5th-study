package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MarketConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.service.MarketCommandService;
import umc.spring.service.MarketQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMarket;
import umc.spring.web.dto.MarketRequestDto;
import umc.spring.web.dto.MarketResponseDto;
import umc.spring.web.dto.MissionResponseDto;
import umc.spring.web.dto.ReviewResponseDto;

@RestController
@RequestMapping("/markets")
@RequiredArgsConstructor
public class MarketRestController {

    private final MarketCommandService marketCommandService;
    private final MarketQueryService marketQueryService;

    @PostMapping("/")
    public ResponseDto<MarketResponseDto.AddMarketResultDTO> addMarket(@RequestBody MarketRequestDto.addDto request) {
        Market market = marketCommandService.addMarket(request);
        return ResponseDto.onSuccess(MarketConverter.toAddMarketResultDto(market), Code.OK);
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ResponseDto.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ResponseDto<ReviewResponseDto.ReviewPreViewListDTO> getReviewListByMarket(@ExistMarket @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page){
        Page page1 = marketQueryService.getReviewListByMarket(storeId, page);
        ReviewResponseDto.ReviewPreViewListDTO reviewPreViewListDTO = ReviewConverter.reviewPreViewListDTO(page1);
        return ResponseDto.onSuccess(reviewPreViewListDTO,Code.OK);
    }

    @GetMapping("/{marketId}/missions")
    public ResponseDto<MissionResponseDto.MissionPreviewList> getMissionList(@ExistMarket @PathVariable(name = "marketId") Long marketId, @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Mission> page1 = marketQueryService.getMissionList(marketId, page);
        MissionResponseDto.MissionPreviewList missionPreviewList = MissionConverter.missionPreViewListDTO(page1);
        return ResponseDto.onSuccess(missionPreviewList, Code.OK);
    }
}
