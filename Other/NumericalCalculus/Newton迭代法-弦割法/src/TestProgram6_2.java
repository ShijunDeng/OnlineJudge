public class TestProgram6_2 {

	static double fX(double x) {
		return Math.pow(Math.E, 5 * x) - Math.sin(x) + Math.pow(x, 3) - 20;
	}

	public static void main(String[] args) {
		double a = 0;
		double b = 1;
		double precious = 10E-8;
		try {
			Program6_2 p6_2 = new Program6_2(
					TestProgram6_2.class.getDeclaredMethod("fX", double.class),
					a,b, precious);
			System.out.println("方程为：e^(5x)-sinx+x^3-20=0 ,精度 "+precious);
			System.out.println("取区间["+a+","+b+"]"  + ",解得x=" + p6_2.function());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
