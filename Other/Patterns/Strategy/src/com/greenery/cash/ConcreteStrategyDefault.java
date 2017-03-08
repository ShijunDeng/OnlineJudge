package com.greenery.cash;

public class ConcreteStrategyDefault extends CashSuper {
	double cashRate=0.95d;

	public ConcreteStrategyDefault() {
		System.out.println("����Ĭ������۷���");
	}

	public ConcreteStrategyDefault(double cashRate) {
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
