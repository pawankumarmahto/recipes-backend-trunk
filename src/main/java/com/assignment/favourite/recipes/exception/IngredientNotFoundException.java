package com.assignment.favourite.recipes.exception;

public class IngredientNotFoundException extends Exception{
	
	 public IngredientNotFoundException() {
	        super();
	    }

	    public IngredientNotFoundException(String message) {
	        super(message);
	    }

	    public IngredientNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public IngredientNotFoundException(Throwable cause) {
	        super(cause);
	    }
	    protected IngredientNotFoundException(String message, Throwable cause,
             boolean enableSuppression,
             boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		}
}
