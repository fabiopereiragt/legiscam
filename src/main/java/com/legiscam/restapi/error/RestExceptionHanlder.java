package com.legiscam.restapi.error;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHanlder {
	
	// error handle for NotFound
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex){
		ResourseNotFoundDetails notFoundDetails = ResourseNotFoundDetails.Builder.builder()
		.Timestamp(new Date().getTime())
		.Status(HttpStatus.NOT_FOUND.value())
		.Title("Resource not found")
		.Detail(ex.getMessage())
		.DeveloperMessage(ex.getClass().getName()).build();
		
		return new ResponseEntity<>(notFoundDetails, HttpStatus.NOT_FOUND);
	}
	
	
	// error handle for @Valid	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		
		String fields = fieldErrors.stream()
				.map(FieldError::getField)
				.collect(Collectors.joining(" - "));
		
		String fieldMessages = fieldErrors.stream()
				.map(FieldError::getDefaultMessage)
				.collect(Collectors.joining(" - "));
				
		ValidationErrorDetails validationErrorDetails = ValidationErrorDetails.Builder.builder()
		.Timestamp(new Date().getTime())
		.Status(HttpStatus.BAD_REQUEST.value())
		.Title("Field validation error")
		.Detail("Field validation error")
		.DeveloperMessage(ex.getClass().getName())
		.Field(fields)
		.FieldMessage(fieldMessages)
		.build();
		
		return new ResponseEntity<>(validationErrorDetails, HttpStatus.BAD_REQUEST);
	}


}
