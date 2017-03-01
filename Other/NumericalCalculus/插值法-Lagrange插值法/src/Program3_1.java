/**
 * @author:µËÊË¾ü
 * @time:2012-04-26
 *  Lagrange ²åÖµ·¨
 */
public class Program3_1 {
	private double data[][];
	private int size;

	public Program3_1() {
		init();
	}

	public Program3_1(double data[][], int size) {
		init(data, size);
	}

	void init(double data[][], int size) {
		this.data = data;
		this.size = size;
	}

	void init() {
		this.data = new double[][] {};
		this.size = 0;
	}

	void setData(double data[][], int size) {
		this.data = data;
		this.size = size;
	}

	public int getSize() {
		return this.size;
	}

	void SetSize(int size) {
		this.size = size;
	}

	public double[][] getData() {
		return this.data;
	}

	public double interpolation(double x) {
		double temp = 1d;
		double sum = 0d;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (i != j) {
					temp *= (x - data[j][0]) / (data[i][0] - data[j][0]);
				}

			}
			sum += (temp * data[i][1]);
			temp = 1d;
		}

		return sum;
	}

	public void print() {
		System.out.print("    X    ");
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

}// Program3_1
