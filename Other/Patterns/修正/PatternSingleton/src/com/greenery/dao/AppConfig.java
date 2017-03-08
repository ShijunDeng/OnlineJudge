package com.greenery.dao;

public class AppConfig {
	// 定义一个变量来存储创建好的类实例
	private static AppConfig parameterA;

	// 私有化构造方法，便于在内部控制创建实例的数目
	private AppConfig() {
	}

	// 定义一个方法来为客户端提供类实例
	public static AppConfig getParameterA() {
		if (null == parameterA) {
			parameterA = new AppConfig();
		}
		return parameterA;
	}

}

