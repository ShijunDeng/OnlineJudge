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
		joCof.setIngredient(milk);//�����õ�ζ����
		joCof.addIngredient();//��Ӳ���
		
		Coffee miCof = new MediumCoffee();
		miCof.setIngredient(sugar);
		miCof.addIngredient();
		
		Coffee smCof = new SmallCoffee();
		smCof.setIngredient(lemon);
		smCof.addIngredient();
	}

}
