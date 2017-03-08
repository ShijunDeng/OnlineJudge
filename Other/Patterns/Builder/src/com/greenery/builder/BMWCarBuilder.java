package com.greenery.builder;

import com.greenery.builder.abst.AbstractCarbuilder;
import com.greenery.commons.Car;

public class BMWCarBuilder extends AbstractCarbuilder {

	public BMWCarBuilder(Car car) {
		super(car);
	}

	public void buildBody() {
		if(car!=null)
			car.setBody("BMWBody");
		
	}

	public void buildWheel() {
		if(car!=null)
			car.setWheel("BMWWheel");
	}

	public void BuildOilBox() {
		if(car!=null)
			car.setOilBox("BMWBody");
	}

}
