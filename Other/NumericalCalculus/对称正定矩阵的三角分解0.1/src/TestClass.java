/*
 * @author:���˾�
 * time:2012-04-20
 * ����
 */

public class TestClass {
	public static void main(String[] args) {
		SolveEquation su = new SolveEquation(new Matrix(3, 3, new double[][] {
				{ 4, -1,1 }, { -1, 17/4d,11/4d }, { 1, 11/4d, 7/2d}}), new Matrix(3, 1, new double[][] { {0},
				{1}, {0} }));
			su.solve();
			System.out.println("ֱ�������ηֽⷨ--decomposeByDoolittle--��Ӧ�ⷽ�̣�");
			su.getCoefficientMatrix().printMatrix();
			su.getConstantMatrix().printMatrix();
			System.out.println("�������;���");
			su.getTRi().getDTri().printMatrix();
			System.out.println("�������;���");
			su.getTRi().getUTri().printMatrix();
			System.out.println("��");
			su.getIntermediateMartrix().printMatrix();
		// d.getL().multiplication(d.getU()).printMatrix();
	}

}
 
