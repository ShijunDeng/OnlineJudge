public class TestProgram5_1 {

	static double fX(double x, double y) {
		return y - 2 * x / y;
	}

	public static void main(String[] args) {

		try {
			Program5_1 pro5_1 = new Program5_1(
					TestProgram5_1.class.getDeclaredMethod("fX", double.class,
							double.class), 0, 1, 0, 1, 0.1);
			pro5_1.print();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
