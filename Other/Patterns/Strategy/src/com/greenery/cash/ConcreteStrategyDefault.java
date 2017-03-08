package com.greenery.cash;

public class ConcreteStrategyDefault extends CashSuper {
	double cashRate=0.95d;

	public ConcreteStrategyDefault() {
		System.out.println("调用默认类打折方法");
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
