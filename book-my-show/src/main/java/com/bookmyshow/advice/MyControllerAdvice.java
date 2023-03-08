package com.bookmyshow.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookmyshow.exception.ExceptionHandling;

@ControllerAdvice
public class MyControllerAdvice {
	
	
	@ExceptionHandler(ExceptionHandling.class)
	public ResponseEntity<String> handleException(ExceptionHandling ex){
		
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
