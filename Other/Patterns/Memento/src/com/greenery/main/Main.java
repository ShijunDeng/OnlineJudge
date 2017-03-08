package com.greenery.main;

import com.greenery.entity.State;
import com.greenery.entity.User;
import com.greenery.entity.WindowsSystem;

public class Main {

	public static void main(String []args){
		WindowsSystem windowsSystem=new WindowsSystem();
		windowsSystem.setState(State.NORMAL);
		System.out.println("正常状态:");
		windowsSystem.show();
		
		User user=new  User();
		user.setMemento(windowsSystem.createMemento());
		
		System.out.println("异常状态:");
		windowsSystem.setState(State.ABNORMAL);
		windowsSystem.show();
		
		System.out.println("回滚到正常状态:");
		windowsSystem.setState(user.getMemento());
		windowsSystem.show();
	}
}
