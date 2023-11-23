package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.base.Code;
import umc.spring.base.exception.handler.MissionCategoryHandler;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository;
import umc.spring.validation.annotation.IsSuccessMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class IsSuccessMissionValidator implements ConstraintValidator<IsSuccessMission, Long> {

    private final MissionRepository missionRepository;

    @Override
    public void initialize(IsSuccessMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Mission mission = missionRepository.findById(value).orElseThrow(() -> {
            return new MissionCategoryHandler(Code.MISSION_NOT_FOUND);
        });
        boolean isValid = mission.isSuccess();

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(Code.MISSION_ALREADY_COMPLETE.toString()).addConstraintViolation();
        }

        return !isValid;
    }
}
