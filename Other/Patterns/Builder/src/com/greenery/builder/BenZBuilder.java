package com.greenery.builder;

import com.greenery.builder.abst.AbstractCarbuilder;
import com.greenery.commons.Car;

public class BenZBuilder extends AbstractCarbuilder {

	public BenZBuilder(Car car) {
		super(car);
	}

	public void buildBody() {
		if(car!=null)
			car.setBody("BenZBody");
		
	}

	public void buildWheel() {
		if(car!=null)
			car.setWheel("BenZWheel");
	}

	public void BuildOilBox() {
		if(car!=null)
			car.setOilBox("BenZBody");
	}

}
