package com.assignment.favourite.recipes.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class RecipesDTO implements Serializable {

	private static final long serialVersionUID = 1001L;
	private Long recipesId;
	private String recipesName;
	private String recipesType;
	private Integer noOfPerson;
	private String cookingInstruction;
	private Timestamp preparedAt;
	private Timestamp updatedAt;
	private Set<UsedIngredientsDTO> usedingredients = new HashSet<>();

	public RecipesDTO() {
	}

	public String getCookingInstruction() {
		return cookingInstruction;
	}

	public void setCookingInstruction(String cookingInstruction) {
		this.cookingInstruction = cookingInstruction;
	}

	public Integer getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(Integer noOfPerson) {
		this.noOfPerson = noOfPerson;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getRecipesId() {
		return recipesId;
	}

	public void setRecipesId(Long recipesId) {
		this.recipesId = recipesId;
	}

	public String getRecipesName() {
		return recipesName;
	}

	public void setRecipesName(String recipesName) {
		this.recipesName = recipesName;
	}

	public String getRecipesType() {
		return recipesType;
	}

	public void setRecipesType(String recipesType) {
		this.recipesType = recipesType;
	}

	public Set<UsedIngredientsDTO> getUsedingredients() {
		return usedingredients;
	}

	public void setUsedingredients(Set<UsedIngredientsDTO> usedingredients) {
		this.usedingredients = usedingredients;
	}

	public Timestamp getPreparedAt() {
		return preparedAt;
	}

	public void setPreparedAt(Timestamp preparedAt) {
		this.preparedAt = preparedAt;
	}
}
