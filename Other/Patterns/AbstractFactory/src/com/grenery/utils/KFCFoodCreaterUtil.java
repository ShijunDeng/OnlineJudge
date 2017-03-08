package com.grenery.utils;

import com.grenery.operation.AbstractOperation;
import com.grenery.operation.KFCOperation;
import com.grenery.utils.abstractUtils.FoodCreaterUtil;
public class KFCFoodCreaterUtil implements FoodCreaterUtil{

	public  AbstractOperation createFoodOperation() {
		return new KFCOperation();
	}

}
