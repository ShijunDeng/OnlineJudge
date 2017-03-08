package com.grenery.main;

import com.grenery.operation.AbstractOperation;
import com.grenery.utils.KFCFoodCreaterUtil;
import com.grenery.utils.McDonaldsFoodCreaterUtil;
import com.grenery.utils.abstractUtils.FoodCreaterUtil;

public class Main {
	public static void main(String[] args) {
		FoodCreaterUtil kfcFoodCreaterUtil=new KFCFoodCreaterUtil();
		AbstractOperation kfcOperation=kfcFoodCreaterUtil.createFoodOperation();
		System.out.println(kfcOperation.createCola());
		System.out.println(kfcOperation.createHamburg());
		
		FoodCreaterUtil mcDonaldsFoodCreaterUtil=new McDonaldsFoodCreaterUtil();
		AbstractOperation mcDonaldsOperation=mcDonaldsFoodCreaterUtil.createFoodOperation();
		System.out.println(mcDonaldsOperation.createCola());
		System.out.println(mcDonaldsOperation.createHamburg());
	}
}
