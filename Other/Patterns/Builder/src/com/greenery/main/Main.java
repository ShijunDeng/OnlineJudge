package com.greenery.main;

import com.greenery.builder.BMWCarBuilder;
import com.greenery.builder.BenZBuilder;
import com.greenery.builder.abst.AbstractCarbuilder;
import com.greenery.commons.Car;
import com.greenery.director.CarDirector;

public class Main {

	public static void main(String[] args) {
		Car car=new Car();
		AbstractCarbuilder benZBuilder=new BenZBuilder(car);
		CarDirector carDirector=new CarDirector(benZBuilder);
		carDirector.createCar();
		car.print();

		
		AbstractCarbuilder bmwZBuilder=new BMWCarBuilder(car);
		carDirector=new CarDirector(bmwZBuilder);
		carDirector.createCar();
		car.print();	
	}

}
