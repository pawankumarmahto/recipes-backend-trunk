package com.assignment.favourite.recipes.recipiescontroller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.assignment.favourite.recipes.controller.RecipesController;
import com.assignment.favourite.recipes.entity.Recipes;
import com.assignment.favourite.recipes.entity.UsedIngredients;
import com.assignment.favourite.recipes.exception.RecipesNotFoundException;
import com.assignment.favourite.recipes.repository.RecipesRepository;

@SpringBootTest
public class RecipesTest {
	
	@MockBean
	private RecipesRepository  recipesRepository;
	
	@Autowired
	private RecipesController recipesController;
	
	/**
	 * Adding a recipes which is not available in the DB 
	 * We are mocking the save Method and  findByRecipesName method 
	 * @throws Exception
	 */
	@Test
	public void addRecipesTestWithPositiveScenario() throws Exception{
		Mockito.when(recipesRepository.findByRecipesName(Mockito.anyString())).thenReturn(null);
		Mockito.when(recipesRepository.save(Mockito.any(Recipes.class))).thenReturn(getRecipes());
		String result = recipesController.addRecipes(getRecipes());
		assertEquals( "Recipe is saved successfully", result);
	}
	
	/**
	 * Adding a recipes which is  available in the DB 
	 * We are mocking the save Method and  findByRecipesName method 
	 * @throws Exception
	 */
	@Test
	public void addRecipesTestWithNegativeScenario() throws Exception{
		Mockito.when(recipesRepository.findByRecipesName(Mockito.anyString())).thenReturn( Optional.of(getRecipes()));
		Mockito.when(recipesRepository.save(Mockito.any(Recipes.class))).thenReturn(getRecipes());
		String result = recipesController.addRecipes(getRecipes());
		assertEquals( "Con not add, Recipes is already exist", result);
	}
	
	/**
	 * fetchRecipes 
	 * mocking the findAll() Method with list of recipes 
	 * @throws Exception
	 */
	@Test
	public void fetchRecipesWithpositiveScenario() throws Exception{
		
		List<Recipes> recipesList = new ArrayList<>();
		recipesList.add(getRecipes());
		Mockito.when(recipesRepository.findAll()).thenReturn(recipesList);
		ResponseEntity<List<Recipes>> result = recipesController.fetchRecipes();
		assertNotNull(result.getBody());

	}
	
	/**
	 * fetchRecipes 
	 * mocking the findAll() Method with null 
	 * @throws Exception
	 */
	@Test
	public void fetchRecipesWithNegativeScenario() throws Exception{
		List<Recipes> recipesList = new ArrayList<>();
		recipesList.add(getRecipes());
		Mockito.when(recipesRepository.findAll()).thenReturn(null);
		ResponseEntity<List<Recipes>> result = recipesController.fetchRecipes();
		assertNull(result.getBody());
	}
	
	/**
	 * deleteRecipe 
	 * mocking the existsById() Method with true 
	 * @throws Exception
	 */
	@Test
	public void deleteRecipesWithPositiveScenario() throws RecipesNotFoundException{
		
		Mockito.when(recipesRepository.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.doNothing().when(recipesRepository).deleteById(Mockito.anyLong());
		String result = recipesController.deleteRecipe(10L);
		assertEquals( "Recipe is deleted successfully", result);
	}
	
	/**
	 * deleteRecipe 
	 * mocking the existsById() Method with false 
	 * @throws Exception
	 */
	@Test
	public void deleteRecipesWithNegativeScenario() throws RecipesNotFoundException{
		
		Mockito.when(recipesRepository.existsById(Mockito.anyLong())).thenReturn(false);
		try {
			 recipesController.deleteRecipe(10L);
		} catch (RecipesNotFoundException ex) {
			
		}
	}
	
	/**
	 * Update a recipes
	 * mocking the existsById() Method with false and for save method is mocked with a recipes object
	 * @throws Exception
	 */
	@Test
	public void updateRecipesWithPositiveScenario() throws Exception{
		Mockito.when(recipesRepository.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.when(recipesRepository.save(Mockito.any(Recipes.class))).thenReturn(getRecipes());
		String result = recipesController.updateRecipes(getRecipes());
		assertEquals( "Recipe is updated successfully", result);
	}
	
	/**
	 * Update a recipes
	 * mocking the existsById() Method with true 
	 * @throws Exception
	 */
	@Test
	public void updateRecipesWithNegativeeScenario() throws Exception{
		Mockito.when(recipesRepository.existsById(Mockito.anyLong())).thenReturn(false);
		try {
			 recipesController.updateRecipes(getRecipes());
		} catch (RecipesNotFoundException ex) {
			
		}
	}
	
	private Recipes getRecipes() {
		UsedIngredients usedIn1 = new UsedIngredients();
		usedIn1.setUsedIngredientId(1);
		usedIn1.setUsedIngredientsName("turmuric");
		UsedIngredients usedIn2 = new UsedIngredients();
		usedIn2.setUsedIngredientId(2);
		usedIn2.setUsedIngredientsName("Oil");
		Set<UsedIngredients> set = new HashSet<>();
		set.add(usedIn1);
		set.add(usedIn2);
		
		Recipes recipes = new Recipes();
		recipes.setRecipesId(1L);
		recipes.setRecipesName("PaneervMasala");
		recipes.setRecipesType("Veg");
		recipes.setNoOfPerson(2);
		recipes.setCookingInstruction("xyz");
		recipes.setUsedingredients(set);
		return recipes;
	}
}
