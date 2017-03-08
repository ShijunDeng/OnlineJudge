package com.greenery.director;

import com.greenery.builder.abst.AbstractCarbuilder;

public class CarDirector {
	private AbstractCarbuilder absCarBuilder;

	public CarDirector(AbstractCarbuilder absCarBuilder) {
		super();
		this.absCarBuilder = absCarBuilder;
	}
	
	public void createCar(){
		if(null!=absCarBuilder){
			absCarBuilder.buildBody();
			absCarBuilder.BuildOilBox();
			absCarBuilder.buildWheel();
		}
	}

}
