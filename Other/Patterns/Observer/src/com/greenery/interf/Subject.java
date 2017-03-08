package com.greenery.interf;

import com.greenery.absObs.Observer;

/**
 * 
 * @author ֪ͨ�߽ӿ�
 * 
 */
public interface Subject {
	boolean attach(Observer observer);

	boolean detach(Observer observer);

	void notifySub();

	String getSubjectState();
	
	void setSubjectState(String action);

}
