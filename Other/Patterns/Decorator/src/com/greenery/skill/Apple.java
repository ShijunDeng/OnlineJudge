package com.greenery.skill;

import com.greenery.animals.PleasantGoat;

public class Apple extends PleasantGoat{

	public Apple(String name) {
		super(name);
	}
	public Apple(){
	}
	protected PleasantGoat pleasantGoat;
	
	
	public void addSkill(PleasantGoat pleasantGoat){
		this.pleasantGoat=pleasantGoat;
	}
	
	public void show(){
		if(pleasantGoat!=null){
			pleasantGoat.show();
		}
	}
}
