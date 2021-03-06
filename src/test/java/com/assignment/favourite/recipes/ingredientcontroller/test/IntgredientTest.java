package com.assignment.favourite.recipes.ingredientcontroller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.assignment.favourite.recipes.controller.IngredientController;
import com.assignment.favourite.recipes.dto.IngredientDTO;
import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.repository.IngredientRepository;

@SpringBootTest
public class IntgredientTest {

	@MockBean
	private  IngredientRepository ingredientRepository;
	
	@Autowired
	private IngredientController ingredientController;
	
	@Test
	public void addIngredientWithPositiveScenario () throws Exception {
		Ingredients ingredient = new Ingredients();
		ingredient.setIngredientId(10L);
		ingredient.setIngredientsName("Jira");
		
		IngredientDTO ingredientDTO = new IngredientDTO();
		Mockito.when(ingredientRepository.findByIngredientsName(Mockito.anyString())).thenReturn( Optional.of(new Ingredients()));
		Mockito.when(ingredientRepository.save(Mockito.any(Ingredients.class))).thenReturn(ingredient);
		ingredientDTO = ingredientController.addIngredient(ingredientDTO);
		assertNotNull(ingredientDTO);
	}
	
	@Test
	public void addIngredientWithNegativeScenario () throws Exception {
		Ingredients ingredient = new Ingredients();
		ingredient.setIngredientId(10L);
		ingredient.setIngredientsName("Jira");
		Mockito.when(ingredientRepository.findByIngredientsName(Mockito.anyString())).thenReturn( Optional.of(ingredient));
		
		try {
			IngredientDTO ingredientDTO = new IngredientDTO();
			ingredientDTO = ingredientController.addIngredient(ingredientDTO);
		} catch(Exception e) {
			
		}
	}

	/**
	 * fetchIngredients 
	 * mocking the findAll() Method with list of ingredient 
	 * @throws Exception
	 */
	@Test
	public void fetchIngredientsWithpositiveScenario() throws Exception{
		Ingredients ingredient = new Ingredients();
		ingredient.setIngredientId(10L);
		ingredient.setIngredientsName("Jira");
		
		List<Ingredients> ingredientList = new ArrayList<>();
		ingredientList.add(ingredient);
		Mockito.when(ingredientRepository.findAll()).thenReturn(ingredientList);
		List<IngredientDTO> result = ingredientController.fetchIngredients();
		assertNotNull(result);

	}
	/**
	 * fetchIngredients 
	 * mocking the findAll() Method with null
	 * @throws Exception
	 */
	@Test
	public void fetchIngredientsWithNegativeScenario() throws Exception{
		Mockito.when(ingredientRepository.findAll()).thenReturn(null);
		try {
			List<IngredientDTO> result = ingredientController.fetchIngredients();
		} catch(Exception e) {
			
		}
	}
	
	/**
	 * deleteIngredient 
	 * mocking the existsById() Method with true 
	 * @throws Exception
	 */
	@Test
	public void deleteIngredientsWithPositiveScenario() throws Exception{
		
		Mockito.when(ingredientRepository.existsById(Mockito.anyLong())).thenReturn(true);
		Mockito.doNothing().when(ingredientRepository).deleteById(Mockito.anyLong());
		String result = ingredientController.deleteIngredient(10L);
		assertEquals( "Ingredient is deleted successfully", result);
	}
	
	/**
	 * deleteIngredient 
	 * mocking the existsById() Method with false 
	 * @throws Exception
	 */
	@Test
	public void deleteRecipesWithNegativeScenario() throws Exception{
		
		Mockito.when(ingredientRepository.existsById(Mockito.anyLong())).thenReturn(false);
		try {
			ingredientController.deleteIngredient(10L);
		} catch (Exception ex) {
			
		}
	}
	
}
