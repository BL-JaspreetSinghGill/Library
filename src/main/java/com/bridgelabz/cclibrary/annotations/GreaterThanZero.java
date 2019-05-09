package com.bridgelabz.cclibrary.annotations;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER; 
import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {GreaterThanZeroValidator.class})
public @interface GreaterThanZero {

	String message() default "Value should be greater than zero";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
		GreaterThanZero[] value();
    }
}
