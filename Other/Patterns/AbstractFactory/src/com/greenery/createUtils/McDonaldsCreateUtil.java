package com.greenery.createUtils;

import com.greenery.absproduct.Cola;
import com.greenery.absproduct.Hamburg;

import com.greenery.product.McDonaldsCola;
import com.greenery.product.McDonaldsHamburg;

public class McDonaldsCreateUtil implements FoodCreater {

	public Cola createCola(){
		return new McDonaldsCola();
	}
	public Hamburg createHamburg(){
		return new McDonaldsHamburg();
	}

}
