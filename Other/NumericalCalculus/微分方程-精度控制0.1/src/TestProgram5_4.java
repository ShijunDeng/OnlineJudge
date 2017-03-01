public class TestProgram5_4 {

	static double fX(double x, double y) {
		// return y - 2 * x / y;
		return -x *Math.pow(y, 2);

	}
	static double fx(double x) {
		return 2/(Math.pow(x, 2)+1);

	}

	public static void main(String[] args) {

		try {
			Program5_4 pro5_4 = new Program5_4(
					TestProgram5_4.class.getDeclaredMethod("fX", double.class,
							double.class), 0, 2, 10E-5);
			int x=2;
			System.out.printf("通过控制精度，来求得指定x值的微分方程数值解(以x=%d为例)：\n",x);
			System.out.printf("预报-校正：f(%d)=%f \n",x,
					pro5_4.getValueOfdifferentiationA(x));
			System.out.printf("嵌入公式：f(%d)=%f \n",x,
					pro5_4.getValueOfdifferentiationB(x));
			System.out.printf("平均化形式：f(%d)=%f \n",x,
					pro5_4.getValueOfdifferentiationC(x));
			System.out.printf("对于y'=-xy^2, y(0)=2,通过解微分方程得:y=2/(x^2+1),精确的:y(%d)=%f\n",x,fx(x));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
