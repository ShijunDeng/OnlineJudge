package xiaodeng.method;
/**
 * @author:邓仕军
 * time:2012-04-14
 * 矩阵方法接口：定义这个接口,因为不同人操作习惯不同,主要体现在下标起始是0还是1,矩阵的起始行列式0还是1
 * 故而定义接口,用的时候就按照自己的习惯去实现
 */
interface MatrixMethods {
	//设定某个位置上元素的值
	void setElementAt(int row, int column, double value);
	//得到某个位置上元素的值
	double getElementAt(int row, int column);
	//设定一行的值
	void setRowValues(int row, double[] rowValues);
	//设定一列的值
	void setColumnValues(int column, double[] columnValues);
	//得到某一行的值
	double[] getRowValues(int row);
	//得到某一列的值
	double[] getColumnValues(int column);
	//交换两行的值
	void exchangeRowValues(int row1,int row2);
	//交换两列的值
	void exchangeColumnValues(int column1,int column2);
}
