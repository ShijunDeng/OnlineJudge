/*
 *@author ���˾�
 *@version 0.1
 *@time 2012-05-03
 * Hermite��ֵ
 */
class Hermite {

	Derivative der;// ������
	private double[][] data;// ������������
	private int size;// dataֵ�Ķ���
	private double[] a_x;// ��(x)
	private double[] b_x;// ��(x)
	private int count;

	public Hermite() {
		init();
	}

	public Hermite(double data[][], int size) {
		init(data, size);
	}

	void init() {
		this.data = new double[][] {};
		this.size = 0;
		this.count = 0;
		this.a_x = new double[size];
		this.b_x = new double[size];
		try {
			der = new Derivative(this, this.getClass().getDeclaredMethod("fX",
					double.class));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	void init(double data[][], int size) {
		this.data = data;
		this.count = 0;
		this.size = size;
		this.a_x = new double[size];
		this.b_x = new double[size];
		try {
			der = new Derivative(this, this.getClass().getDeclaredMethod("fX",
					double.class));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}// init(....);

	void setData(double data[][], int size) {
		init(data, size);
	}

	public int getSize() {
		return this.size;
	}

	public double[][] getData() {
		return this.data;
	}

	double function(double x) {
		double sum = 0d;
		// �����
		for (int i = 0; i < this.getSize(); i++) {
			count = i;// L(x)ȷ���±�i
			a_x[i] = (1 - 2 * (x - this.getData()[i][0])
					* der.getDerivative(this.getData()[i][0]))
					* lX(i, x) * lX(i, x);

			b_x[i] = (x - this.getData()[i][0]) * lX(i, x) * lX(i, x);

		}
		// ��ֵ
		for (int i = 0; i < this.getSize(); i++) {
			sum += this.a_x[i] * this.getData()[i][1];
		}
		for (int i = 0; i < this.getSize(); i++) {
			sum += this.b_x[i] * this.getData()[i][2];
		}
		return sum;
	}

	/*
	 * ���󵼵ĺ���
	 */
	double fX(double x) {
		return lX(count, x);
	}

	/*
	 * L(X),kΪ�±�
	 */
	double lX(int k, double x) {
		double sum = 1d;

		for (int i = 0; i < this.size; i++) {
			if (i != k) {
				sum *= (x - data[i][0]) / (data[k][0] - data[i][0]);
			}
		}

		return sum;
	}

	public void print() {
		System.out.printf("%8s", "i:");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%12s", i);
		}
		System.out
				.println("\n    ----------------------------------------------------------------------------");

		System.out.printf("%8s", "X");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%12.5f", data[i][0]);
		}
		System.out.println();

		System.out.printf("%8s", "y=f(x)");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%12.5f", data[i][1]);
		}
		System.out.println();

		System.out.printf("%8s", "y=f'(x)");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%12.5f", data[i][2]);
		}
		System.out.println();

		System.out.printf("%8s", "��(x)");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%12.5f", a_x[i]);
		}
		System.out.println();

		System.out.printf("%8s", "��(x)");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%12.5f", b_x[i]);
		}
		System.out.println();
	}

}
