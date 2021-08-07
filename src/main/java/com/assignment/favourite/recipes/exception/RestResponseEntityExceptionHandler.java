package com.assignment.favourite.recipes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(RecipesNotFoundException.class)
	public ResponseEntity<ErrorMessage> recipesNotFoundException(RecipesNotFoundException exception,
												WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		
	}

	@ExceptionHandler(IngredientNotFoundException.class)
	public ResponseEntity<ErrorMessage> ingredientNotFoundException(IngredientNotFoundException exception,
												WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		
	}
	
	@ExceptionHandler(RecipesFoundException.class)
	public ResponseEntity<ErrorMessage> recipesFoundException(RecipesFoundException exception,
												WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.FOUND).body(message);
		
	}
	
	@ExceptionHandler(IngredientFoundException.class)
	public ResponseEntity<ErrorMessage> ingredientFoundException(IngredientFoundException exception,
												WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.FOUND).body(message);
		
	}
	
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<ErrorMessage> userFoundException(UserFoundException exception,
												WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.FOUND).body(message);
		
	}
}
