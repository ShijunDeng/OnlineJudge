package com.greenery.object;

public class Sensor {
	private String name;

	public Sensor(String name) {
		this.name = name;
	}

	public void sensoring() {
		System.out.println(name);
	}
}
