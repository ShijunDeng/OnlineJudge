package com.grenery.main;

import com.grenery.utils.AcerPcUtil;
import com.grenery.utils.DellPcCreateUil;
import com.grenery.utils.HpPcCreateUtil;
import com.grenery.utils.abstractUtils.PcCreateUtil;

public class Main {

	public static void main(String[] args) {
		PcCreateUtil pcCreaterHp = new HpPcCreateUtil();
		PcCreateUtil pcCreaterDell = new DellPcCreateUil();
		PcCreateUtil pcCreaterLenovo = new HpPcCreateUtil();
		PcCreateUtil pcCreaterAcer = new AcerPcUtil();
		pcCreaterHp.createPc().print();
		pcCreaterDell.createPc().print();
		pcCreaterLenovo.createPc().print();
		pcCreaterAcer.createPc().print();

	}

}



