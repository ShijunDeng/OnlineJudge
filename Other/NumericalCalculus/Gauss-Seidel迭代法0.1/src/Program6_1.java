import xiaodeng.method.Matrix;

/**
 * @author 邓仕军
 * @time 2012-06-04
 * @version0.1
 * @function:Gauss-Seidel迭代法解线性方程组
 */
class Program6_1 {

	Matrix coefficientMatrix;// 系数矩阵
	Matrix constantMatrix;// 常数矩阵
	double[] result;// 结果集
	double precious = 10E-5;
	int size = 0;// result也即结果集的长度

	public Program6_1(Matrix coefficientMatrix, Matrix constantMatrix,
			double precious) {
		this.coefficientMatrix = coefficientMatrix;
		this.constantMatrix = constantMatrix;
		this.precious = precious;
		this.size = coefficientMatrix.getNumColumns();
		result = new double[size];
	}

	// 返回result中的最大值
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

	// 根据当前的result,计算一次,得到新的result
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

	// 根据精度,调用calculate,得到在精度范围内的结果集
	public void function() {
		double[] temp1, temp2;
		// 虽然java会自动初始化result为0，但是为了程序的可读性、可移植性、扩展性,还是在这里手动初始化一下
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
