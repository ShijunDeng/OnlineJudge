package com.greenery.factory;

import com.greenery.cash.CashSuper;
import com.greenery.cash.CashType;
import com.greenery.cash.ConcreteStrategyA;
import com.greenery.cash.ConcreteStrategyB;
import com.greenery.cash.ConcreteStrategyDefault;

public class CashContext {
	private CashSuper cs;

	public CashContext(CashType cashType) {
		switch (cashType) {
		case EINGLISH:
			cs = new ConcreteStrategyA();
			break;
		case COMPUTER:
			cs = new ConcreteStrategyB();
			break;

		case DEFAULT:
			cs = new ConcreteStrategyDefault();
			break;
		default:
			cs = new ConcreteStrategyDefault();
			break;
		}
	}

	public double getPrice(double money) {
		return cs.algorithm(money);
	}

}
