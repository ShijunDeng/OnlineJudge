package cn.sjdeng.ali;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Ali2017Judge3 {
	public static int getMaxDupDegree(String str) {
		if (null == str || "".equals(str) || str.length() < 3) {
			return 0;
		}
		Map<String, Integer> map = new TreeMap<String, Integer>();
		int count = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 2; j <= str.length(); j++) {
				if (!map.containsKey(str.substring(i, j))) {
					count = 0;
					for (int k = 0; k <= str.length() - j + i; k++) {
						if (str.substring(i, j).equals(str.substring(k, k + j - i))) {
							count++;
						}
					}
					map.put(str.substring(i, j), count);
				}
			}
		}
		int max = 0;
		int tmp = 0;
		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> e = iter.next();
			if (e.getValue() > 1) {
				System.out.println(e.getKey() + " " + e.getValue());
				tmp = e.getKey().length() * e.getValue();
				if (tmp > max) {
					max = tmp;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(getMaxDupDegree("abcabcabab"));
		System.out.println(getMaxDupDegree("aaa"));

	}
}
