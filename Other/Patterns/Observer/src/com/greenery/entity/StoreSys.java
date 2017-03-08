package com.greenery.entity;

import java.util.ArrayList;
import java.util.List;

import com.greenery.absObs.Observer;
import com.greenery.interf.Subject;


public class StoreSys implements Subject {
	private String action;
	private List<Observer>observers=new ArrayList<Observer>();
	public boolean attach(Observer observer) {
		return observers.add(observer);
	}

	public boolean detach(Observer observer) {
		return observers.remove(observer);
	}

	public void notifySub() {
		for(Observer observer:observers){
			observer.update();
		}
		
	}

	public String getSubjectState() {
		return action;
	}
	
	public void setSubjectState(String action) {
		this.action=action;
	}
}
