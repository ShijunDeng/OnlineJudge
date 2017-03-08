package com.greenery.cash;

public class ConcreteStrategyB extends CashSuper {

	double cashRate=0.7d;

	public ConcreteStrategyB() {
		System.out.println("����B����۷���");
	}

	public ConcreteStrategyB(double cashRate) {
		this();
		this.cashRate = cashRate;
	}

	public double algorithm(double money) {
		return cashRate * money;
	}

	public double getCashRate() {
		return cashRate;
	}

	public void setCashRate(double cashRate) {
		this.cashRate = cashRate;
	}

}
