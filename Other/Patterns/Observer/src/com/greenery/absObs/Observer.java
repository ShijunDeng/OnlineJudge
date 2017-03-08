package com.greenery.absObs;

import com.greenery.interf.Subject;

public abstract class Observer {
	protected String name;
	protected Subject sub;
	public Observer(String name, Subject sub) {
		this.name = name;
		this.sub = sub;
	}
	
	public abstract void update();

}
