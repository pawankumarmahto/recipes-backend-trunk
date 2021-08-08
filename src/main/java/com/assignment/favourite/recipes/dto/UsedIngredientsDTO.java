package com.assignment.favourite.recipes.dto;

import java.io.Serializable;

public class UsedIngredientsDTO implements Serializable {

	private static final long serialVersionUID = 1001L;
	private Integer id;
	private Integer usedIngredientId;
	private String usedIngredientsName;	
	
	public UsedIngredientsDTO() {
	}
	
	public UsedIngredientsDTO(Integer id, Integer usedIngredientId, String usedIngredientsName) {
		this.id = id;
		this.usedIngredientId = usedIngredientId;
		this.usedIngredientsName = usedIngredientsName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsedIngredientId() {
		return usedIngredientId;
	}

	public String getUsedIngredientsName() {
		return usedIngredientsName;
	}

	public void setUsedIngredientId(Integer usedIngredientId) {
		this.usedIngredientId = usedIngredientId;
	}

	public void setUsedIngredientsName(String usedIngredientsName) {
		this.usedIngredientsName = usedIngredientsName;
	}

}
