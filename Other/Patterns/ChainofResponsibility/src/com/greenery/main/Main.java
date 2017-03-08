package com.greenery.main;

import com.greenery.entity.Request;
import com.greenery.entity.RequestType;
import com.greenery.manager.DepartmentHeader;
import com.greenery.manager.HeadTeacher;
import com.greenery.manager.HearMaster;
import com.greenery.manager.President;

public class Main {
	public static void main(String[] args) {
		int daysNum = 1;
		//���첻ͬ������
		Request requestA = new Request(RequestType.LEAVE,
				"A���" + daysNum + "��", daysNum);
		daysNum = 6;
		Request requestB = new Request(RequestType.LEAVE,
				"B���" + daysNum + "��", daysNum);
		daysNum = 10;
		Request requestC = new Request(RequestType.LEAVE,
				"C���" + daysNum + "��", daysNum);
		daysNum = 300;
		Request requestD = new Request(RequestType.LEAVE,
				"D���" + daysNum + "��", daysNum);
		
		//������ͬȨ�޵���ʦ����
		HeadTeacher headTeacher = new HeadTeacher("����ʦ", 1);		
		DepartmentHeader departmentHeader = new DepartmentHeader("����ʦ", 7);
		President president = new President("������ʦ", 30);
		HearMaster hearMaster = new HearMaster("����ʦ", 365);

		//�������¼���ϵ
		headTeacher.setSuperior(departmentHeader);
		departmentHeader.setSuperior(president);
		president.setSuperior(hearMaster);
		
		System.out.println("ѧ��A�������׼����:");
		headTeacher.requestAlications(requestA);
		System.out.println();

		System.out.println("ѧ��B�������׼����:");
		headTeacher.requestAlications(requestB);
		System.out.println();

		System.out.println("ѧ��C�������׼����:");
		headTeacher.requestAlications(requestC);
		System.out.println();

		System.out.println("ѧ��D�������׼����:");
		headTeacher.requestAlications(requestD);
		System.out.println();
	}
}
