package com.assignment.favourite.recipes.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.entity.Users;

/**
 * {@link IngredientRepository}
 * 
 * IngredientRepository interface is for JPA functionality and to perform CRUD operations.
 * 
 * @author Pawan.Mahto
 */

@Repository
@Transactional
public interface IngredientRepository extends JpaRepository<Ingredients, Long>{

	public Optional<Ingredients> findByIngredientsName(String ingredientsName);
	
	@Modifying
	@Query( value="DELETE FROM ingredients_tbl b WHERE b.ingredients_name=:ingredientsName", nativeQuery=true)
	public void deleteByIngredientsName(String ingredientsName);

}
