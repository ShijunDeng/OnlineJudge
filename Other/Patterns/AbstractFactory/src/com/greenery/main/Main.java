package com.greenery.main;

import com.greenery.createUtils.FoodCreater;
import com.greenery.createUtils.KFCCreateUtil;
import com.greenery.createUtils.McDonaldsCreateUtil;
import com.greenery.product.KFCCola;
import com.greenery.product.KFCHamburg;
import com.greenery.product.McDonaldsCola;
import com.greenery.product.McDonaldsHamburg;

public class Main {

	public static void main(String[] args) {
		FoodCreater kfc=new KFCCreateUtil();
		FoodCreater mcDonalds=new McDonaldsCreateUtil();
		((KFCCola)kfc.createCola()).print();
		((KFCHamburg)kfc.createHamburg()).print();
		((McDonaldsCola)mcDonalds.createCola()).print();
		((McDonaldsHamburg)mcDonalds.createHamburg()).print();
	}

}
