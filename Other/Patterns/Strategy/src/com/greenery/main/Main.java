package com.greenery.main;

import com.greenery.cash.CashType;
import com.greenery.factory.CashContext;

public class Main {
	public static void main(String[] args) {
		double EnglishBook=100d;
		double computerBook=150d;	
		double otherBook=50d;
		
		CashContext ctEng=new CashContext(CashType.EINGLISH);		
		System.out.println("英语类书结算：原价"+EnglishBook+"打折后"+ctEng.getPrice(EnglishBook));

		CashContext ctCom=new CashContext(CashType.COMPUTER);		
		System.out.println("计算机类书结算：原价"+computerBook+"打折后"+ctCom.getPrice(computerBook));

		CashContext ctDef=new CashContext(CashType.DEFAULT);
		System.out.println("其它类书结算：原价"+otherBook+"打折后"+ctDef.getPrice(otherBook));

		}

}
