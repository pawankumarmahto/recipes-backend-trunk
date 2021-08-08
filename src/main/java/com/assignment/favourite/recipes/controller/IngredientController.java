package com.assignment.favourite.recipes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.favourite.recipes.dto.IngredientDTO;
import com.assignment.favourite.recipes.exception.IngredientException;
import com.assignment.favourite.recipes.service.IngredientService;
/**
 * {@link IngredientController}
 * 
 * Ingredients controller to handle the request for Add,  fetch operation

 * @author Pawan.Mahto
 *
 */

@RestController
public class IngredientController {
	
	private static final Logger logger = LoggerFactory.getLogger(IngredientController.class);

	@Autowired
	private IngredientService ingredientService;
	
	@RequestMapping(value = "/level1/fetchIngredients", method = RequestMethod.GET)
	public List<IngredientDTO> fetchIngredients() throws IngredientException{
		logger.info(" In fetchIngredients() of  IngredientController ");
		List<IngredientDTO> ingredientList = ingredientService.fetchIngredients();
		return ingredientList;
	}

	@RequestMapping(value = "/level2/addIngredient", method = RequestMethod.POST)
	public IngredientDTO addIngredient(@RequestBody IngredientDTO ingredientDTO)  throws IngredientException {
		logger.info(" In addIngredient() of  IngredientController ");
		return ingredientService.saveIngredient(ingredientDTO);
	}
	
	@RequestMapping(value = "/level2/deleteIngredient/{id}", method = RequestMethod.DELETE)
	public String deleteIngredient(@PathVariable("id") Long ingredientId) throws IngredientException{
		logger.info(" In deleteIngredient() of  IngredientController ");
		 ingredientService.deleteIngredient(ingredientId);
		 return "Ingredient is deleted successfully";
	}
	
	@RequestMapping(value = "/level2/deleteIngredientByName/{ingredientName}", method = RequestMethod.DELETE)
	public String deleteIngredientByName(@PathVariable("ingredientName") String ingredientName) throws IngredientException{
		logger.info(" In deleteIngredient() of  IngredientController ");
		 ingredientService.deleteIngredientByName(ingredientName);
		 return "Ingredient is deleted successfully";
	}
}
