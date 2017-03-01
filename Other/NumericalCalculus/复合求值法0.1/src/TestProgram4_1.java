public class TestProgram4_1 {
	public TestProgram4_1() {

	}

	double fX(double x) {
		if(Math.abs(x)<10E-15)
			return 1;
		return Math.sin(x) / x;
	}

	public static void main(String[] args) {
		TestProgram4_1 t = new TestProgram4_1();
		try {
			Program4_1 pro4_1 = new Program4_1(0 , 1, t.getClass()
					.getDeclaredMethod("fX", double.class), t);
			System.out.println("f(x)=sinx/x ，积分区间[0,1]测试结果：" + pro4_1.function());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
