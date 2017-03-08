package com.greenery.shape;

public class Angle {

	public void drawAngle() {
		System.out.println("Class name : " + this.getClass().getName()
				+ ", function name: "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		//getStackTrace :0
		//drawAngle:1
		//draw:2
		//main:3
	}
}
