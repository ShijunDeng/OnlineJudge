package cn.sjdeng.ali;

import java.util.Random;
/*
 * 
题目描述见：Ali2017Judge2.png
 */
public class Ali2017Judge2 {
	static double getP(int u1, int u2, int o1, int o2) {
		Random r1 = new Random();
		o1 *= o1;
		o2 *= o2;
		double x;
		double y;
		double pa = 0, pb = 0;
		int count = 0;
		int total = 0;
		while (pa == 0 || pa - pb > 0.09) {
			x = r1.nextGaussian() * o1 + u1;
			y = r1.nextGaussian() * o2 + u2;
			if (x * x + y * y + x * y < 1 && x * x + y * y - x * y < 1) {
				count++;
			}
			total++;
			pa = pb;
			pb = count * 1.0 / total;
		}
		return pa;
	}

	public static void main(String[] args) {
		System.out.println(getP(0, 0, 1, 1));
	}
}
