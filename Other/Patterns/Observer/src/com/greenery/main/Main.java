package com.greenery.main;

import com.greenery.entity.ProductA;
import com.greenery.entity.StoreSys;

public class Main {
	public static void main(String[] args) {
		StoreSys sys=new StoreSys();
		ProductA pd1=new ProductA("����", sys);
		ProductA pd2=new ProductA("����", sys);
		sys.attach(pd1);
		sys.attach(pd2);
		sys.detach(pd1);
		
		
		sys.setSubjectState("ϵͳ������Ʒ��Ϣ");
		sys.notifySub();
		
	}

}
