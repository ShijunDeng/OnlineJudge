package com.greenery.cash;

public class ConcreteStrategyA extends CashSuper {
	double cashRate=0.6d;

	public ConcreteStrategyA() {
		System.out.println("调用A类打折方法");
	}

	public ConcreteStrategyA(double cashRate) {
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
