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
			System.out.println("请求" + request.getContent() + "被"
					+ this.getClass().getName() + ":" + name + "批准!");
		} else if (this.superior != null) {
			System.out.println(this.getClass().getName() + ":" + name
					+ "无权限,请求传达至上级!");
			superior.requestAlications(request);
		}
	}

}
