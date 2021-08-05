package com.assignment.favourite.recipes.exception;

public class RecipesNotFoundException extends Exception {
	
	    public RecipesNotFoundException() {
	        super();
	    }

	    public RecipesNotFoundException(String message) {
	        super(message);
	    }

	    public RecipesNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public RecipesNotFoundException(Throwable cause) {
	        super(cause);
	    }
	    protected RecipesNotFoundException(String message, Throwable cause,
                boolean enableSuppression,
                boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		}

}
