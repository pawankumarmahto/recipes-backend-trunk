package com.assignment.favourite.recipes.service;

import java.util.List;

import com.assignment.favourite.recipes.dto.RecipesDTO;
import com.assignment.favourite.recipes.exception.RecipesException;

public interface RecipesService {

	public List<RecipesDTO> fetchRecipes()  throws RecipesException;
	
	public void saveRecipe(RecipesDTO recipesDTO) throws   RecipesException;
	
	public void deleteRecipe(Long RecipesId)  throws RecipesException;
	
	public void deleteAllRecipes() throws RecipesException;
	
	public void  updateRecipe(RecipesDTO recipesDTO) throws RecipesException ;

}
