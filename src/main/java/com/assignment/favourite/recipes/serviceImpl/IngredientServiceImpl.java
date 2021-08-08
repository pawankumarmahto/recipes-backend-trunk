package com.assignment.favourite.recipes.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.assignment.favourite.recipes.converter.DateTimeConverter;
import com.assignment.favourite.recipes.dto.IngredientDTO;
import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.exception.ErrorMessage;
import com.assignment.favourite.recipes.exception.IngredientException;
import com.assignment.favourite.recipes.repository.IngredientRepository;
import com.assignment.favourite.recipes.service.IngredientService;

/**
 * {@link IngredientServiceImpl}
 * 
 * IngredientServiceImpl is used to write business logic for Ingredients
 * 
 * @author Pawan.Mahto
 *
 */
@Service
public class IngredientServiceImpl  implements IngredientService{

	private static final Logger logger = LoggerFactory.getLogger(IngredientServiceImpl.class);

	@Autowired
	private IngredientRepository repository; 
	
	/**
	 * Code to fetch all ingredients available
	 * Checking first if ingredient  is available, if not  throwing the message : No ingredients found!
	 * if recipe is available proceeding with fetching the ingredients
	 */
	public List<IngredientDTO> fetchIngredients()  throws IngredientException {
		
		logger.info(" In fetchIngredients() of  IngredientServiceImpl ");
		ErrorMessage message = new ErrorMessage();
		IngredientException	ex =  new IngredientException();
		/**
		 * fetching all ingredients
		 */
		List<Ingredients> ingredientList = repository.findAll();
		
		if (ingredientList==null || ingredientList.size()==0) {
			logger.error(" In fetchIngredients() of  IngredientServiceImpl : No Ingredients found!");
			message.setStatus(HttpStatus.NOT_FOUND);
			message.setMessage("No Ingredients found!");
			ex.setErrorMessage(message);
			throw ex;
		}
		/**
		 *  Converting ingredient List to IngredientDTO List Object
		 */
		List<IngredientDTO> ingredientDTOList =
		ingredientList.stream().map(ingredient-> new IngredientDTO(ingredient.getIngredientId(),
																	ingredient.getIngredientsName(),
																	ingredient.getCreatedAt(),
																	ingredient.getUpdatedAt() )).collect(Collectors.toList());
		
		return ingredientDTOList;
	}
	
	/**
	 * Adding new Ingredient
	 * Checking first if Ingredient is available, if not  throwing the message : Ingredient already exists, can't be added!
	 * if Ingredient is available proceeding with save Ingredient
	 */
	public IngredientDTO saveIngredient(IngredientDTO ingredientDTO) throws IngredientException {
		logger.info(" In saveIngredient() of  IngredientServiceImpl ");
		ErrorMessage message = new ErrorMessage();
		IngredientException	ex =  new IngredientException();
		/**
		 * checking the ingredient, if available by ingredient name
		 */
		Optional<Ingredients> optional = repository.findByIngredientsName(ingredientDTO.getIngredientsName()); 
		if(optional.isPresent()) {
			logger.error(" In saveIngredient() of  IngredientServiceImpl : Ingredient already exists, can't be added!");
			message.setStatus(HttpStatus.FOUND);
			message.setMessage("Ingredient already exists, can't be added!");
			ex.setErrorMessage(message);
			throw ex;
		}  
		try {
			/**
			 *  Converting ingredient tDTO to Ingredient Object
			 */
			Ingredients ingredient = new Ingredients();
			BeanUtils.copyProperties(ingredientDTO, ingredient);
			
			ingredient.setCreatedAt(DateTimeConverter.getCurrentDateTime());
			ingredient.setUpdatedAt(DateTimeConverter.getCurrentDateTime());
			
			/**
			 * saving the ingredient
			 */
			ingredient = repository.save(ingredient);
			
			BeanUtils.copyProperties(ingredient, ingredientDTO);
		} catch (Exception exe) {
			logger.error(" In saveIngredient() of  IngredientServiceImpl : Something went wrong while saving Ingredient!");
			message.setStatus(HttpStatus.BAD_REQUEST);
			message.setMessage("Something went wrong while saving Ingredient!");
			ex.setErrorMessage(message);
			throw ex;
		}
		return ingredientDTO;
	}
	
	public void deleteIngredient(Long ingredientId) throws IngredientException{
		logger.info(" In deleteIngredient() of  IngredientServiceImpl ");
		ErrorMessage message = new ErrorMessage();
		IngredientException	ex =  new IngredientException();
		/**
		 * checking the ingredient, if exists by ingredient id
		 */
		if (!repository.existsById(ingredientId)) {
			logger.error(" In deleteIngredient() of  IngredientServiceImpl : Ingredient not found!");
			message.setStatus(HttpStatus.NOT_FOUND);
			message.setMessage("Ingredient not found!");
			ex.setErrorMessage(message);
			throw ex;
		} 
		/**
		 * deleting the ingredient by ingredient Id
		 */
		try {
			repository.deleteById(ingredientId);
		}catch(Exception exe) {
			logger.error(" In deleteIngredient() of  IngredientServiceImpl : Something went wrong while deleting Ingredient ");
			message.setStatus(HttpStatus.BAD_REQUEST);
			message.setMessage("Something went wrong while deleting Ingredient !");
			ex.setErrorMessage(message);
			throw ex;
		}
	}
	/**
	 * Function to delete Ingredient By ingredientName
	 *  Checking first if Ingredient is available, if not  throwing the message :Ingredient not found!
	 * if Ingredient is available proceeding with delete Ingredient by id
	 */
	public void deleteIngredientByName(String ingredientName) throws IngredientException{
		logger.info(" In deleteIngredientByName() of  IngredientServiceImpl ");
		ErrorMessage message = new ErrorMessage();
		IngredientException	ex =  new IngredientException();
		/**
		 * checking the ingredient, if exists by ingredient name
		 */
		Optional<Ingredients> optional = repository.findByIngredientsName(ingredientName); 
		if(!optional.isPresent()) {
			logger.error(" In deleteIngredientByName() of  IngredientServiceImpl : Ingredient not found!");
			message.setStatus(HttpStatus.NOT_FOUND);
			message.setMessage("Ingredient does not exists, can't be deleted!");
			ex.setErrorMessage(message);
			throw ex;
		}  
		/**
		 * deleting the ingredient by ingredient Id
		 */
		try {
			repository.deleteByIngredientsName(ingredientName);
		}catch(Exception exe) {
			logger.error(" In deleteIngredientByName() of  IngredientServiceImpl : Something went wrong while deleting Ingredient !");
			message.setStatus(HttpStatus.BAD_REQUEST);
			message.setMessage("Something went wrong while deleting Ingredient !");
			ex.setErrorMessage(message);
			throw ex;
		}
	}
	
}
