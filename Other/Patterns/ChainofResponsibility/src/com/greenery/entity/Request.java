package com.greenery.entity;

public class Request {
	private RequestType requestType;
	private String content;
	private int daydsNum;

	public Request() {
		
	}

	public Request(RequestType requestType, String content, int daydsNum) {
		super();
		this.requestType = requestType;
		this.content = content;
		this.daydsNum = daydsNum;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType,int daydsNum) {
		this.requestType = requestType;
		this.daydsNum=daydsNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDaydsNum() {
		return daydsNum;
	}

	public void setDaydsNum(int daydsNum) {
		this.daydsNum = daydsNum;
	}
	
	

}
