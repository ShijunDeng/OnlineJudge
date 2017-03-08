package com.grenery.main;

import com.grenery.domain.config.PcName;
import com.grenery.domain.object.AbstractPc;
import com.grenery.utils.PcCreaterUtil;

public class Main {

	public static void main(String[] args) {
		for(PcName pcName:PcName.values()){
			AbstractPc pc=PcCreaterUtil.createPc(pcName);
			pc.print();
		}

	}

}
