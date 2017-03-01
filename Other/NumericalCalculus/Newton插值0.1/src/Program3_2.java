/**
 * @author ���˾�
 * @time 2012-04-28
 * @version0.1
 * Newton��ֵ����
 *  �˳���parameter�ǲ���Ҫ�ģ���Ϊ��ȫ������data�����ά�����б�����õ�a1,a2,...,an ��
 *  ��������Ҳ��data�е����ݸ����ˣ����һ��������Ҫ������ݣ������޷���֤ʹ����������
 *  �˲������Ҫʹ��data��Ҫ�󣩣���������������ˣ��ڱ��汾���ҽ�ʹ��һ��parameterһά
 *  ���鱣��a1,a2,...,an���Ӷ�ʹ��data�е����ݵ��Ա�������������һ���汾�У� �ҽ�ֻʹ��
 *  data�����ά���飬ʵ��ͬ���Ĺ���
 */
class Program3_2 {
	private double[][] data;// ���������������б�
	private int size;// dataֵ�Ķ���
	private double[] parameter;// ����

	public Program3_2() {
		init();
	}

	public Program3_2(double data[][], int size) {
		init(data, size);
	}

	void init(double data[][], int size) {
		this.data = data;
		this.size = size;
		this.parameter = new double[size];

		// �����
		for (int i = this.getSize() - 1; i >= 0; i--) {
			if (i == 0) {
				this.parameter[0] = this.getData()[0][1];
			} else {
				this.parameter[i] = (this.getData()[i][1] - this.getData()[i - 1][1])
						/ (this.getData()[i][0] - this.getData()[i - 1][0]);

			}
		}

		for (int i = 2; i < this.getSize(); i++) {
			for (int j = this.getSize() - 1; j >= i; j--) {
				this.parameter[j] = (this.getParameter()[j] - this
						.getParameter()[j - 1])
						/ (this.getData()[j][0] - this.getData()[j - i][0]);
			}
		}

	}

	void init() {
		this.data = new double[][] {};
		this.size = 0;
		this.parameter = new double[size];
	}

	void setData(double data[][], int size) {
		init(data, size);
	}

	public int getSize() {
		return this.size;
	}

	public double[][] getData() {
		return this.data;
	}

	public double[] getParameter() {
		return this.parameter;
	}

	double function(double x) {
		double sum = 0d;
		for (int i = this.getSize() - 2; i >= 1; i--) {
			if (i == this.getSize() - 2) {
				sum += ((x - this.getData()[i - 1][0]) * this.getParameter()[i] + this
						.getParameter()[i - 1]);
			} else {
				sum *= (x - this.getData()[i - 1][0]);
				sum += this.getParameter()[i - 1];
			}

		}
		return sum;
	}// function

	public void print() {
		// ���Կ�����֤ʵ��Ϊdata�����ݵ��Ա��棬������ʵ�ִ�ӡ�������ʽ��ô�ķ���
		System.out.print("X     ");
		for (int i = 0; i < this.size; i++) {
			System.out.print(data[i][0] + "  ");
		}

		System.out.println();
		System.out.print("y=f(x)  ");
		for (int i = 0; i < this.size; i++) {
			System.out.print(data[i][1] + "  ");
		}

		System.out.println();
	}
}// Program3_2
