package xiaodeng.method;
/**
 * @author:���˾�
 * time:2012-04-14
 * ���󷽷��ӿڣ���������ӿ�,��Ϊ��ͬ�˲���ϰ�߲�ͬ,��Ҫ�������±���ʼ��0����1,�������ʼ����ʽ0����1
 * �ʶ�����ӿ�,�õ�ʱ��Ͱ����Լ���ϰ��ȥʵ��
 */
interface MatrixMethods {
	//�趨ĳ��λ����Ԫ�ص�ֵ
	void setElementAt(int row, int column, double value);
	//�õ�ĳ��λ����Ԫ�ص�ֵ
	double getElementAt(int row, int column);
	//�趨һ�е�ֵ
	void setRowValues(int row, double[] rowValues);
	//�趨һ�е�ֵ
	void setColumnValues(int column, double[] columnValues);
	//�õ�ĳһ�е�ֵ
	double[] getRowValues(int row);
	//�õ�ĳһ�е�ֵ
	double[] getColumnValues(int column);
	//�������е�ֵ
	void exchangeRowValues(int row1,int row2);
	//�������е�ֵ
	void exchangeColumnValues(int column1,int column2);
}
