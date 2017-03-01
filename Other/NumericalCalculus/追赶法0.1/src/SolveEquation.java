/**
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

	public SolveEquation(Matrix coefficientMatrix, Matrix constantMatrix) {
		this.coefficientMatrix = coefficientMatrix;
		this.constantMatrix = constantMatrix;
		LU = new DecomposeLU(coefficientMatrix);
		LU.decomposeByGrout();
		this.intermediateMartrix = new Matrix(constantMatrix.getNumRows(), 1);
	}

	public SolveEquation() {
		this.coefficientMatrix = new Matrix();
		this.constantMatrix = new Matrix();
		LU = new DecomposeLU(coefficientMatrix);
		LU.decomposeByGrout();
		this.intermediateMartrix = new Matrix(constantMatrix.getNumRows(), 1);

	}

	/*
	 * �ش�����⣺decomposeByGrout�ֽ��Ӧ�Ļش�
	 */
	public void backStrap() {

		intermediateMartrix.setElementAt(1, 1,
				constantMatrix.getElementAt(1, 1)
						/ LU.getL().getElementAt(1, 1));
		for (int i = 2; i <= LU.getL().getNumRows(); i++) {
			intermediateMartrix.setElementAt(
					i,
					1,
					(constantMatrix.getElementAt(i, 1) - LU.getL()
							.getElementAt(i, i - 1)
							* intermediateMartrix.getElementAt(i - 1, 1))
							/ LU.getL().getElementAt(i, i));

		}

		for (int i = intermediateMartrix.getNumRows() - 1; i >= 1; i--) {

			constantMatrix.setElementAt(
					i,
					1,
					intermediateMartrix.getElementAt(i, 1)
							- LU.getU().getElementAt(i, i + 1)
							* constantMatrix.getElementAt(i + 1, 1));
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


}
