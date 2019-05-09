package com.bridgelabz.cclibrary.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GreaterThanZeroValidator implements ConstraintValidator<GreaterThanZero, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value > 0 ) {
			return true;
		} else {
			return false;
		}
	}

}
