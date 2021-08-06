package com.assignment.favourite.recipes.ingredientcontroller.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment.favourite.recipes.controller.IngredientController;
import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.repository.IngredientRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class IntgredientTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private  IngredientRepository ingredientRepository;
	
	@Autowired
	private IngredientController ingredientController;
	
	@Test
	public void addIngredientTest () throws Exception {
		Ingredients ingredient = new Ingredients();
		ingredient.setIngredientId(10L);
		ingredient.setIngredientsName("Jira");
	}
	
}
