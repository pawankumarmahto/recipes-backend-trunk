package com.assignment.favourite.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UsedIngredients_TBL")
public class UsedIngredients {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	private Integer usedIngredientId;
	
	@Column(length = 25)
	private String usedIngredientsName;	
	
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
