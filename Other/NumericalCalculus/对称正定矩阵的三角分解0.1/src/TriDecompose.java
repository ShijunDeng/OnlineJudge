/*
 * @author:邓仕军
 * time:2012-04-20
 *  对称矩阵的三角分解
 */
class TriDecompose {

	Matrix A;// 被分解的矩阵的拷贝,由调用者传进来
	Matrix UTri = null;// 分解A得到的下三角矩阵
	Matrix DTri = null;// 分解A得到的上三角矩阵

	public TriDecompose(Matrix A) {
		this.A = A;
		UTri = new Matrix(A.getNumRows());// 因为是方阵,用行或者列初始化都一样
		DTri = new Matrix(A.getNumRows());
	 
	}

	Matrix getUTri() {
		return UTri;
	}

	Matrix getDTri() {
		return DTri;
	}

	/*
	 * 执行分解的函数--对称矩阵的三角分解
	 */
	void triangleDecompose() {

		// 设置单位下三角矩阵（1,1）位置元素
		DTri.setElementAt(1, 1, Math.sqrt(A.getElementAt(1, 1)));
		for (int i = 1; i <= A.getNumColumns(); i++) {
			for (int j = i + 1; j <= A.getNumRows(); j++) {
				double temp1 = A.getElementAt(j, i);
				int k = 1;
				while (k < i) {
					temp1 -= DTri.getElementAt(i, k) * DTri.getElementAt(j, k);
					k++;
				}
				DTri.setElementAt(j, i, temp1 / DTri.getElementAt(i, i));
				if (i + 1 <= A.getNumRows()) {
					int p = 1;
					double temp2 = A.getElementAt(i + 1, i + 1);
					while (p <= i) {
						temp2 -= DTri.getElementAt(i + 1, p)
								* DTri.getElementAt(i + 1, p);
						p++;
					}
					DTri.setElementAt(i + 1, i + 1, Math.sqrt(temp2));
				}

			}
		}// for----1

		// L中剩余元素置0或1
		for (int i = 1; i <= UTri.getNumRows(); i++) {
			for (int j = i + 1; j <= UTri.getNumColumns(); j++) {
				UTri.setElementAt(i, j, 0);
			}
		}	
		UTri = DTri.transpose();
	} // triangleDecompose

}
