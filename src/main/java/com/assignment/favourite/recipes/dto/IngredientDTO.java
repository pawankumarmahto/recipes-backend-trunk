package com.assignment.favourite.recipes.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class IngredientDTO implements Serializable {

	private static final long serialVersionUID = 1001L;
	private Long ingredientId;
	private String ingredientsName;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public IngredientDTO() {
	}
	
	public IngredientDTO(Long ingredientId, String ingredientsName, Timestamp createdAt, Timestamp updatedAt) {
		this.ingredientId = ingredientId;
		this.ingredientsName = ingredientsName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredientsName() {
		return ingredientsName;
	}

	public void setIngredientsName(String ingredientsName) {
		this.ingredientsName = ingredientsName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
