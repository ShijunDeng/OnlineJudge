package com.greenery.animals;

public class Appearance {
	protected String name;

	public Appearance(String name) {
		this.name = name;
	}
	public Appearance() {
	
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("name: " + name);
	}
}

