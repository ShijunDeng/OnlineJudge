package com.greenery.createUtils;

import com.greenery.absproduct.Cola;
import com.greenery.absproduct.Hamburg;

public abstract interface FoodCreater {
	public Cola createCola();
	public Hamburg createHamburg();
}
