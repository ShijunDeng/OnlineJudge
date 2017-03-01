public class TestProgram6_2 {

	static double fX(double x) {
		return Math.pow(Math.E, 5 * x) - Math.sin(x) + Math.pow(x, 3) - 20;
	}

	public static void main(String[] args) {
		double x0=1;
		int k=40;
		double precious=10E-8;
		try {
			Program6_2 p6_2=new Program6_2(TestProgram6_2.class.getDeclaredMethod("fX", double.class),x0,k,precious);
			System.out.printf("方程为：e^(5x)-sinx+x^3-20=0 ,精度 ");
			System.out.println(precious);
			p6_2.function();
			System.out.printf("取 x0=%f ,解得x%d= ",x0,p6_2.getK());
			System.out.println(p6_2.getX0());
			--x0;
			p6_2=new Program6_2(TestProgram6_2.class.getDeclaredMethod("fX", double.class),x0,k,precious);		
			p6_2.function();
			System.out.printf("取 x0=%f ,解得x%d= ",x0,p6_2.getK());
			System.out.println(p6_2.getX0());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
