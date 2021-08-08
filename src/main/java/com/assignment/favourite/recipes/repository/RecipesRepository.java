package com.assignment.favourite.recipes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.favourite.recipes.entity.Recipes;
/**
 * {@link RecipesRepository}
 * 
 * RecipesRepository interface is for JPA functionality and to perform CRUD operations.
 * 
 * @author Pawan.Mahto
 */

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Long> {

	public  Optional<Recipes> findByRecipesName(String recipesName);
	
	public  void deleteByRecipeName(String recipesName);
	
}
