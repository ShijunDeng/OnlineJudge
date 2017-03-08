package com.greenery.manager;

import com.greenery.entity.Request;
import com.greenery.entity.RequestType;

public class DepartmentHeader extends AbstractLeader {

	public DepartmentHeader(String name, int permissonNum) {
		super(name, permissonNum);
	}

	public void requestAlications(Request request) {
		if (request.getRequestType() == RequestType.LEAVE
				&& request.getDaydsNum() <= this.getPermissonNum()) {
			System.out.println("����" + request.getContent() + "��"
					+ this.getClass().getName() + ":" + name + "��׼!");
		} else if (this.superior != null) {
			System.out.println(this.getClass().getName() + ":" + name
					+ "��Ȩ��,���󴫴����ϼ�!");
			superior.requestAlications(request);
		}
	}

}
