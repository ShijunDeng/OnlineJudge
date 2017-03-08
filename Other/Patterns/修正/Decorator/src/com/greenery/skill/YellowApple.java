package com.greenery.skill;

import com.greenery.animals.Appearance;

public class YellowApple extends Finery {
	protected Appearance appearance;

	public YellowApple(String name) {
		super(name);
	}

	public YellowApple() {
	}

	public void addSkill(Appearance appearance) {
		this.appearance = appearance;
	}

	public void show() {
		System.out.println("add a yellow apple");
		appearance.show();
	}

}


