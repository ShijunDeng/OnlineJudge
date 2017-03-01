public class TestClass {
	public static void main(String[] args) {

		
		SolveEquation su = new SolveEquation(new Matrix(4, 4, new double[][] {
				{ 1, 2, 4, 1 }, { 2, 8, 6, 4 }, { 3, 10, 8, 8 },
				{ 4, 12, 10, 6 } }), new Matrix(4, 1, new double[][] { {21},
				{52}, {79}, {82 }}));
			su.solve();
			System.out.println("直角三角形分解法--decomposeByDoolittle--对应解方程：");
			su.getCoefficientMatrix().printMatrix();
			su.getConstantMatrix().printMatrix();
			System.out.println("L：");
			su.getLU().getL().printMatrix();
			System.out.println("U：");
			su.getLU().getU().printMatrix();
			System.out.println("解");
			su.getIntermediateMartrix().printMatrix();
		// d.getL().multiplication(d.getU()).printMatrix();
	}

}
/*
 * 1 2 3 -1 x1 =5 2 -1 9 17 x2=3 -3 4 -3 19 x3= 17 4 -2 6 21 x4=-13 1 0 0 0 1 2
 * 3 -1 2 1 0 0 0 -5 3 19 -3 -2 1 0 0 0 12 54 4 2 -1 1 0 0 0 41
 */
