package com.greenery.main;

import com.greenery.cash.CashType;
import com.greenery.factory.CashContext;

public class Main {
	public static void main(String[] args) {
		double EnglishBook=100d;
		double computerBook=150d;	
		double otherBook=50d;
		
		CashContext ctEng=new CashContext(CashType.EINGLISH);		
		System.out.println("Ӣ��������㣺ԭ��"+EnglishBook+"���ۺ�"+ctEng.getPrice(EnglishBook));

		CashContext ctCom=new CashContext(CashType.COMPUTER);		
		System.out.println("�����������㣺ԭ��"+computerBook+"���ۺ�"+ctCom.getPrice(computerBook));

		CashContext ctDef=new CashContext(CashType.DEFAULT);
		System.out.println("����������㣺ԭ��"+otherBook+"���ۺ�"+ctDef.getPrice(otherBook));

		}

}
