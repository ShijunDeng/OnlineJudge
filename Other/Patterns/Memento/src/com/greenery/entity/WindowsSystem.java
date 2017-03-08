package com.greenery.entity;

public class WindowsSystem {
	public State state;
	
	public Memento createMemento(){
		return new Memento(state);
	}
	
	public void setState(Memento memento){
		this.state=memento.getState();
	}

	public void setState(State state){
		this.state=state;
	}
	public void show(){
		System.out.println(state.toString());
	}
}
