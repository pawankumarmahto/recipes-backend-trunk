package com.assignment.favourite.recipes.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.favourite.recipes.controller.IngredientController;
import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.repository.IngredientRepository;
import com.assignment.favourite.recipes.service.IngredientService;

@Service
public class IngredientServiceImpl  implements IngredientService{

	private static final Logger logger = LoggerFactory.getLogger(IngredientController.class);

	@Autowired
	private IngredientRepository repository; 
	
	public List<Ingredients> fetchIngredients() {
		return repository.findAll();
	}
	
	public Ingredients saveIngredient(Ingredients ingredient) {
		
		ingredient.setCreatedAt(LocalDateTime.now());
		ingredient.setUpdatedAt(LocalDateTime.now());
		return repository.save(ingredient);
	}
	
	public void deleteIngredient(Long ingredientId) {
		 repository.deleteById(ingredientId);
	}
	
}
