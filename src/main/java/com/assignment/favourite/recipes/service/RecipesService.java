package com.assignment.favourite.recipes.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.assignment.favourite.recipes.entity.Recipes;
import com.assignment.favourite.recipes.exception.RecipesNotFoundException;

public interface RecipesService {

	public List<Recipes> fetchRecipes();
	
	public String saveRecipes(Recipes recipes);
	
	public String deleteRecipes(Long RecipesId) throws RecipesNotFoundException;
	
	public void deleteAllRecipes();
	
	public String  updateRecipes( Recipes recipes) throws RecipesNotFoundException ;

}
