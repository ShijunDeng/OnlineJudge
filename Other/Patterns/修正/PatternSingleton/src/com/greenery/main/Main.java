package com.greenery.main;

import com.greenery.dao.AppConfig;

public class Main {

	public static void main(String[] args) {
		
		AppConfig singleton1 = AppConfig.getParameterA();
		AppConfig singleton2 = AppConfig.getParameterA();
		AppConfig singleton3 = AppConfig.getParameterA();
		
		System.out.println("singleton1: My name is "
				+ singleton1.getClass().getName() + " , and hashCode is "
				+ singleton1.hashCode());
		
		System.out.println("singleton2: My name is "
				+ singleton2.getClass().getName() + " , and hashCode is "
				+ singleton2.hashCode());
		
		System.out.println("singleton3: My name is "
				+ singleton3.getClass().getName() + " , and hashCode is "
				+ singleton3.hashCode());

	}

}

