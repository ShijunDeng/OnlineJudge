package com.greenery.dao;

public class Config {
	private static StringBuffer parameterA;

	private Config() {

	}

	public static StringBuffer getParameterA() {
		if (null == parameterA) {
			parameterA = new StringBuffer("My name is " + Config.class.getName()
					+ " , and hashCode=" + Config.class.hashCode());
		}
		return parameterA;
	}

	public static void setParameterA(StringBuffer parameterA) {
		Config.parameterA = parameterA;
	}

}
