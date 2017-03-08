package com.grenery.utils;

import com.grenery.domain.AcerPc;
import com.grenery.domain.DellPc;
import com.grenery.domain.HpPc;
import com.grenery.domain.LenovoPc;
import com.grenery.domain.config.PcName;
import com.grenery.domain.object.AbstractPc;

public class PcCreaterUtil {

	public static AbstractPc createPc(PcName pcName) {
		switch (pcName) {
		case Hp:
			return new HpPc();
		case Acer:
			return new AcerPc();
		case Lenovo:
			return new LenovoPc();
		case Dell:
			return new DellPc();
		default:
			return new HpPc();//默认生产Hp电脑
		}
	}
}
