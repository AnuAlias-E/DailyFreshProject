package com.training.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.training.dto.response.ErrorResponse;
import com.training.exception.ItemNotFoundException;
import com.training.exception.OutOfStockException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = ItemNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		System.out.println(e.getMessage());
		ErrorResponse response = new ErrorResponse();
		response.setStatusCode(404);
		response.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = OutOfStockException.class)
	public ResponseEntity<ErrorResponse> handleException1(Exception e) {
		System.out.println(e.getMessage());
		ErrorResponse response = new ErrorResponse();
		response.setStatusCode(404);
		response.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
