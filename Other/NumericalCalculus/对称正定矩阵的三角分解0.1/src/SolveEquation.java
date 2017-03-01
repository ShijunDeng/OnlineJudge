/*
 * 
 * @author:邓仕军
 * time:2012-04-20
 * 分解后求解
 */
//SolveEquation
class SolveEquation {
	Matrix coefficientMatrix;// 系数矩阵
	Matrix constantMatrix;// 常数矩阵
	Matrix intermediateMartrix;// 中间矩阵变量y1，y2，y3......-->x1,x2,x3..........
	TriDecompose TRi;// 分解的
	int record[];

	public SolveEquation(Matrix coefficientMatrix, Matrix constantMatrix) {
		this.coefficientMatrix = coefficientMatrix;
		this.constantMatrix = constantMatrix;
		TRi = new TriDecompose(coefficientMatrix);
		TRi.triangleDecompose();
		this.intermediateMartrix = new Matrix(constantMatrix.getNumRows(), 1);
		record = new int[coefficientMatrix.getNumColumns()];//

	}


 
	public void solve() {
		backStrap();
	}

	public void backStrap() {

		intermediateMartrix.setElementAt(1, 1,
				constantMatrix.getElementAt(1, 1)/TRi.getDTri().getElementAt(1, 1) );
		for (int i = 2; i <=TRi.getDTri().getNumRows(); i++) {
			double tempElementOfcon = constantMatrix.getElementAt(i , 1);
			for (int j = 1; j <i; j++) {
				tempElementOfcon -= TRi.getDTri().getElementAt(i, j)
						* intermediateMartrix.getElementAt(j, 1);
			}
			intermediateMartrix.setElementAt(i, 1, tempElementOfcon/TRi.getDTri().getElementAt(i, i));
			tempElementOfcon=0;

		}
		
		intermediateMartrix.setElementAt(
				intermediateMartrix.getNumRows(),
				intermediateMartrix.getNumColumns(),
				intermediateMartrix.getElementAt(
						intermediateMartrix.getNumRows(),
						intermediateMartrix.getNumColumns())
						/ TRi.getUTri().getElementAt(TRi.getUTri().getNumRows(),
								TRi.getUTri().getNumColumns()));

		for (int i = intermediateMartrix.getNumRows() - 1; i >= 1; i--) {

			for (int j = i + 1; j <= TRi.getUTri().getNumColumns(); j++) {
				intermediateMartrix.setElementAt(
						i,
						intermediateMartrix.getNumColumns(),
						intermediateMartrix.getElementAt(i,
								intermediateMartrix.getNumColumns())
								- TRi.getUTri().getElementAt(i, j)
								* intermediateMartrix.getElementAt(j,
										intermediateMartrix.getNumColumns()));
			}
			intermediateMartrix.setElementAt(
					i,
					intermediateMartrix.getNumColumns(),
					intermediateMartrix.getElementAt(i,
							intermediateMartrix.getNumColumns())
							/ TRi.getUTri().getElementAt(i, i));

		}
		

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

	TriDecompose getTRi() {
		return TRi;
	}

	int[] getRecord() {
		return record;
	}

}
