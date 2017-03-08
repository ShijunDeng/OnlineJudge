package com.greenery.main;

import com.greenery.dao.Config;

public class Main {

	public static void main(String[] args) {
		StringBuffer bufStr1=Config.getParameterA();
		StringBuffer bufStr2=Config.getParameterA();
		StringBuffer bufStr3=Config.getParameterA();
		System.out.println("bufStr1:"+bufStr1);
		System.out.println("bufStr2:"+bufStr2);
		System.out.println("bufStr3:"+bufStr3);

	}

}
