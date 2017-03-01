/*
 * @author:���˾�
 * time:2012-04-20
 *  �Գƾ�������Ƿֽ�
 */
class TriDecompose {

	Matrix A;// ���ֽ�ľ���Ŀ���,�ɵ����ߴ�����
	Matrix UTri = null;// �ֽ�A�õ��������Ǿ���
	Matrix DTri = null;// �ֽ�A�õ��������Ǿ���

	public TriDecompose(Matrix A) {
		this.A = A;
		UTri = new Matrix(A.getNumRows());// ��Ϊ�Ƿ���,���л����г�ʼ����һ��
		DTri = new Matrix(A.getNumRows());
	 
	}

	Matrix getUTri() {
		return UTri;
	}

	Matrix getDTri() {
		return DTri;
	}

	/*
	 * ִ�зֽ�ĺ���--�Գƾ�������Ƿֽ�
	 */
	void triangleDecompose() {

		// ���õ�λ�����Ǿ���1,1��λ��Ԫ��
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

		// L��ʣ��Ԫ����0��1
		for (int i = 1; i <= UTri.getNumRows(); i++) {
			for (int j = i + 1; j <= UTri.getNumColumns(); j++) {
				UTri.setElementAt(i, j, 0);
			}
		}	
		UTri = DTri.transpose();
	} // triangleDecompose

}
