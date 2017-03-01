/*
 * @author:���˾�
 * time:2012-04-20
 *  ׷�Ϸ�
 */
class DecomposeLU {

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

	
	void decomposeByGrout() {
		for (int i = 1; i <L.getNumColumns(); i++) {
			L.setElementAt(i+1, i, A.getElementAt(i+1, i));
		}
		L.setElementAt(1, 1,A.getElementAt(1, 1));
		for (int i = 2; i <= A.getNumColumns(); i++) {
			U.setElementAt(i-1, i, A.getElementAt(i-1, i) / L.getElementAt(i-1, i-1));
			L.setElementAt(i, i, A.getElementAt(i, i)-U.getElementAt(i-1, i)*L.getElementAt(i, i-1));
		} 

 
		// L��ʣ��Ԫ����0��1
		for (int i = 1; i <=  L.getNumRows(); i++) {
			for (int j = i+1; j <=L.getNumColumns(); j++) {
					L.setElementAt(i, j, 0);
				if(j>i+1)
					L.setElementAt(j, i, 0);
			}
		}

		// U��ʣ��Ԫ������
		for (int i = 2; i <= U.getNumRows(); i++) { 
			for (int j = 1; j <i; j++) {// j<iû�е���
				U.setElementAt(i,j, 0);
				 if(i>j+1)
					 U.setElementAt(j,i, 0);
			}
		}

	}
	
	
}// DecomposeLU
