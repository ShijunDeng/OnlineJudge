package com.greenery.entity;

public class Memento {
	State state;

	public Memento(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	

}
