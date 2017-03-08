package com.grenery.domain.object;

public abstract class AbstractPc {
	protected String name;//µçÄÔÃû³Æ

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void print(){
		System.out.println("Name: "+this.name);
	}
}
