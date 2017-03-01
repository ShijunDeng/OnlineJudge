/*
 * @author:���˾�
 * time:2012-04-16
 *  Doolittle �ֽⷨ�ֽ����
 */
public class DecomposeLU {

	Matrix A;// ���ֽ�ľ���Ŀ���,�ɵ����ߴ�����
	Matrix L = null;// �ֽ�A�õ��������ǵ�λ����
	Matrix U = null;// �ֽ�A�õ��������Ǿ���

	public DecomposeLU(Matrix A) {
		this.A = A;
		L = new Matrix(A.getNumRows());// ��Ϊ�Ƿ���,���л����г�ʼ����һ��
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
	 * ִ�зֽ�ĺ���--Doolittle����
	 */
	void decomposeByDoolittle() {

		for (int i = 1; i <= U.getNumColumns(); i++) {
			U.setElementAt(1, i, A.getElementAt(1, i));
		}
		for (int i = 2; i <= L.getNumRows(); i++) {
			L.setElementAt(i, 1, A.getElementAt(i, 1) / U.getElementAt(1, 1));
		}// ��ʼ�������

		// �����ѭ��
		for (int k = 2; k <= L.getNumColumns(); k++) {

			// ����U��һ��ֵ��ѭ��
			for (int i = k; i <= U.getNumColumns(); i++) {
				double tempElementOfA = A.getElementAt(k, i);// A��һԪ�ص�ֵ
				for (int j = 1; j <= k; j++) {
					tempElementOfA -= L.getElementAt(k, j)
							* U.getElementAt(j, i);
				}// �ڲ�����U��һ��ֵ�ĵ�һ���ڲ�ѭ��
				U.setElementAt(k, i, tempElementOfA);
			}// �ڲ�����U��һ��ֵ������ѭ��

			if (k < L.getNumColumns()) {
				// ����L��һ��ֵ��ѭ��
				for (int i = k + 1; i <= L.getNumRows(); i++) {
					double tempElementOfA = A.getElementAt(i, k);// A��һԪ�ص�ֵ
					for (int j = 1; j < k; j++) {
						tempElementOfA -= L.getElementAt(i, j)
								* U.getElementAt(j, k);
					}// ����L��һ��ֵ���ڲ���һ��ѭ��
					L.setElementAt(i, k, tempElementOfA / U.getElementAt(k, k));
				}// ����L��һ��ֵ������ѭ��
			}// if
		}// ������for

		// L��ʣ��Ԫ����0��1
		for (int i = 1; i <= L.getNumRows(); i++) {
			for (int j = i; j <= L.getNumColumns(); j++) {
				if (j == i)
					L.setElementAt(i, j, 1);
				else
					L.setElementAt(i, j, 0);
			}
		}

		// U��ʣ��Ԫ������
		for (int i = 2; i <= U.getNumRows(); i++) {// i<=U.getNumRows() �е���
			for (int j = 1; j < i; j++) {// j<iû�е���
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
		}// ��ʼ�������

		// �����ѭ��
		for (int k = 2; k <= U.getNumRows(); k++) {

			// �ڲ�����L��һ��ֵ
			for (int i = k; i <= L.getNumRows(); i++) {
				double tempElementOfA = A.getElementAt(i,k );// A��һԪ�ص�ֵ
				for (int j = 1; j <= k; j++) {
					tempElementOfA -= U.getElementAt(j, k)
							* L.getElementAt(i,j );
				}// �ڲ�����L��һ��ֵ�ĵ�һ���ڲ�ѭ��
				L.setElementAt(i, k, tempElementOfA);
			}// �ڲ�����L��һ��ֵ������ѭ��

			if (k < U.getNumRows()) {
				// ����U��һ��ֵ��ѭ��
				for (int i = k + 1; i <= U.getNumColumns(); i++) {
					double tempElementOfA = A.getElementAt(k, i);// A��һԪ�ص�ֵ
					for (int j = 1; j < k; j++) {
						tempElementOfA -= U.getElementAt(j, i)
								* L.getElementAt(k, j);
					}//����U��һ��ֵ���ڲ���һ��ѭ��
					U.setElementAt(k, i, tempElementOfA / L.getElementAt(k, k));
				}// ����U��һ��ֵ������ѭ��
			}// if
		}// ������for

		// U��ʣ��Ԫ����0��1
		for (int i = 1; i <= U.getNumColumns(); i++) {
			for (int j = i; j <= U.getNumRows(); j++) {
				if (j == i)
					U.setElementAt(j, i, 1);
				else
					U.setElementAt(j, i, 0);
			}
		}

		// L��ʣ��Ԫ������
		for (int i = 2; i <= L.getNumColumns(); i++) {// i<=U.getNumRows() �е���
			for (int j = 1; j < i; j++) {// j<iû�е���
				L.setElementAt(j, i, 0);
			}
		}

	}
	
	
}// DecomposeLU
