package umc.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MarketRequestDto;


public interface MarketCommandService {
    Market addMarket(MarketRequestDto.addDto request);

}
