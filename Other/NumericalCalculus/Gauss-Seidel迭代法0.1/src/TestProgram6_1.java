import xiaodeng.method.Matrix;

public class TestProgram6_1 {
	public static void main(String[] args) {
		Program6_1 p6_1 = new Program6_1(new Matrix(3, 3, new double[][] {
				{ 8, -3, 2 }, { 4, 11, -1 }, { 2, 1, 4 } }), new Matrix(3, 1,
				new double[][] { { 20 }, { 33 }, { 12 } }), 10E-5);
		p6_1.function();// 解方程
		System.out.println("方程组为：");
		for (int i = 1; i <= p6_1.getCoefficientMatrix().getNumRows(); i++) {
			for (int j = 1; j <= p6_1.getCoefficientMatrix().getNumColumns(); j++)
				if (j != p6_1.getCoefficientMatrix().getNumColumns())
					System.out.print(p6_1.getCoefficientMatrix().getElementAt(
							i, j)
							+ "x" + j + " + ");
				else {
					System.out.print(p6_1.getCoefficientMatrix().getElementAt(
							i, j)
							+ "x"
							+ j
							+ " = "
							+ p6_1.getConstantMatrix().getElementAt(i, 1));
				}
			System.out.println();
		}
		System.out.println("解得：");
		for (int i = 0; i < p6_1.getSize(); i++) {
			System.out.println("x" + (i + 1) + "=" + p6_1.getResult()[i]);
		}

	}

}
