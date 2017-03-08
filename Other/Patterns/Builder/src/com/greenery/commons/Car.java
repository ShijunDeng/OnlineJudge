package com.greenery.commons;

/**
 * Æû³µÊµÌå
 * 
 * @author shijun
 * 
 */
public class Car {
	private String wheel;
	private String oilBox;
	private String body;

	public String getWheel() {
		return wheel;
	}

	public void setWheel(String wheel) {
		this.wheel = wheel;
	}

	public String getOilBox() {
		return oilBox;
	}

	public void setOilBox(String oilBox) {
		this.oilBox = oilBox;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void print() {
		System.out.println("My class name :" + this.getClass().getName());
		System.out.println("body: " + this.body);
		System.out.println("oilBox: " + this.oilBox);
		System.out.println("wheel: " + this.wheel);
	}
}
