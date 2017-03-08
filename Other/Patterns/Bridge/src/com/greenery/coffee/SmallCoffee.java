package com.greenery.coffee;

import com.greenery.ingredient.Ingredient;

public class SmallCoffee extends Coffee {
	public void setIngredient(Ingredient ingredient) {
		super.setIngredient(ingredient);
	}

	public void addIngredient() {
		System.out.println("My class name is " + this.getClass().getName());
		super.addIngredient();
	}
}
