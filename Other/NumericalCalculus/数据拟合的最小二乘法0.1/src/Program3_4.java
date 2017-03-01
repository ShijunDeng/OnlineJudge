/*
 * @author 邓仕军
 * @time:2012-05-07
 * @version 0.1
 */
class Program3_4 {
	private double[][] data;// 传进来的数据
	private int size;// data值的对数
	private double a;
	private double b;
	public Program3_4() {
		init();
	}

	public Program3_4(double data[][], int size) {
		init(data, size);
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
	void init(double data[][], int size) {
		this.data = data;
		this.size = size;
	}
	
	void function(){
		// 将系数确定
		double sum=0d;
		double [][]tempData=new double[2][3];
		
		for(int i=0;i<this.getSize();i++){
			sum+=this.getData()[i][1];
		}
		tempData[0][2]=sum;
		sum=0d;
		

		for(int i=0;i<this.getSize();i++){
			sum+=this.getData()[i][0];
		}
		tempData[1][0]=tempData[0][1]=sum;
		sum=0d;
		
		tempData[0][0]=this.getSize();
		

		for(int i=0;i<this.getSize();i++){
			sum+=this.getData()[i][1]*this.getData()[i][0];
		}
		tempData[1][2]=sum;
		sum=0d;
		
		for(int i=0;i<this.getSize();i++){
			sum+=Math.pow(this.getData()[i][0], 2);
		}
		tempData[1][1]=sum;
		sum=0d;
		
		//开始解方程，确定a,b
		double [][]coefficientMatrix=new double[][]{{tempData[0][0],tempData[0][1]},{tempData[1][0],tempData[1][1]}};
		double [][]constantMatrix=new double[][]{{tempData[0][2]},{tempData[1][2]}};
		SolveEquation so=new SolveEquation(new Matrix(2,2,coefficientMatrix),new Matrix(2,1,constantMatrix));
	    so.solve();		
		b=so.getIntermediateMartrix().getElementAt(1, 1);
		a=so.getIntermediateMartrix().getElementAt(2, 1);
		
	}
	
	void print(){
		System.out.printf("%8s", "i:");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%12s", i);
		}
		System.out
				.println("\n    -----------------------------------------------------------------------------------------");

		System.out.printf("%8s", "X");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%12.5f", data[i][0]);
		}
		System.out.println();

		System.out.printf("%8s", "Y");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%12.5f", data[i][1]);
		}
		System.out.println();

		System.out.printf("\n\t解得：Y =%.4f X + %.4f \n",this.getA(),this.getB());
	}

	double getA() {
		return a;
	}

	double getB() {
		return b;
	}
	
}
