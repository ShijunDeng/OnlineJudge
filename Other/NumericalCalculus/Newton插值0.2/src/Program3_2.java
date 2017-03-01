/**
 * @author ���˾�
 * @time 2012-04-28
 * @version0.2 
 * Newton��ֵ��:����parameter������ʹ��data�����ά���飬����ϵa1,a2...,an,����ȷʵ��Լ�˿ռ䣬
 * ���ں��������Ҫʹ��data�����ݣ��ͷǳ���������.��ˣ��Ҳ�����Ϊ����һ�ֱȰ汾0.1���ǵ�����
 */
class Program3_2 {
	private double[][] data;// ���������������б�
	private int size;// dataֵ�Ķ���

	public Program3_2() {
		init();
	}

	public Program3_2(double data[][], int size) {
		init(data, size);
	}

	void init(double data[][], int size) {
		this.data = data;
		this.size = size;
		this.print();
		// ��Ϊdata�е����ݻᱻ�ƻ������print��ֻ�з�������������û��������ڱ�������data������
		//(��ʵ�����ڵ�print����Ҳ��Ϊdata�ĸı䣬���������ṩ������ϣ���Ĵ�ӡ����)
		//����������Ȼ�������������������ڱ�������Ҳû����ϵ
		for (int i = 1; i < this.getSize(); i++) {
			for (int j = this.getSize() - 1; j >= i; j--) {
				this.data[j][1] = (this.data[j][1] - this.data[j - 1][1])
						/ (this.data[j][0] - this.data[j - i][0]);
			}
		}

	}

	void init() {
		this.data = new double[][] {};
		this.size = 0;
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

	double function(double x) {
		double sum = 0d;
		for (int i = this.getSize() - 2; i >= 1; i--) {
			if (i == this.getSize() - 2) {
				sum += ((x - this.getData()[i - 1][0]) * this.getData()[i][1] + this
						.getData()[i - 1][1]);
			} else {
				sum *= (x - this.getData()[i - 1][0]);
				sum += this.getData()[i - 1][1];
			}

		}
		return sum;
	}// function

	public void print() {
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
