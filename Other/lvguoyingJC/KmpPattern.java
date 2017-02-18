package cn.sjdeng.demo;

/**
 * 
 * @author ShijunDeng
 *
 */
public class KmpPattern {
	private String pattern;
	private int[] nextVal;

	public KmpPattern(String pattern) {
		super();
		this.pattern = pattern;
		this.nextVal = new int[pattern.length()];
		nextVal(pattern);
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
		this.nextVal = new int[pattern.length()];
	}

	public int[] getNextVal() {
		return nextVal;
	}

	public int kmpIndex(String str) {
		int i = 0, j = 0;
		char[] strArray = str.toCharArray();
		char[] tmp = pattern.toCharArray();
		nextVal(pattern);
		while (i < str.length() && j < pattern.length()) {
			if (j == -1 || strArray[i] == tmp[j]) {
				i++;
				j++;
			} else {
				j = nextVal[j];
			}
		}
		return i - pattern.length();
	}

	private int[] nextVal(String pattern) {
		if (pattern == null) {
			return null;
		}
		this.pattern = pattern;
		int i = 0, j = -1;
		nextVal[0] = -1;
		char[] tmp = pattern.toCharArray();
		while (i < pattern.length() - 1) {
			if (j == -1 || tmp[i] == tmp[j]) {
				i++;
				j++;
				if (tmp[i] != tmp[j]) {
					nextVal[i] = j;
				} else {
					nextVal[i] = nextVal[j];
				}
			} else {
				j = nextVal[j];
			}

		}
		return nextVal.clone();
	}
}
