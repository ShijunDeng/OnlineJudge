/*
 * @author:���˾�
 * time:2012-04-20
 *  ׷�Ϸ�����
 */

public class TestClass {
	public static void main(String[] args) {

		
		SolveEquation su = new SolveEquation(new Matrix(5, 5, new double[][] {
				{ -2, 1, 0, 0 ,0}, { 1, -2, 0, 0 ,0}, { 0, 1,-2, 0, 0 },
				{ 0, 0, 1, -2,0 },{0,0,0,1,-2} }), new Matrix(5, 1, new double[][] {{-10},
				{0}, {0}, {0},{0}}));
			
			System.out.println("׷�Ϸ���");
			su.getCoefficientMatrix().printMatrix();			
			su.getConstantMatrix().printMatrix();
			su.solve();
			System.out.println("L��");
			su.getLU().getL().printMatrix(2);//����ѱ�����ƣ����Կ���С�����С����λ��
			System.out.println("U��");
			su.getLU().getU().printMatrix(2);
			System.out.println("��");
			su.getIntermediateMartrix().printMatrix(2);
		// d.getL().multiplication(d.getU()).printMatrix();
	}

}
/*
 * 1 2 3 -1 x1 =5 2 -1 9 17 x2=3 -3 4 -3 19 x3= 17 4 -2 6 21 x4=-13 1 0 0 0 1 2
 * 3 -1 2 1 0 0 0 -5 3 19 -3 -2 1 0 0 0 12 54 4 2 -1 1 0 0 0 41
 */
