/*
 * @author:邓仕军
 * time:2012-04-16
 *  Doolittle 分解法分解矩阵
 */
public class DecomposeLU {

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

	/*
	 * 执行分解的函数--Doolittle方法
	 */
	void decomposeByDoolittle() {

		for (int i = 1; i <= U.getNumColumns(); i++) {
			U.setElementAt(1, i, A.getElementAt(1, i));
		}
		for (int i = 2; i <= L.getNumRows(); i++) {
			L.setElementAt(i, 1, A.getElementAt(i, 1) / U.getElementAt(1, 1));
		}// 开始两步完毕

		// 进入大循环
		for (int k = 2; k <= L.getNumColumns(); k++) {

			// 计算U中一行值的循环
			for (int i = k; i <= U.getNumColumns(); i++) {
				double tempElementOfA = A.getElementAt(k, i);// A中一元素的值
				for (int j = 1; j <= k; j++) {
					tempElementOfA -= L.getElementAt(k, j)
							* U.getElementAt(j, i);
				}// 内部计算U中一行值的第一层内部循环
				U.setElementAt(k, i, tempElementOfA);
			}// 内部计算U中一行值的最外循环

			if (k < L.getNumColumns()) {
				// 计算L中一列值的循环
				for (int i = k + 1; i <= L.getNumRows(); i++) {
					double tempElementOfA = A.getElementAt(i, k);// A中一元素的值
					for (int j = 1; j < k; j++) {
						tempElementOfA -= L.getElementAt(i, j)
								* U.getElementAt(j, k);
					}// 计算L中一列值的内部第一层循环
					L.setElementAt(i, k, tempElementOfA / U.getElementAt(k, k));
				}// 计算L中一列值的最外循环
			}// if
		}// 最外层的for

		// L中剩余元素置0或1
		for (int i = 1; i <= L.getNumRows(); i++) {
			for (int j = i; j <= L.getNumColumns(); j++) {
				if (j == i)
					L.setElementAt(i, j, 1);
				else
					L.setElementAt(i, j, 0);
			}
		}

		// U中剩余元素置零
		for (int i = 2; i <= U.getNumRows(); i++) {// i<=U.getNumRows() 有等于
			for (int j = 1; j < i; j++) {// j<i没有等于
				U.setElementAt(i, j, 0);
			}
		}

	}//  decomposeByDoolittle  

	
	void decomposeByGrout() {
		for (int i = 1; i <=L.getNumRows(); i++) {
			L.setElementAt(i, 1, A.getElementAt(i, 1));
		}
		for (int i = 2; i <= U.getNumColumns(); i++) {
			U.setElementAt(1, i, A.getElementAt(1, i) / L.getElementAt(1, 1));
		}// 开始两步完毕

		// 进入大循环
		for (int k = 2; k <= U.getNumRows(); k++) {

			// 内部计算L中一列值
			for (int i = k; i <= L.getNumRows(); i++) {
				double tempElementOfA = A.getElementAt(i,k );// A中一元素的值
				for (int j = 1; j <= k; j++) {
					tempElementOfA -= U.getElementAt(j, k)
							* L.getElementAt(i,j );
				}// 内部计算L中一列值的第一层内部循环
				L.setElementAt(i, k, tempElementOfA);
			}// 内部计算L中一列值的最外循环

			if (k < U.getNumRows()) {
				// 计算U中一行值的循环
				for (int i = k + 1; i <= U.getNumColumns(); i++) {
					double tempElementOfA = A.getElementAt(k, i);// A中一元素的值
					for (int j = 1; j < k; j++) {
						tempElementOfA -= U.getElementAt(j, i)
								* L.getElementAt(k, j);
					}//计算U中一行值的内部第一层循环
					U.setElementAt(k, i, tempElementOfA / L.getElementAt(k, k));
				}// 计算U中一行值的最外循环
			}// if
		}// 最外层的for

		// U中剩余元素置0或1
		for (int i = 1; i <= U.getNumColumns(); i++) {
			for (int j = i; j <= U.getNumRows(); j++) {
				if (j == i)
					U.setElementAt(j, i, 1);
				else
					U.setElementAt(j, i, 0);
			}
		}

		// L中剩余元素置零
		for (int i = 2; i <= L.getNumColumns(); i++) {// i<=U.getNumRows() 有等于
			for (int j = 1; j < i; j++) {// j<i没有等于
				L.setElementAt(j, i, 0);
			}
		}

	}
	
	
}// DecomposeLU
