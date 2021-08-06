package com.assignment.favourite.recipes.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.favourite.recipes.converter.DateTimeConverter;
import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.entity.Users;
import com.assignment.favourite.recipes.exception.IngredientFoundException;
import com.assignment.favourite.recipes.exception.IngredientNotFoundException;
import com.assignment.favourite.recipes.repository.IngredientRepository;
import com.assignment.favourite.recipes.service.IngredientService;

@Service
public class IngredientServiceImpl  implements IngredientService{

	private static final Logger logger = LoggerFactory.getLogger(IngredientServiceImpl.class);

	@Autowired
	private IngredientRepository repository; 
	
	public List<Ingredients> fetchIngredients() {
		logger.info(" In fetchIngredients() of  IngredientServiceImpl ");
		return repository.findAll();
	}
	
	public Ingredients saveIngredient(Ingredients ingredient) throws IngredientFoundException {
		logger.info(" In saveIngredient() of  IngredientServiceImpl ");
		
		Optional<Users> optional = repository.findByIngredientsName(ingredient.getIngredientsName()); 
		if(optional.isPresent()) {
			throw new IngredientFoundException("Ingredient already exists, can't be added!");
		}  
		
		ingredient.setCreatedAt(DateTimeConverter.getCurrentDateTime());
		ingredient.setUpdatedAt(DateTimeConverter.getCurrentDateTime());
		return repository.save(ingredient);
	}
	
	public void deleteIngredient(Long ingredientId) throws IngredientNotFoundException{
		logger.info(" In deleteIngredient() of  IngredientServiceImpl ");
		if (repository.existsById(ingredientId)) {
			repository.deleteById(ingredientId);
		} else {
			throw new IngredientNotFoundException("Ingredient not found");
		}
	}
	
}
