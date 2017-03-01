
/*
 * 
 * @author:���˾�
 * time:2012-04-14
 * �ֽ�����
 */
//Elimination
class SolveEquation {
	Matrix coefficientMatrix;// ϵ������
	Matrix constantMatrix;// ��������
	Matrix intermediateMartrix;// �м�������y1��y2��y3......-->x1,x2,x3..........
	DecomposeLU LU;// �ֽ��
	int record[];

	public SolveEquation(Matrix coefficientMatrix, Matrix constantMatrix) {
		this.coefficientMatrix = coefficientMatrix;
		this.constantMatrix = constantMatrix;
		LU = new DecomposeLU(coefficientMatrix);
		LU.decomposeByDoolittle();
		this.intermediateMartrix = new Matrix(constantMatrix.getNumRows(), 1);
		record = new int[coefficientMatrix.getNumColumns()];//

	}

	public SolveEquation() {
		this.coefficientMatrix = new Matrix();
		this.constantMatrix = new Matrix();
		LU = new DecomposeLU(coefficientMatrix);
		LU.decomposeByDoolittle();
		this.intermediateMartrix = new Matrix(constantMatrix.getNumRows(), 1);

	}

	/*
	 * �ش�����⣺decomposeByDoolittle�ֽ��Ӧ�Ļش�
	 */
	public void backStrap() {

		intermediateMartrix.setElementAt(1, 1,
				constantMatrix.getElementAt(1, 1));
		for (int i = 2; i <=LU.getL().getNumRows(); i++) {
			double tempElementOfcon = constantMatrix.getElementAt(i , 1);
			for (int j = 1; j <i; j++) {
				tempElementOfcon -= LU.getL().getElementAt(i, j)
						* intermediateMartrix.getElementAt(j, 1);
			}
			intermediateMartrix.setElementAt(i, 1, tempElementOfcon);
			tempElementOfcon=0;

		}
		
		intermediateMartrix.setElementAt(
				intermediateMartrix.getNumRows(),
				intermediateMartrix.getNumColumns(),
				intermediateMartrix.getElementAt(
						intermediateMartrix.getNumRows(),
						intermediateMartrix.getNumColumns())
						/ LU.getU().getElementAt(LU.getU().getNumRows(),
								LU.getU().getNumColumns()));

		for (int i = intermediateMartrix.getNumRows() - 1; i >= 1; i--) {

			for (int j = i + 1; j <= LU.getU().getNumColumns(); j++) {
				intermediateMartrix.setElementAt(
						i,
						intermediateMartrix.getNumColumns(),
						intermediateMartrix.getElementAt(i,
								intermediateMartrix.getNumColumns())
								- LU.getU().getElementAt(i, j)
								* intermediateMartrix.getElementAt(j,
										intermediateMartrix.getNumColumns()));
			}
			intermediateMartrix.setElementAt(
					i,
					intermediateMartrix.getNumColumns(),
					intermediateMartrix.getElementAt(i,
							intermediateMartrix.getNumColumns())
							/ LU.getU().getElementAt(i, i));

		}
		

	}

	public void solve() {
		backStrap();
	}

	Matrix getCoefficientMatrix() {
		return coefficientMatrix;
	}

	Matrix getConstantMatrix() {
		return constantMatrix;
	}

	Matrix getIntermediateMartrix() {
		return intermediateMartrix;
	}

	DecomposeLU getLU() {
		return LU;
	}

	int[] getRecord() {
		return record;
	}

}
