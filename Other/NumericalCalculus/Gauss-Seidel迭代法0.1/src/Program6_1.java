import xiaodeng.method.Matrix;

/**
 * @author ���˾�
 * @time 2012-06-04
 * @version0.1
 * @function:Gauss-Seidel�����������Է�����
 */
class Program6_1 {

	Matrix coefficientMatrix;// ϵ������
	Matrix constantMatrix;// ��������
	double[] result;// �����
	double precious = 10E-5;
	int size = 0;// resultҲ��������ĳ���

	public Program6_1(Matrix coefficientMatrix, Matrix constantMatrix,
			double precious) {
		this.coefficientMatrix = coefficientMatrix;
		this.constantMatrix = constantMatrix;
		this.precious = precious;
		this.size = coefficientMatrix.getNumColumns();
		result = new double[size];
	}

	// ����result�е����ֵ
	double maxValueOfDiffer(double[] d1, double[] d2) {
		double max = 0d;
		for (int i = 0; i < this.size; i++) {
			double temp = Math.abs(d1[i] - d2[i]);
			if (i == 0 || max < temp) {
				max = temp;
			}
		}
		return max;
	}

	// ���ݵ�ǰ��result,����һ��,�õ��µ�result
	public double[] calculate() {
		for (int i = 1; i <= constantMatrix.getNumRows(); i++) {
			double sum = constantMatrix.getElementAt(i, 1);
			for (int j = 1; j <= constantMatrix.getNumRows(); j++) {
				if (j != i)
					sum -= coefficientMatrix.getElementAt(i, j) * result[j - 1];
			}// for-2
			result[i - 1] = sum / coefficientMatrix.getElementAt(i, i);
		}// for-1
		return result.clone();//
	}// calculate

	// ���ݾ���,����calculate,�õ��ھ��ȷ�Χ�ڵĽ����
	public void function() {
		double[] temp1, temp2;
		// ��Ȼjava���Զ���ʼ��resultΪ0������Ϊ�˳���Ŀɶ��ԡ�����ֲ�ԡ���չ��,�����������ֶ���ʼ��һ��
		for (int i = 0; i < this.size; i++) {
			result[i] = 0d;
		}
		temp1 = calculate();
		temp2 = calculate();
		while (maxValueOfDiffer(temp1, temp2) > this.precious) {
			temp1 = temp2;
			temp2 = calculate();
		}// while
	}// function

	double getPrecious() {
		return precious;
	}

	void setPrecious(double precious) {
		this.precious = precious;
	}

	int getSize() {
		return size;
	}

	void setSize(int size) {
		this.size = size;
	}

	Matrix getCoefficientMatrix() {
		return coefficientMatrix;
	}

	Matrix getConstantMatrix() {
		return constantMatrix;
	}

	double[] getResult() {
		return result.clone();
	}

}
