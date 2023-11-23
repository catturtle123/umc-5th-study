package umc.spring.validation.annotation;

import umc.spring.validation.validator.CategoriesExistValidator;
import umc.spring.validation.validator.IsSuccessMissionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IsSuccessMissionValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsSuccessMission {

    String message() default "이미 완료된 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
