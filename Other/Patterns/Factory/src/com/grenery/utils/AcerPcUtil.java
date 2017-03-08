package com.grenery.utils;

import com.grenery.domain.AcerPc;
import com.grenery.domain.object.AbstractPc;
import com.grenery.utils.abstractUtils.PcCreateUtil;


public class AcerPcUtil extends PcCreateUtil {
	public AbstractPc createPc(){
		return new AcerPc();
	}
}
