package com.assignment.favourite.recipes.service;

import java.util.List;

import com.assignment.favourite.recipes.dto.IngredientDTO;
import com.assignment.favourite.recipes.exception.IngredientException;


public interface IngredientService {
	
	public List<IngredientDTO> fetchIngredients() throws IngredientException;
	
	public IngredientDTO saveIngredient(IngredientDTO ingredientDTO)  throws IngredientException;
	
	public void deleteIngredient(Long ingredientId) throws IngredientException;
}
