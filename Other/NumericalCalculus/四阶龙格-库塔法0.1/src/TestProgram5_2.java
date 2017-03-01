public class TestProgram5_2 {

	static double fX(double x, double y) {
		return y - 2 * x / y;
	}

	public static void main(String[] args) {

		try {
			Program5_2 pro5_2 = new Program5_2(
					TestProgram5_2.class.getDeclaredMethod("fX", double.class,
							double.class), 0, 1, 0, 1, 0.1);
			pro5_2.print();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
