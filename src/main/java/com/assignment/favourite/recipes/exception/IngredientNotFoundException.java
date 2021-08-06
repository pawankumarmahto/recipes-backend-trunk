package com.assignment.favourite.recipes.exception;

public class IngredientNotFoundException extends Exception{
	
	public IngredientNotFoundException() {
        super();
    }

    public IngredientNotFoundException(String message) {
        super(message);
    }
}
