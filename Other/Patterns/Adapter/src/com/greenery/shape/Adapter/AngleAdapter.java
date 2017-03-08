package com.greenery.shape.Adapter;

import com.greenery.paint.PaintMethod;
import com.greenery.shape.Angle;

public class AngleAdapter implements PaintMethod {
	private Angle angle;

	public AngleAdapter(Angle angle) {
		this.angle = angle;
	}

	public void draw() {
		System.out.println("Class name : " + this.getClass().getName()
				+ ", function name: "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		//getStackTrace :0
		//draw:1
		//main:2
		angle.drawAngle();
	}

}
