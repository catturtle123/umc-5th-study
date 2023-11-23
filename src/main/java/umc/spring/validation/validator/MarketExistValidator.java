package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.base.Code;
import umc.spring.base.exception.handler.MissionCategoryHandler;
import umc.spring.domain.Mission;
import umc.spring.repository.MarketRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.validation.annotation.ExistMarket;
import umc.spring.validation.annotation.IsSuccessMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MarketExistValidator implements ConstraintValidator<ExistMarket, Long> {

    private final MarketRepository marketRepository;

    @Override
    public void initialize(ExistMarket constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = marketRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(Code.MARKET_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
