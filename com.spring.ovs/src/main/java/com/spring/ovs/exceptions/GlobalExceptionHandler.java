package com.spring.swagger.ovs.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(ElectionOfficerNotFoundException.class)
	public ResponseEntity<?> UserNotFoundHandling(ElectionOfficerNotFoundException exception)
	{
		ErrorDetails errormessage=new ErrorDetails("OfficerNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> CustomValidationErrorHandling(MethodArgumentNotValidException exception)
	{
		ErrorDetails errormessage=new ErrorDetails("Validation Error",exception.getBindingResult().getFieldError().getDefaultMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.BAD_REQUEST);
	}
	
	

}


