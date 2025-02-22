package com.serratec.trabalhofinal.model.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.serratec.trabalhofinal.model.error.ErrorMessage;
import com.serratec.trabalhofinal.model.exception.ResourceBadRequestException;
import com.serratec.trabalhofinal.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class ApiHandlerException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> HandleResourceNotFoundException(ResourceNotFoundException exception) {
		
		ErrorMessage errorMessage = new ErrorMessage("Not Found",
				HttpStatus.NOT_FOUND.value(),
				exception.getMessage(),
				exception.getClass().getName(),
				new Date().getTime());
		
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<?> HandleResourceBadRequestException(ResourceBadRequestException exception) {
		
		ErrorMessage errorMessage = new ErrorMessage("Bad Request",
				HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(),
				exception.getClass().getName(),
				new Date().getTime());
		
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> HandleResourceBadRequestException(Exception exception) {
		
		ErrorMessage errorMessage = new ErrorMessage("Internal Server Error",
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				exception.getMessage(),
				exception.getClass().getName(),
				new Date().getTime());
		
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
