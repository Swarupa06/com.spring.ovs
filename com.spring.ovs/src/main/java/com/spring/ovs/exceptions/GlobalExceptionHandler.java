package com.spring.ovs.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DuplicateRecordException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> resouceNotFoundException(DuplicateRecordException ex, WebRequest request) {
    	ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }
    
	 @ExceptionHandler(ElectionOfficerNotFoundException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    public ResponseEntity<Object> resouceNotFoundException(ElectionOfficerNotFoundException ex, WebRequest request) {
	    	ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    	System.out.println("1");
	        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(UserNotFoundException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    public ResponseEntity<Object> resouceNotFoundException(UserNotFoundException ex, WebRequest request) {
	    	ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    	System.out.println("2");
	        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	    }
	

	 @ExceptionHandler(SocietyNotFoundException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    public ResponseEntity<Object> resouceNotFoundException(SocietyNotFoundException ex, WebRequest request) {
	    	ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    	System.out.println("3");
	        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	    }
	@ExceptionHandler(VoterNotFoundException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    public ResponseEntity<Object> resouceNotFoundException(UserNotFoundException ex, WebRequest request) {
	    	ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    	System.out.println("4");
	        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	    }

	 @ExceptionHandler(NominatedCandidateNotFoundException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    public ResponseEntity<Object> resouceNotFoundException(SocietyNotFoundException ex, WebRequest request) {
	    	ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    	System.out.println("5");
	        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	    }
}
