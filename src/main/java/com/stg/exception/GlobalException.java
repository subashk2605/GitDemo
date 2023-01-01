package com.stg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler (CustomException.class)
	private ResponseEntity<String> errorHandler(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
		
	}
}
