package com.whitedew.algorithm.easy;

import org.junit.Test;

public class Solution15 {
	private boolean notContainZero(String s) {
		for (char c : s.toCharArray()) {
			if (!(c == ' ' || c == '.' || c == '0'))
				return false;
		}
		return true;
	}

	public int compareVersion(String version1, String version2) {
		while (version1.contains(".") && version2.contains(".")) {
			int vInt1 = Integer.parseInt(version1.substring(0,
					version1.indexOf('.')));
			version1 = version1.substring(version1.indexOf('.') + 1);
			int vInt2 = Integer.parseInt(version2.substring(0,
					version2.indexOf('.')));
			version2 = version2.substring(version2.indexOf('.') + 1);
			if (vInt1 > vInt2)
				return 1;
			if (vInt1 < vInt2)
				return -1;
		}

		if (version1.contains(".") == false && version2.contains(".") == false) {
			int vInt1 = Integer.parseInt(version1);
			int vInt2 = Integer.parseInt(version2);
			if (vInt1 > vInt2)
				return 1;
			if (vInt1 < vInt2)
				return -1;
		}
		if (version1.contains(".") && version2.contains(".") == false) {
			int vInt1 = Integer.parseInt(version1.substring(0,
					version1.indexOf('.')));
			version1 = version1.substring(version1.indexOf('.') + 1);
			int vInt2 = Integer.parseInt(version2);
			if (vInt1 < vInt2)
				return -1;
			else if (vInt1 > vInt2)
				return 1;
			else {
				if (notContainZero(version1))
					return 0;
				return 1;

			}
		}
		if (version1.contains(".") == false && version2.contains(".")) {
			int vInt1 = Integer.parseInt(version1);
			int vInt2 = Integer.parseInt(version2.substring(0,
					version2.indexOf('.')));
			version2 = version2.substring(version2.indexOf('.') + 1);
			if (vInt1 > vInt2)
				return 1;
			else if (vInt1 < vInt2)
				return -1;
			else {
				if (notContainZero(version2))
					return 0;
				return -1;

			}
		}
		return 0;

	}

	@Test
	public void test() {
		//System.out.println(new Solution().compareVersion("1.0", "1"));
	}
}