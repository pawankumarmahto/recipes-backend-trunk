package com.assignment.favourite.recipes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.entity.Users;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients, Long>{

	public Optional<Users> findByIngredientsName(String ingredientsName);
}
