public class TestProgram5_3 {

	static double fX(double x, double y) {
		return y - 2 * x / y;
	}

	public static void main(String[] args) {

		try {
			Adams pro5_1 = new Adams(
					TestProgram5_3.class.getDeclaredMethod("fX", double.class,
							double.class), 0, 1, 0, 1, 0.1);
			pro5_1.print();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
