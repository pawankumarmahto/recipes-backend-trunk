package com.assignment.favourite.recipes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Modifying
	@Query( value="DELETE FROM recipes_tbl b WHERE b.recipes_name=:recipesName", nativeQuery=true)
	public  void deleteByRecipesName(String recipesName);
}
