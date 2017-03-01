/*
 * @author:邓仕军
 * time:2012-04-20
 *  追赶法
 */
class DecomposeLU {

	Matrix A;// 被分解的矩阵的拷贝,由调用者传进来
	Matrix L = null;// 分解A得到的下三角单位矩阵
	Matrix U = null;// 分解A得到的上三角矩阵

	public DecomposeLU(Matrix A) {
		this.A = A;
		L = new Matrix(A.getNumRows());// 因为是方阵,用行或者列初始化都一样
		U = new Matrix(A.getNumRows());
		//decomposeByDoolittle();
	}

	Matrix getL() {
		return L;
	}

	Matrix getU() {
		return U;
	}

	
	void decomposeByGrout() {
		for (int i = 1; i <L.getNumColumns(); i++) {
			L.setElementAt(i+1, i, A.getElementAt(i+1, i));
		}
		L.setElementAt(1, 1,A.getElementAt(1, 1));
		for (int i = 2; i <= A.getNumColumns(); i++) {
			U.setElementAt(i-1, i, A.getElementAt(i-1, i) / L.getElementAt(i-1, i-1));
			L.setElementAt(i, i, A.getElementAt(i, i)-U.getElementAt(i-1, i)*L.getElementAt(i, i-1));
		} 

 
		// L中剩余元素置0或1
		for (int i = 1; i <=  L.getNumRows(); i++) {
			for (int j = i+1; j <=L.getNumColumns(); j++) {
					L.setElementAt(i, j, 0);
				if(j>i+1)
					L.setElementAt(j, i, 0);
			}
		}

		// U中剩余元素置零
		for (int i = 2; i <= U.getNumRows(); i++) { 
			for (int j = 1; j <i; j++) {// j<i没有等于
				U.setElementAt(i,j, 0);
				 if(i>j+1)
					 U.setElementAt(j,i, 0);
			}
		}

	}
	
	
}// DecomposeLU
