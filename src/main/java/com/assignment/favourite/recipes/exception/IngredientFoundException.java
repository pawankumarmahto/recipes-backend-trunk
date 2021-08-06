package com.assignment.favourite.recipes.exception;

public class IngredientFoundException extends Exception{
	
	public IngredientFoundException() {
        super();
    }

    public IngredientFoundException(String message) {
        super(message);
    }
}