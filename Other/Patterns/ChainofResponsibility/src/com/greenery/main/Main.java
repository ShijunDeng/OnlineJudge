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
		//构造不同的请求
		Request requestA = new Request(RequestType.LEAVE,
				"A请假" + daysNum + "天", daysNum);
		daysNum = 6;
		Request requestB = new Request(RequestType.LEAVE,
				"B请假" + daysNum + "天", daysNum);
		daysNum = 10;
		Request requestC = new Request(RequestType.LEAVE,
				"C请假" + daysNum + "天", daysNum);
		daysNum = 300;
		Request requestD = new Request(RequestType.LEAVE,
				"D请假" + daysNum + "天", daysNum);
		
		//创建不同权限的老师对象
		HeadTeacher headTeacher = new HeadTeacher("黄老师", 1);		
		DepartmentHeader departmentHeader = new DepartmentHeader("张老师", 7);
		President president = new President("老张老师", 30);
		HearMaster hearMaster = new HearMaster("孔老师", 365);

		//设置上下级关系
		headTeacher.setSuperior(departmentHeader);
		departmentHeader.setSuperior(president);
		president.setSuperior(hearMaster);
		
		System.out.println("学生A的请假批准流程:");
		headTeacher.requestAlications(requestA);
		System.out.println();

		System.out.println("学生B的请假批准流程:");
		headTeacher.requestAlications(requestB);
		System.out.println();

		System.out.println("学生C的请假批准流程:");
		headTeacher.requestAlications(requestC);
		System.out.println();

		System.out.println("学生D的请假批准流程:");
		headTeacher.requestAlications(requestD);
		System.out.println();
	}
}
