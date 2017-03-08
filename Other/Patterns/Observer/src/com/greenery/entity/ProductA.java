package com.greenery.entity;

import com.greenery.absObs.Observer;
import com.greenery.interf.Subject;

public class ProductA extends Observer {

	public ProductA(String name, Subject sub) {
		super(name, sub);
	}

	public void update() {
		System.out.println(this.sub.getSubjectState()+this.name+"--价格数量变更!");
	}

}
