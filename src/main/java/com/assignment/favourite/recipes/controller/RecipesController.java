package com.assignment.favourite.recipes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.favourite.recipes.dto.RecipesDTO;
import com.assignment.favourite.recipes.exception.RecipesException;
import com.assignment.favourite.recipes.service.RecipesService;

/**
 * {@link RecipesController}
 * 
 * Recipes controller to handle the request for Add, delete, update, fetch  operations
 *  
 * @author Pawan.Mahto
 *
 */

@RestController
public class RecipesController {

	private static final Logger logger = LoggerFactory.getLogger(RecipesController.class);
	
	@Autowired
	private RecipesService recepesService;
	
	@RequestMapping(value = "/level1/fetchRecipes", method = RequestMethod.GET)
	public ResponseEntity<List<RecipesDTO>>  fetchRecipes() throws RecipesException {
		logger.info(" In fetchRecipes() of  RecipesController ");
		List<RecipesDTO> recipesList =  recepesService.fetchRecipes();
		return  new ResponseEntity<List<RecipesDTO>>(recipesList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/level2/addRecipe", method = RequestMethod.POST)
	public String  addRecipe(@RequestBody RecipesDTO recipesDTO) throws RecipesException {
		logger.info(" In addRecipe() of  RecipesController ");
		 recepesService.saveRecipe(recipesDTO);
		 return "Recipe is added successfully";
	}
	
	@RequestMapping(value = "/level2/delete/{id}", method = RequestMethod.DELETE)
	public String deleteRecipe(@PathVariable("id") Long recipesId) throws RecipesException {
		logger.info(" In deleteRecipe() of  RecipesController ");
		 recepesService.deleteRecipe(recipesId);
		 return "Recipe is deleted successfully";
	}
	
	@RequestMapping(value = "/level2/deleteByName/{recipeName}", method = RequestMethod.DELETE)
	public String deleteRecipeByrecipeName(@PathVariable("recipeName") String recipeName) throws RecipesException {
		logger.info(" In deleteRecipe() of  RecipesController ");
		 recepesService.deleteRecipeByName(recipeName);
		 return "Recipe is deleted successfully";
	}
	
	@RequestMapping(value = "/level2/deleteAllRecipes", method = RequestMethod.DELETE)
	public String deleteAllRecipes() throws RecipesException {
		logger.info(" In deleteAllRecipes() of  RecipesController ");
		 recepesService.deleteAllRecipes();
		 return "Recipe is deleted Successfully";
	}

	@RequestMapping(value = "/level2/updateRecipe", method = RequestMethod.PUT)
	public String  updateRecipe( @RequestBody RecipesDTO recipesDTO) throws RecipesException {
		logger.info(" In updateRecipe() of  RecipesController ");
		 recepesService.updateRecipe(recipesDTO);
		 return "Recipe successfully updated!";
	}
}
