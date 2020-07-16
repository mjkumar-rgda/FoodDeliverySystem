package com.base.foodDeliverySystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorResponse> recordNotFoundException(RecordNotFoundException e){
		
		return new ResponseEntity<>(new ErrorResponse(e.getMessage(), "Bad_Request"), HttpStatus.BAD_REQUEST);
	}
	
	
}
