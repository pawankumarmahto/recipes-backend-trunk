package com.assignment.favourite.recipes.service;

import java.util.List;

import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.exception.IngredientNotFoundException;

public interface IngredientService {
	
	public List<Ingredients> fetchIngredients();
	
	public Ingredients saveIngredient(Ingredients ingredient);
	
	public void deleteIngredient(Long ingredientId) throws IngredientNotFoundException;
}
