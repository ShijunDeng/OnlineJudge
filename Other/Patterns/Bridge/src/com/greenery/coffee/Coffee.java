package com.greenery.coffee;

import com.greenery.ingredient.Ingredient;

public  class Coffee {
	private Ingredient ingredient;

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public void addIngredient() {
		this.ingredient.addIngredient();
	}
}
