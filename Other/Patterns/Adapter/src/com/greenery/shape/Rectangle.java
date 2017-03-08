package com.greenery.shape;

import com.greenery.paint.PaintMethod;

public class Rectangle implements PaintMethod {

	public void draw() {
		System.out.println("Class name : " + this.getClass().getName()
				+ ", function name: "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
