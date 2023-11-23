package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MarketConverter;
import umc.spring.domain.Market;
import umc.spring.repository.MarketRepository;
import umc.spring.web.dto.MarketRequestDto;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MarketCommandServiceImpl implements MarketCommandService {

    private final MarketRepository marketRepository;

    @Transactional
    @Override
    public Market addMarket(MarketRequestDto.addDto request) {
        System.out.println(request.getName());
        Market market = MarketConverter.toMarket(request);
        return marketRepository.save(market);
    }

}
