/**
 * @author 邓仕军
 * @time 2012-04-28
 * @version0.2 
 * Newton插值法:不用parameter，仅仅使用data这个二维数组，保存系a1,a2...,an,这样确实节约了空间，
 * 但在后面如果需要使用data中数据，就非常不方便了.因此，我并不认为这是一种比版本0.1明智的做法
 */
class Program3_2 {
	private double[][] data;// 给定用来算均差的列表
	private int size;// data值的对数

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
		// 因为data中的数据会被破坏，因此print就只有放在这里，才能让用户看到正在本该属于data的数据
		//(事实上现在的print函数也因为data的改变，并不能再提供我们所希望的打印功能)
		//放在这里显然不符合面向对象理念，但在本程序中也没多大关系
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
