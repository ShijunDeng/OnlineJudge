package com.greenery.object;

public class Alarm {
	private String name;

	public Alarm(String name) {
		this.name = name;
	}

	public void alarming() {
		System.out.println(name);
	}
}
