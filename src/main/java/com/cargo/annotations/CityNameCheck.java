package com.cargo.annotations;

import com.cargo.annotations.validators.CityNameChecker;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CityNameChecker.class)
@Documented
public @interface CityNameCheck {

    String message() default "Incorrect city name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
