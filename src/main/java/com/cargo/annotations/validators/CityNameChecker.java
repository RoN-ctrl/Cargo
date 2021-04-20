package com.cargo.annotations.validators;

import com.cargo.annotations.CityNameCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CityNameChecker implements ConstraintValidator<CityNameCheck, String> {

    static final String CITY_REGEX = "^\\p{Lu}\\p{Ll}+( \\p{Lu}\\p{Ll}+)*$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(CITY_REGEX);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}
