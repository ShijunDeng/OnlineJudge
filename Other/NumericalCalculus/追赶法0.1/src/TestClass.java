/*
 * @author:邓仕军
 * time:2012-04-20
 *  追赶法测试
 */

public class TestClass {
	public static void main(String[] args) {

		
		SolveEquation su = new SolveEquation(new Matrix(5, 5, new double[][] {
				{ -2, 1, 0, 0 ,0}, { 1, -2, 0, 0 ,0}, { 0, 1,-2, 0, 0 },
				{ 0, 0, 1, -2,0 },{0,0,0,1,-2} }), new Matrix(5, 1, new double[][] {{-10},
				{0}, {0}, {0},{0}}));
			
			System.out.println("追赶法：");
			su.getCoefficientMatrix().printMatrix();			
			su.getConstantMatrix().printMatrix();
			su.solve();
			System.out.println("L：");
			su.getLU().getL().printMatrix(2);//输出已被我设计，可以控制小数点后小数的位数
			System.out.println("U：");
			su.getLU().getU().printMatrix(2);
			System.out.println("解");
			su.getIntermediateMartrix().printMatrix(2);
		// d.getL().multiplication(d.getU()).printMatrix();
	}

}
/*
 * 1 2 3 -1 x1 =5 2 -1 9 17 x2=3 -3 4 -3 19 x3= 17 4 -2 6 21 x4=-13 1 0 0 0 1 2
 * 3 -1 2 1 0 0 0 -5 3 19 -3 -2 1 0 0 0 12 54 4 2 -1 1 0 0 0 41
 */
