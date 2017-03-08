package com.grenery.utils;

import com.grenery.domain.HpPc;
import com.grenery.domain.object.AbstractPc;
import com.grenery.utils.abstractUtils.PcCreateUtil;

public class HpPcCreateUtil extends PcCreateUtil {
	public AbstractPc createPc() {
		return new HpPc();
	}
}

