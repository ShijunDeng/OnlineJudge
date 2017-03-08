package com.greenery.builder.abst;

import com.greenery.commons.Car;

public abstract class AbstractCarbuilder {
	protected Car car;	
	public AbstractCarbuilder(Car car) {
		this.car = car;
	}

	public abstract void buildBody();

	public abstract void buildWheel();

	public abstract void BuildOilBox();
}
