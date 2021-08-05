package com.assignment.favourite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.favourite.recipes.entity.Ingredients;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients, Long>{

}
