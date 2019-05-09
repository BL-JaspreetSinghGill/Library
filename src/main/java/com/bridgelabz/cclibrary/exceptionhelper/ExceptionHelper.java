package com.bridgelabz.cclibrary.exceptionhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.cclibrary.models.Response;
import com.bridgelabz.cclibrary.utility.ResponseHelper;

import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
@PropertySource("classpath:message.properties")
public class ExceptionHelper {
	
	@Autowired
	private Environment environment;
		
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Response> handleException(Exception exception) {
		Response response = ResponseHelper.responseStatus(Integer.parseInt(environment.getProperty("error.exception.code")), environment.getProperty("error.exception.message"));
		displayExceptionMessage(exception);
		
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
	@ExceptionHandler(value = JwtException.class)
	public ResponseEntity<Response> handleJwtException(JwtException exception) {
		Response response = ResponseHelper.responseStatus(Integer.parseInt(environment.getProperty("error.jwtexception.code")), exception.getMessage());
		displayExceptionMessage(exception);
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	private void displayExceptionMessage(Exception exception) {
		log.error("Error : " +exception.getMessage(), exception);
	}
}