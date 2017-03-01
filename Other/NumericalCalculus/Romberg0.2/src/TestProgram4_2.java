public class TestProgram4_2 {
	public TestProgram4_2() {

	}

	double fX(double x) {
		return Math.sin(x) ;
	}

	public static void main(String[] args) {

		try {
			TestProgram4_2 t = new TestProgram4_2();
			Program4_2 pro4_2 = new Program4_2( 10E-15, 3*Math.PI, t
					.getClass().getDeclaredMethod("fX", double.class), 10E-15,
					t);
			System.out.printf("f(x)=sinx,积分区间[0,3π]测试结果：%.5f" ,pro4_2.function());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
