/**
 * @author 邓仕军
 * @time 2012-04-28
 * @version0.1
 * Newton插值法：
 *  此程序parameter是不必要的，因为完全可以在data这个二维数组中保存求得的a1,a2,...,an ，
 *  但是这样也将data中的数据覆盖了，如果一旦后人需要这个数据（我们无法保证使用这个对象的
 *  人不会提出要使用data的要求），将回天无术。因此，在本版本中我将使用一个parameter一维
 *  数组保存a1,a2,...,an，从而使得data中的数据得以保存下来，在下一个版本中， 我将只使用
 *  data这个二维数组，实现同样的功能
 */
class Program3_2 {
	private double[][] data;// 给定用来算均差的列表
	private int size;// data值的对数
	private double[] parameter;// 参数

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

		// 求参数
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
		// 可以看到，证实因为data中数据得以保存，在这里实现打印这个函数式多么的方便
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
