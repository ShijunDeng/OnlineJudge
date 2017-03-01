import javax.swing.JOptionPane;

/*
 * 
 * @author:邓仕军
 * time:2012-04-14
 * Gauss列主元素消去法消元求解
 */
//Elimination
  class Solution {
	Matrix coefficientMatrix;// 系数矩阵
	Matrix constantMatrix;// 常数矩阵
	int record[];

	public Solution(Matrix coefficientMatrix, Matrix constantMatrix) {
		this.coefficientMatrix = coefficientMatrix;
		this.constantMatrix = constantMatrix;
		record = new int[coefficientMatrix.getNumColumns()];//

	}

	public Solution() {
		this.coefficientMatrix = new Matrix();
		this.constantMatrix = new Matrix();

	}

	/*
	 * 求解---消元
	 */
	public void elimination() {// 消元

		Element eMax = new Element();
		record = new int[coefficientMatrix.getNumColumns()];
		for (int i = 1; i <= coefficientMatrix.getNumColumns(); i++)
			record[i - 1] = i;
		for (int k = 1; k < coefficientMatrix.getNumColumns(); k++) {
			eMax = coefficientMatrix.getMaxElement(k, k);// 得到最大元的相关信息

			coefficientMatrix.exchangeRowValues(k, eMax.getRowsPosition());
			constantMatrix.exchangeRowValues(k, eMax.getRowsPosition());

			coefficientMatrix
					.exchangeColumnValues(k, eMax.getColumnsPosition());// l列变换了，record就也要变换了
			// ////////////////////////////////////
			int temp = record[k - 1];
			record[k - 1] = record[eMax.getColumnsPosition() - 1];
			record[eMax.getColumnsPosition() - 1] = temp;
			// ///////////////////////////////

			for (int i = k + 1; i <= coefficientMatrix.getNumColumns(); i++) {// ////--------
				if (Math.abs(coefficientMatrix.getElementAt(k, k) - 0) > coefficientMatrix
						.getPrecision())// 不能是==0,因为double无法绝对的==,只能用精度控制
					coefficientMatrix.setElementAt(i, k,
							coefficientMatrix.getElementAt(i, k)
									/ coefficientMatrix.getElementAt(k, k));
				else {
					System.out.println("数值超出精度之外,无法进行计算！");
					return;
				}
				for (int j = k + 1; j <= coefficientMatrix.getNumColumns(); j++) {
					coefficientMatrix.setElementAt(i, j,
							coefficientMatrix.getElementAt(i, j)
									- coefficientMatrix.getElementAt(k, j)
									* coefficientMatrix.getElementAt(i, k));
				}
				constantMatrix.setElementAt(
						i,
						constantMatrix.getNumColumns(),
						constantMatrix.getElementAt(i,
								constantMatrix.getNumColumns())
								- constantMatrix.getElementAt(k,
										constantMatrix.getNumColumns())
								* coefficientMatrix.getElementAt(i, k));
			}// ////--------
		}//

	}

	/*
	 * 回带并求解
	 */
	public void backStrap() {
		if (Math.abs(coefficientMatrix.getElementAt(
				coefficientMatrix.getNumRows(),
				coefficientMatrix.getNumColumns()) - 0) > coefficientMatrix
				.getPrecision()) {
			constantMatrix.setElementAt(
					constantMatrix.getNumRows(),
					constantMatrix.getNumColumns(),
					constantMatrix.getElementAt(constantMatrix.getNumRows(),
							constantMatrix.getNumColumns())
							/ coefficientMatrix.getElementAt(
									coefficientMatrix.getNumRows(),
									coefficientMatrix.getNumColumns()));

			for (int i = constantMatrix.getNumRows() - 1; i >= 1; i--) {

				for (int j = i + 1; j <= coefficientMatrix.getNumColumns(); j++) {
					constantMatrix.setElementAt(
							i,
							constantMatrix.getNumColumns(),
							constantMatrix.getElementAt(i,
									constantMatrix.getNumColumns())
									- coefficientMatrix.getElementAt(i, j)
									* constantMatrix.getElementAt(j,
											constantMatrix.getNumColumns()));
				}
				constantMatrix.setElementAt(
						i,
						constantMatrix.getNumColumns(),
						constantMatrix.getElementAt(i,
								constantMatrix.getNumColumns())
								/ coefficientMatrix.getElementAt(i, i));

			}
		} else {
			JOptionPane.showMessageDialog(null,"当前条件下无法求解！"  , "提示",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		// 将常数项，也就是解排好序

		for (int i = 0; i < coefficientMatrix.getNumRows(); i++) {
			for (int j = i + 1; j < coefficientMatrix.getNumColumns(); j++)
				if (record[j] == i + 1) {

					constantMatrix.exchangeRowValues(i + 1, j + 1);
					int temp = record[i];
					record[i] = record[j];
					record[j] = temp;
					//constantMatrix.printMatrix();
				 
					continue;
				}
		}

	}

	public void solve() {
		//coefficientMatrix.printMatrix();
	//	 constantMatrix.printMatrix();
		elimination();
		backStrap();
		 //constantMatrix.printMatrix();
	}

	Matrix getCoefficientMatrix() {
		return coefficientMatrix;
	}

	Matrix getConstantMatrix() {
		return constantMatrix;
	}

	int[] getRecord() {
		return record;
	}

	 

}
