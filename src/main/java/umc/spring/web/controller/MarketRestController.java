package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MarketConverter;
import umc.spring.domain.Market;
import umc.spring.service.MarketCommandService;
import umc.spring.web.dto.MarketRequestDto;
import umc.spring.web.dto.MarketResponseDto;

@RestController
@RequestMapping("/markets")
@RequiredArgsConstructor
public class MarketRestController {

    private final MarketCommandService marketCommandService;

    @PostMapping("/")
    public ResponseDto<MarketResponseDto.AddMarketResultDTO> addMarket(@RequestBody MarketRequestDto.addDto request) {
        Market market = marketCommandService.addMarket(request);
        return ResponseDto.onSuccess(MarketConverter.toAddMarketResultDto(market), Code.OK);
    }
}
