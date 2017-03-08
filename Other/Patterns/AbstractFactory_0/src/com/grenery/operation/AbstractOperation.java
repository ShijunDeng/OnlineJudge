package com.grenery.operation;

public abstract class AbstractOperation {
	private String companyName;
	
	public AbstractOperation(String companyName) {
		this.companyName = companyName;
	}
	public String createHamburg(){
		return "Hamburg created by "+companyName;
	}
	public String createCola(){
		return "createCola created by "+companyName;
	}
}
