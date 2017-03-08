package com.greenery.animals;

public class Animal {
	protected String name;// œ≤—Û—Û

	public Animal(String name) {
		super();
		this.name = name;
	}
	public Animal() {
	
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
