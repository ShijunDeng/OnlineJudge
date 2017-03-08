package com.greenery.main;

import com.greenery.entity.ProductA;
import com.greenery.entity.StoreSys;

public class Main {
	public static void main(String[] args) {
		StoreSys sys=new StoreSys();
		ProductA pd1=new ProductA("菠萝", sys);
		ProductA pd2=new ProductA("梨子", sys);
		sys.attach(pd1);
		sys.attach(pd2);
		sys.detach(pd1);
		
		
		sys.setSubjectState("系统调整产品信息");
		sys.notifySub();
		
	}

}
