package com.greenery.skill;

import com.greenery.animals.Appearance;

public class GreenApple extends Finery {
	protected Appearance appearance;

	public GreenApple(String name) {
		super(name);
	}

	public GreenApple() {
	}

	public void addSkill(Appearance appearance) {
		this.appearance = appearance;
	}

	public void show() {
		System.out.println("add a green apple");
		appearance.show();
	}

}

