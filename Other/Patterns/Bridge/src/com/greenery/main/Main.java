package com.greenery.main;

import com.greenery.coffee.Coffee;
import com.greenery.coffee.JorumCoffee;
import com.greenery.coffee.MediumCoffee;
import com.greenery.coffee.SmallCoffee;
import com.greenery.ingredient.Ingredient;
import com.greenery.ingredient.Lemon;
import com.greenery.ingredient.Milk;
import com.greenery.ingredient.Sugar;

public class Main {

	public static void main(String[] args) {
		Ingredient sugar = new Sugar();
		Ingredient lemon = new Lemon();
		Ingredient milk = new Milk();

		Coffee joCof = new JorumCoffee();
		joCof.setIngredient(milk);//大杯设置调味材料
		joCof.addIngredient();//添加材料
		
		Coffee miCof = new MediumCoffee();
		miCof.setIngredient(sugar);
		miCof.addIngredient();
		
		Coffee smCof = new SmallCoffee();
		smCof.setIngredient(lemon);
		smCof.addIngredient();
	}

}
