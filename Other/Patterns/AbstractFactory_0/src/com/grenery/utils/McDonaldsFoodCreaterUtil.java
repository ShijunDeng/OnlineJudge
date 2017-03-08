package com.grenery.utils;

import com.grenery.operation.AbstractOperation;
import com.grenery.operation.McDonaldsOperation;
import com.grenery.utils.abstractUtils.FoodCreaterUtil;

public class McDonaldsFoodCreaterUtil implements FoodCreaterUtil {
	public AbstractOperation createFoodOperation() {
		return new McDonaldsOperation();
	}

}
