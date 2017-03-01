/*
 * 
 * @author:邓仕军
 * time:2012-04-14
 * 分解后求解
 */
//Elimination
public class SolveEquation {
	Matrix coefficientMatrix;// 系数矩阵
	Matrix constantMatrix;// 常数矩阵
	Matrix intermediateMartrix;// 中间矩阵变量y1，y2，y3......-->x1,x2,x3..........
	DecomposeLU LU;// 分解的
	int record[];

	public SolveEquation(Matrix coefficientMatrix, Matrix constantMatrix) {
		this.coefficientMatrix = coefficientMatrix;
		this.constantMatrix = constantMatrix;
		LU = new DecomposeLU(coefficientMatrix);
		LU.decomposeByGrout();
		this.intermediateMartrix = new Matrix(constantMatrix.getNumRows(), 1);
		record = new int[coefficientMatrix.getNumColumns()];//

	}

	public SolveEquation() {
		this.coefficientMatrix = new Matrix();
		this.constantMatrix = new Matrix();
		LU = new DecomposeLU(coefficientMatrix);
		LU.decomposeByGrout();
		this.intermediateMartrix = new Matrix(constantMatrix.getNumRows(), 1);

	}

	/*
	 * 回带并求解：decomposeByGrout分解对应的回带
	 */
	public void backStrap() {

		intermediateMartrix.setElementAt(1, 1,
				constantMatrix.getElementAt(1, 1)
						/ LU.getL().getElementAt(1, 1));
		for (int i = 2; i <= LU.getL().getNumRows(); i++) {
			double tempElementOfcon = constantMatrix.getElementAt(i, 1);
			for (int j = 1; j < i; j++) {
				tempElementOfcon -= LU.getL().getElementAt(i, j)
						* intermediateMartrix.getElementAt(j, 1);
			}
			intermediateMartrix.setElementAt(i, 1, tempElementOfcon
					/ LU.getL().getElementAt(i, i));
			tempElementOfcon = 0;

		}

		intermediateMartrix.setElementAt(
				intermediateMartrix.getNumRows(),
				intermediateMartrix.getNumColumns(),
				intermediateMartrix.getElementAt(
						intermediateMartrix.getNumRows(),
						intermediateMartrix.getNumColumns()));

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
							intermediateMartrix.getNumColumns()));

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
