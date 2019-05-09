package com.bridgelabz.cclibrary.utility;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@PropertySource("classpath:message.properties")
public class ValidationHelper {
	
	@Autowired
	private Validator validator;
	
	private String exceptionMessage="";

	public String validate(Object object) {
		 exceptionMessage="";
		 Set<ConstraintViolation<Object>> setConstraint =  validator.validate(object);
		 log.info("" +setConstraint);
		
		 if(setConstraint.size()>0) {
			 exceptionMessage = setConstraint.parallelStream().findFirst().get().getMessage();
		 }
		 
		 return exceptionMessage;
	}
}