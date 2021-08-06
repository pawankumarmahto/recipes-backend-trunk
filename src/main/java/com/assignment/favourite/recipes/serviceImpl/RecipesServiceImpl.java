package com.assignment.favourite.recipes.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.favourite.recipes.converter.DateTimeConverter;
import com.assignment.favourite.recipes.entity.Recipes;
import com.assignment.favourite.recipes.exception.RecipesFoundException;
import com.assignment.favourite.recipes.exception.RecipesNotFoundException;
import com.assignment.favourite.recipes.repository.RecipesRepository;
import com.assignment.favourite.recipes.service.RecipesService;

@Service
public class RecipesServiceImpl implements RecipesService {
	
	private static final Logger logger = LoggerFactory.getLogger(RecipesServiceImpl.class);
	
	@Autowired
	private RecipesRepository repository; 
	
	public List<Recipes> fetchRecipes() {
		return repository.findAll();
	}
	
	public void saveRecipes(Recipes recipes) throws RecipesFoundException {
		logger.info(" In saveRecipes() of  RecipesServiceImpl ");
		if (repository.existsById(recipes.getRecipesId())) {
			throw new RecipesFoundException("Recipe already exists, can't be added!");
		} 
		recipes.setPreparedAt(DateTimeConverter.getCurrentDateTime());
		recipes.setUpdatedAt(DateTimeConverter.getCurrentDateTime());
		repository.save(recipes);
	}
	
	public void deleteRecipes(Long recipesId) throws RecipesNotFoundException {
		logger.info(" In deleteRecipes() of  RecipesServiceImpl ");
		String message = "";
		if (!repository.existsById(recipesId)) {
			throw new RecipesNotFoundException("Recipe not found");
		}
		repository.deleteById(recipesId);
	}
	
	public void deleteAllRecipes() {
		logger.info(" In deleteAllRecipes() of  RecipesServiceImpl ");
		repository.deleteAll();
	}
	
	public String  updateRecipes(Recipes recipes) throws RecipesNotFoundException{
		
		logger.info(" In updateRecipes() of  RecipesServiceImpl ");
		if (repository.existsById(recipes.getRecipesId())) {
			repository.save(recipes);
		} else {
			throw new RecipesNotFoundException("Recipes not found");
		}
		return "Recipe is updated successfully";
	}
}
