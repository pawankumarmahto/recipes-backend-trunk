package com.assignment.favourite.recipes.service;

import java.util.List;

import com.assignment.favourite.recipes.entity.Recipes;
import com.assignment.favourite.recipes.exception.RecipesFoundException;
import com.assignment.favourite.recipes.exception.RecipesNotFoundException;

public interface RecipesService {

	public List<Recipes> fetchRecipes();
	
	public void saveRecipes(Recipes recipes) throws RecipesFoundException;
	
	public void deleteRecipes(Long RecipesId) throws RecipesNotFoundException;
	
	public void deleteAllRecipes();
	
	public String  updateRecipes( Recipes recipes) throws RecipesNotFoundException ;

}
