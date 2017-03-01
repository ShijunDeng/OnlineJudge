/*
 * @author:邓仕军
 * time:2012-04-20
 * 构建矩阵类：包含其构造方法以及各种基本的操作
 */
public class Matrix implements MatrixMethods {

	int numRows;
	int numColumns;
	double precision = 0.000000000000;// 精度
	double[][] elements = null;

	/*
	 * 默认构造函数初始矩阵为1*1阶矩阵
	 */
	public Matrix() {
		this.numRows = 1;
		this.numColumns = 1;
		init(numRows, numColumns);
	}

	public Matrix(int nRows, int nColumns) {
		init(nRows, nColumns);
	}

	public Matrix(int nRows, int nColumns, double[][] value) {
		init(nRows, nColumns);
		this.setElements(value);
	}

	public Matrix(int nRows, int nColumns, double[][] value, double precision) {
		init(nRows, nColumns);
		this.setElements(value);
		this.precision = precision;
	}

	public Matrix(Matrix matrix) {
		init(matrix.getNumRows(), matrix.getNumColumns());
		this.setElements(matrix.getElements());
		this.precision = matrix.precision;
	}

	// 方阵
	public Matrix(int n_Row_Column) {
		init(n_Row_Column, n_Row_Column);
	}

	// 方阵带值
	public Matrix(int n_Row_Column, double[][] value) {
		init(n_Row_Column, n_Row_Column);
		this.setElements(value);
	}

	private boolean init(int nRows, int nColumns) {
		if (nRows * nColumns < 0)
			return false;

		this.numRows = nRows;
		this.numColumns = nColumns;
		elements = new double[numRows][numColumns];
		return true;
	}

	int getNumRows() {
		return numRows;
	}

	int getNumColumns() {
		return numColumns;
	}

	double getPrecision() {
		return precision;
	}

	void setPrecision(double precision) {
		this.precision = precision;
	}

	double[][] getElements() {
		return elements.clone();
	}

	void setElements(double[][] elements) {
		this.elements = (double[][]) elements.clone();
	}

	Matrix setValue(Matrix matrix) {
		if (this != matrix) {
			init(matrix.getNumRows(), matrix.getNumColumns());
			this.setElements(matrix.getElements());
			this.precision = matrix.precision;
		}
		return this;
	}

	// 初始化为单位矩阵
	boolean toUniMatrix(int n_Row_Column) {
		if (false == init(n_Row_Column, n_Row_Column))
			return false;
		else
			for (int i = 1; i <= this.getNumRows(); i++)
				for (int j = 1; j <= this.getNumColumns(); j++) {
					if (i == j)
						setElementAt(i, j, 1);
				}
		return true;
	}

	public void setElementAt(int row, int column, double value) {
		this.elements[row - 1][column - 1] = value;
	}

	public double getElementAt(int row, int column) {
		return this.getElements()[row - 1][column - 1];
	}

	public void setRowValues(int row, double[] rowValues) {
		for (int i = 0; i < this.getNumColumns(); i++)
			this.getElements()[row - 1][i] = rowValues[i];
	}

	public void setColumnValues(int column, double[] columnValues) {
		for (int i = 0; i < this.numRows; i++)
			this.elements[i][column - 1] = columnValues[i];
	}

	public double[] getRowValues(int row) {
		double[] temp = this.getElements()[row - 1];
		return temp;
	}

	public double[] getColumnValues(int column) {
		double[] temp = new double[this.getNumRows()];
		for (int i = 0; i < this.getNumRows(); i++)
			temp[i] = this.getElements()[i][column - 1];
		return temp;
	}

	public void exchangeRowValues(int row1, int row2) {
		double temp;
		if (row1 != row2)
			for (int i = 1; i <= this.getNumColumns(); i++) {
				temp = this.getElementAt(row1, i);
				this.setElementAt(row1, i, this.getElementAt(row2, i));
				this.setElementAt(row2, i, temp);

			}
	}

	public void exchangeColumnValues(int column1, int column2) {
		double temp;
		if (column1 != column2)
			for (int i = 1; i <= this.getNumRows(); i++) {
				temp = this.getElementAt(i, column1);
				this.setElementAt(i, column1, this.getElementAt(i, column2));
				this.setElementAt(i, column2, temp);

			}
	}

	public Element getMaxElement() {
		Element e = new Element();
		double temp = this.getElementAt(1, 1);
		e.setValue(1, 1, temp);
		for (int i = 1; i <= this.getNumRows(); i++)
			for (int j = 1; j <= this.getNumColumns(); j++)
				if (this.getElementAt(i, j) > temp) {
					temp = this.getElementAt(i, j);
					e.setValue(i, j, temp);
				}
		return e;
	}

	public Element getMinElement() {
		Element e = new Element();
		double temp = this.getElementAt(1, 1);
		e.setValue(1, 1, temp);
		for (int i = 1; i <= this.getNumRows(); i++)
			for (int j = 1; j <= this.getNumColumns(); j++)
				if (this.getElementAt(i, j) < temp) {
					temp = this.getElementAt(i, j);
					e.setValue(i, j, temp);
				}
		return e;
	}

	/*
	 * 从row行column列起的最大值
	 * 
	 * @return:最大值及其位置
	 */
	public Element getMaxElement(int row, int column) {
		Element e = new Element();
		double temp = this.getElementAt(row, column);
		e.setValue(row, column, temp);
		for (int i = row; i <= this.getNumRows(); i++)
			for (int j = column; j <= this.getNumColumns(); j++)
				if (this.getElementAt(i, j) > temp) {
					temp = this.getElementAt(i, j);
					e.setValue(i, j, temp);
				}
		return e;
	}

	/*
	 * 从row行column列起的最小值
	 * 
	 * @return:最小值及其位置
	 */
	public Element getMinElement(int row, int column) {
		Element e = new Element();
		double temp = this.getElementAt(row, column);
		e.setValue(row, column, temp);
		for (int i = row; i <= this.getNumRows(); i++)
			for (int j = column; j <= this.getNumColumns(); j++)
				if (this.getElementAt(i, j) < temp) {
					temp = this.getElementAt(i, j);
					e.setValue(i, j, temp);
				}
		return e;
	}

	//乘法
	Matrix multiplication(Matrix matrix){
		Matrix temp=new Matrix(this.getNumRows(),matrix.getNumColumns());
		double dTemp=0;
		for(int i=1;i<=this.numRows;i++){
			for(int j=1;j<=this.numColumns;j++){
				for(int k=1;k<=matrix.getNumRows();k++)
				{
					dTemp+=this.getElementAt(i, k)*matrix.getElementAt(k, j);
				}
				temp.setElementAt(i, j, dTemp);
				dTemp=0;//重要
			}
		}
		return temp;
	}
	public void printMatrix() {
		for (int i = 1; i <= this.getNumRows(); i++) {
			for (int j = 1; j <= this.getNumColumns(); j++)
				System.out.print(this.getElementAt(i, j) + "  ");
			System.out.println();
		}
	}
	
	Matrix transpose(){
		Matrix newmat=new Matrix(this.getNumColumns(),this.getNumRows());
		for(int i=1;i<=this.getNumRows();i++){
			for(int j=1;j<=this.getNumColumns();j++){
				newmat.setElementAt(j,i, this.getElementAt(i, j));
			}
		}
		return newmat;
	}
	
 
}// Matrix
