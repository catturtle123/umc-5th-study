package umc.spring.converter;

import umc.spring.domain.Market;
import umc.spring.web.dto.MarketRequestDto;
import umc.spring.web.dto.MarketResponseDto;

import java.time.LocalDateTime;

public class MarketConverter {

    public static MarketResponseDto.AddMarketResultDTO toAddMarketResultDto(Market market) {
        return MarketResponseDto.AddMarketResultDTO.builder()
                .marketId(market.getId()).createAt(LocalDateTime.now()).build();
    }

    public static Market toMarket(MarketRequestDto.addDto request) {
        return Market.builder()
                .name(request.getName())
                .build();
    }
}
