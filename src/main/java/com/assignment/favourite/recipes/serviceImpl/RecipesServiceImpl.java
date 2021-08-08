package com.assignment.favourite.recipes.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.assignment.favourite.recipes.converter.DateTimeConverter;
import com.assignment.favourite.recipes.dto.RecipesDTO;
import com.assignment.favourite.recipes.dto.UsedIngredientsDTO;
import com.assignment.favourite.recipes.entity.Recipes;
import com.assignment.favourite.recipes.entity.Role;
import com.assignment.favourite.recipes.entity.UsedIngredients;
import com.assignment.favourite.recipes.exception.ErrorMessage;
import com.assignment.favourite.recipes.exception.RecipesException;
import com.assignment.favourite.recipes.repository.RecipesRepository;
import com.assignment.favourite.recipes.service.RecipesService;

/**
 * {@link RecipesServiceImpl}
 * 
 * RecipesServiceImpl is used to write business logic for Recipes
 * 
 * @author Pawan.Mahto
 *
 */

@Service
public class RecipesServiceImpl implements RecipesService {
	
	private static final Logger logger = LoggerFactory.getLogger(RecipesServiceImpl.class);
	
	@Autowired
	private RecipesRepository repository; 
	
	public List<RecipesDTO> fetchRecipes() throws RecipesException{
		
		List<Recipes> recipesList=  repository.findAll();
		
		if (recipesList==null || recipesList.size()==0) {
			ErrorMessage message = new ErrorMessage();
			RecipesException	ex =  new RecipesException();
			message.setStatus(HttpStatus.NOT_FOUND);
			message.setMessage("No Repipe found!");
			ex.setErrorMessage(message);
			throw ex;
		}
		
		List<RecipesDTO> recipesDTOList = new ArrayList<>();
		/**
		 *  Converting recipesList to List of RecipesDTO List
		 */
		recipesList.forEach(recipe -> {
			RecipesDTO recipesDTO = new RecipesDTO();
			fetchUsedIngredients(recipe, recipesDTO);
			recipesDTO.setRecipesId(recipe.getRecipesId());
			recipesDTO.setRecipesName(recipe.getRecipesName());
			recipesDTO.setRecipesType(recipe.getRecipesType());
			recipesDTO.setNoOfPerson(recipe.getNoOfPerson());
			recipesDTO.setCookingInstruction(recipe.getCookingInstruction());
			recipesDTO.setUpdatedAt(recipe.getUpdatedAt());
			recipesDTO.setPreparedAt(recipe.getPreparedAt());
			recipesDTOList.add(recipesDTO);
		});
		return  recipesDTOList;
	}
	
	public void saveRecipe(RecipesDTO recipesDTO) throws RecipesException {
		logger.info(" In saveRecipes() of  RecipesServiceImpl ");
		
		ErrorMessage message = new ErrorMessage();
		RecipesException	ex =  new RecipesException();
		
		Optional<Recipes> optional = repository.findByRecipesName(recipesDTO.getRecipesName()); 
		if(optional.isPresent()) {
			message.setStatus(HttpStatus.FOUND);
			message.setMessage("Recipe already exists, can't be added!");
			ex.setErrorMessage(message);
			throw ex;
		}  
		
		Recipes recipe = new Recipes();
		BeanUtils.copyProperties(recipesDTO, recipe);
		
		Set<UsedIngredients> usedIngredients =recipesDTO.getUsedingredients().stream()
				.map(ingredient-> new UsedIngredients(ingredient.getId(), ingredient.getUsedIngredientId(),ingredient.getUsedIngredientsName() ))
       		 .collect(Collectors.toSet());
        
		recipe.setUsedingredients(usedIngredients);
		
		recipe.setPreparedAt(DateTimeConverter.getCurrentDateTime());
		try {
			repository.save(recipe);
		} catch (Exception exe) {
			message.setStatus(HttpStatus.BAD_REQUEST);
			message.setMessage("Something went wrong while saving Recipe!");
			ex.setErrorMessage(message);
			throw ex;
		}
	}
	
	public void deleteRecipe(Long recipesId) throws RecipesException {
		logger.info(" In deleteRecipes() of  RecipesServiceImpl ");
		
		ErrorMessage message = new ErrorMessage();
		RecipesException	ex =  new RecipesException();
		
		if (!repository.existsById(recipesId)) {
			
			message.setStatus(HttpStatus.NOT_FOUND);
			message.setMessage("Recipe not found, can't be deleted!");
			ex.setErrorMessage(message);
			throw ex;
		}
		try {
			repository.deleteById(recipesId);
		} catch (Exception exe) {
			message.setStatus(HttpStatus.BAD_REQUEST);
			message.setMessage("Something went wrong while deleting Recipe!");
			ex.setErrorMessage(message);
			throw ex;
		}
		
	}
	
	public void deleteAllRecipes() throws RecipesException{
		logger.info(" In deleteAllRecipes() of  RecipesServiceImpl ");
		
		ErrorMessage message = new ErrorMessage();
		RecipesException	ex =  new RecipesException();
		
		Long count = repository.count();
		
		if (count<=0) {
			message.setStatus(HttpStatus.NOT_FOUND);
			message.setMessage("Recipe not found, can't be deleted!");
			ex.setErrorMessage(message);
			throw ex;
		}
		
		try {
			repository.deleteAll();
		} catch (Exception exe) {
			message.setStatus(HttpStatus.BAD_REQUEST);
			message.setMessage("Something went wrong while deleting Recipe!");
			ex.setErrorMessage(message);
			throw ex;
		}
		
		
	}
	
	public void  updateRecipe(RecipesDTO recipesDTO) throws RecipesException{

		logger.info(" In updateRecipes() of  RecipesServiceImpl ");
		
		ErrorMessage message = new ErrorMessage();
		RecipesException	ex =  new RecipesException();
		
		Optional<Recipes> optional = repository.findByRecipesName(recipesDTO.getRecipesName()); 
		if(!optional.isPresent()) {
			
			message.setStatus(HttpStatus.NOT_FOUND);
			message.setMessage("Recipe does not exists can not be updated!");
			ex.setErrorMessage(message);
			throw ex;
		}  
		
		Recipes recipe = new Recipes();
		BeanUtils.copyProperties(recipesDTO, recipe);
		try {
			repository.save(recipe);
		}catch (Exception exe) {
			message.setStatus(HttpStatus.BAD_REQUEST);
			message.setMessage("Something went wrong while updating Recipe!");
			ex.setErrorMessage(message);
			throw ex;
		}
	}
	
	private void fetchUsedIngredients(Recipes recipe, RecipesDTO recipesDTO) {
		Set<UsedIngredientsDTO> usedIngredients = new HashSet<UsedIngredientsDTO>();
		if(!recipe.getUsedingredients().isEmpty()) {
			usedIngredients =recipe.getUsedingredients().stream()
					.map(ingredient-> new UsedIngredientsDTO(ingredient.getId(), ingredient.getUsedIngredientId(),ingredient.getUsedIngredientsName() ))
	       		 .collect(Collectors.toSet());
		}
		recipesDTO.setUsedingredients(usedIngredients);
	}

}
