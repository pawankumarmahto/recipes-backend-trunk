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
	
	public List<IngredientDTO> fetchIngredients()  throws IngredientException {
		
		logger.info(" In fetchIngredients() of  IngredientServiceImpl ");
		ErrorMessage message = new ErrorMessage();
		IngredientException	ex =  new IngredientException();
		
		List<Ingredients> ingredientList = repository.findAll();
		
		if (ingredientList==null || ingredientList.size()==0) {
			message.setStatus(HttpStatus.NOT_FOUND);
			message.setMessage("No Ingredients found!");
			ex.setErrorMessage(message);
			throw ex;
		}
		
		List<IngredientDTO> ingredientDTOList =
		ingredientList.stream().map(ingredient-> new IngredientDTO(ingredient.getIngredientId(),
																	ingredient.getIngredientsName(),
																	ingredient.getCreatedAt(),
																	ingredient.getUpdatedAt() )).collect(Collectors.toList());
		
		return ingredientDTOList;
	}
	
	public IngredientDTO saveIngredient(IngredientDTO ingredientDTO) throws IngredientException {
		logger.info(" In saveIngredient() of  IngredientServiceImpl ");
		ErrorMessage message = new ErrorMessage();
		IngredientException	ex =  new IngredientException();
		
		Optional<Ingredients> optional = repository.findByIngredientsName(ingredientDTO.getIngredientsName()); 
		if(optional.isPresent()) {
			message.setStatus(HttpStatus.FOUND);
			message.setMessage("Ingredient already exists, can't be added!");
			ex.setErrorMessage(message);
			throw ex;
		}  
		try {
			Ingredients ingredient = new Ingredients();
			BeanUtils.copyProperties(ingredientDTO, ingredient);
			
			ingredient.setCreatedAt(DateTimeConverter.getCurrentDateTime());
			ingredient.setUpdatedAt(DateTimeConverter.getCurrentDateTime());
			ingredient = repository.save(ingredient);
			
			BeanUtils.copyProperties(ingredient, ingredientDTO);
		} catch (Exception exe) {
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

		if (!repository.existsById(ingredientId)) {
			message.setStatus(HttpStatus.NOT_FOUND);
			message.setMessage("Ingredient not found !aaa");
			ex.setErrorMessage(message);
			throw ex;
		} 
		try {
			repository.deleteById(ingredientId);
		}catch(Exception exe) {
			message.setStatus(HttpStatus.BAD_REQUEST);
			message.setMessage("Something went wrong while deleting Ingredient !");
			ex.setErrorMessage(message);
			throw ex;
		}
		
	}
	
}
