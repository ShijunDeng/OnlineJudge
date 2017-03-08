package com.greenery.createUtils;

import com.greenery.absproduct.Cola;
import com.greenery.absproduct.Hamburg;
import com.greenery.product.KFCCola;
import com.greenery.product.KFCHamburg;

public class KFCCreateUtil implements FoodCreater{
	public Cola createCola(){
		return new KFCCola();
	}
	public Hamburg createHamburg(){
		return new KFCHamburg();
	}
}
