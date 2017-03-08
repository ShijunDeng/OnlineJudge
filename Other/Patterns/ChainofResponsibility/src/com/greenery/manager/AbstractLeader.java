package com.greenery.manager;

import com.greenery.entity.Request;

public abstract class AbstractLeader {
	protected String name;
	private int permissonNum;//������׼�����������
	protected AbstractLeader superior;

	public AbstractLeader(String name, int permissonNum) {
		this.name = name;
		this.permissonNum = permissonNum;
	}


	public int getPermissonNum() {
		return permissonNum;
	}


	public void setPermissonNum(int permissonNum) {
		this.permissonNum = permissonNum;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setSuperior(AbstractLeader superior) {
		this.superior = superior;
	}
/**
 * ��Ӧ����
 */
	public abstract void requestAlications(Request request);
}
