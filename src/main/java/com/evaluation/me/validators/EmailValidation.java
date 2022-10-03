package com.evaluation.me.validators;

import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation implements ConstraintValidator<ValidEmail, String> {

    @Override
    public void initialize(ValidEmail arg0) {
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }
}
