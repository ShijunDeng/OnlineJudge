package com.grenery.utils;

import com.grenery.domain.DellPc;
import com.grenery.domain.object.AbstractPc;
import com.grenery.utils.abstractUtils.PcCreateUtil;

public class DellPcCreateUil extends PcCreateUtil {
	public AbstractPc createPc(){
		return new DellPc();
	}
	
}

