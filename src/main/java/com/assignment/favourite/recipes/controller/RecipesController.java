package com.assignment.favourite.recipes.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.entity.Recipes;
import com.assignment.favourite.recipes.exception.RecipesNotFoundException;
import com.assignment.favourite.recipes.service.RecipesService;

@RestController
public class RecipesController {

	private static final Logger logger = LoggerFactory.getLogger(RecipesController.class);
	
	@Autowired
	private RecipesService recepesService;
	
	@RequestMapping(value = "/level1/fetchRecipes", method = RequestMethod.GET)
	public ResponseEntity<List<Recipes>>  fetchRecipes() {
		List<Recipes> recipesList =  recepesService.fetchRecipes();
		return  new ResponseEntity<List<Recipes>>(recipesList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/level2/addRecipes", method = RequestMethod.POST)
	public String  addRecipes(@RequestBody Recipes recipes) {
		return recepesService.saveRecipes(recipes);
	}
	
	@RequestMapping(value = "/level2/delete/{id}", method = RequestMethod.DELETE)
	public String deleteRecipe(@PathVariable("id") Long recipesId) throws RecipesNotFoundException {
		return recepesService.deleteRecipes(recipesId);
	}
	
	@RequestMapping(value = "/level2/deleteAllRecipes", method = RequestMethod.DELETE)
	public String deleteAllRecipes() {
		 recepesService.deleteAllRecipes();
		 return "Recipes is deleted Successfully";
	}

	@RequestMapping(value = "/level2/updateRecipes", method = RequestMethod.PUT)
	public String  updateRecipes( @RequestBody Recipes recipes) throws RecipesNotFoundException {
		return recepesService.updateRecipes(recipes);
	}
	
}
