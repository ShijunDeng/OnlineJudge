package com.greenery.skill;

import com.greenery.animals.Appearance;

public class RedApple extends Finery {
	protected Appearance appearance;

	public RedApple(String name) {
		super(name);
	}

	public RedApple() {
	}

	public void addSkill(Appearance appearance) {
		this.appearance = appearance;
	}

	public void show() {
		System.out.println("add a red apple");
		appearance.show();
	}

}

