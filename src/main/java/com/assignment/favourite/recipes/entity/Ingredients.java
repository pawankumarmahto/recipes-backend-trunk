package com.assignment.favourite.recipes.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.assignment.favourite.recipes.converter.DateTimeConverter;


@Entity
@Table(name="INGREDIENTS_TBL")
public class Ingredients {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ingredientId", updatable = false, nullable = false)
	private Long ingredientId;
	
	@Column(length = 100, unique = true, nullable = false)
	private String ingredientsName;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	/*
	 * @ManyToMany(mappedBy="ingredients") private Set<Recipes> recipes;
	 */
	
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
