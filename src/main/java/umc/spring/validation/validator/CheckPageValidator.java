package umc.spring.validation.validator;

import org.springframework.stereotype.Component;
import umc.spring.base.Code;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.IsSuccessMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        System.out.println(value);

        if (value < 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(Code.PAGE_OVERFLOW.toString()).addConstraintViolation();
        }

        return true;
    }
}
