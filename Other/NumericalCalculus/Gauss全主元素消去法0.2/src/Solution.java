/*
 * 
 * @author:邓仕军
 * time:2012-04-14
 * Gauss列主元素消去法消元求解
 */
//Elimination
public class Solution {
	Matrix coefficientMatrix;// 系数矩阵
	Matrix constantMatrix;// 常数矩阵
	int record[];

	public Solution(Matrix coefficientMatrix, Matrix constantMatrix) {
		this.coefficientMatrix = coefficientMatrix;
		this.constantMatrix = constantMatrix;
		record = new int[coefficientMatrix.getNumColumns()];//
		
		init();
	}

	public Solution() {
		this.coefficientMatrix = new Matrix();
		this.constantMatrix = new Matrix();
		init();
	}

	private void init() {
		/*double[][] x = new double[][] { {1,1,1},{2 ,3,4},{4,6,9}};
		double[][] c = new double[][] { { 6}, { 20 } ,{43}};
		
		coefficientMatrix.setValue(new Matrix(3, 3, x));
		constantMatrix.setValue(new Matrix(3, 1, c));*/
		double[][] x = new double[][] { { 0.2368, 0.2471, 0.2568, 1.2671 },
				{ 0.1968, 0.2071, 1.2168, 0.2271 },
				{ 0.1581, 1.1675, 0.1768, 0.1871 },
				{ 1.1161, 0.1254, 0.1397, 0.1490 } };
		double[][] c = new double[][] { { 1.8471 }, { 1.7471 }, { 1.6471 },
				{ 1.5471 } };
		
		coefficientMatrix.setValue(new Matrix(4, 4, x));
		constantMatrix.setValue(new Matrix(4, 1, c));
		coefficientMatrix.printMatrix();
		//constantMatrix.printMatrix();
		// System.out.println(coefficientMatrix.getMaxElement().getValue());
		// System.out.println(coefficientMatrix.getMinElement().getValue());

	}

	/*
	 * 求解---消元
	 */
	public void elimination() {// 消元

		Element eMax = new Element();
		record=new int[coefficientMatrix.getNumColumns()];
		for (int i = 1; i <= coefficientMatrix.getNumColumns(); i++)
			record[i-1] = i;
		//System.out.println("---------"+record[0]+record[1]+record[2]);
		for (int k = 1; k < coefficientMatrix.getNumColumns(); k++) {
			eMax = coefficientMatrix.getMaxElement(k, k);// 得到最大元的相关信息
			//System.out.println(eMax.getValue());
			
			coefficientMatrix.exchangeRowValues(k, eMax.getRowsPosition());
			constantMatrix.exchangeRowValues(k, eMax.getRowsPosition());

			coefficientMatrix
					.exchangeColumnValues(k, eMax.getColumnsPosition());// l列变换了，record就也要变换了
			// ////////////////////////////////////
			//coefficientMatrix.printMatrix();
			 
			int temp = record[k-1];
			record[k-1] = record[eMax.getColumnsPosition()-1];
			record[eMax.getColumnsPosition()-1] = temp;
			// ///////////////////////////////
			 System.out.println("+++++++++++++"+record[0]+record[1]+record[2]);
			for (int i = k + 1; i <=coefficientMatrix.getNumColumns(); i++) {// ////--------
				if (Math.abs(coefficientMatrix.getElementAt(k, k) - 0) > coefficientMatrix
						.getPrecision())// 不能是==0,因为double无法绝对的==,只能用精度控制
					coefficientMatrix.setElementAt(i, k,
							coefficientMatrix.getElementAt(i, k)
									/ coefficientMatrix.getElementAt(k, k));
				else {
					System.out.println("数值超出精度之外,无法进行计算！");
					return;
				}
				for (int j = k+1; j <= coefficientMatrix.getNumColumns(); j++) {
					coefficientMatrix.setElementAt(i, j,
							coefficientMatrix.getElementAt(i, j)
									- coefficientMatrix.getElementAt(k, j)
									* coefficientMatrix.getElementAt(i, k));
				}
				constantMatrix.setElementAt(
						i,
						constantMatrix.getNumColumns(),
						constantMatrix.getElementAt(i, constantMatrix.getNumColumns())
								- constantMatrix.getElementAt(k, constantMatrix.getNumColumns())
								* coefficientMatrix.getElementAt(i, k));
			}// ////--------
		}//

	}

	/*
	 * 回带并求解
	 */
	public void backStrap() {
		if (Math.abs(coefficientMatrix.getElementAt(
				coefficientMatrix.getNumRows(),
				coefficientMatrix.getNumColumns()) - 0) > coefficientMatrix
				.getPrecision()) {
			constantMatrix.setElementAt(
					constantMatrix.getNumRows(),
					constantMatrix.getNumColumns(),
					constantMatrix.getElementAt(constantMatrix.getNumRows(),
							constantMatrix.getNumColumns())
							/ coefficientMatrix.getElementAt(
									coefficientMatrix.getNumRows(),
									coefficientMatrix.getNumColumns()));

			for (int i = constantMatrix.getNumRows() - 1; i >=1; i--) {

				for (int j = i + 1; j <= coefficientMatrix.getNumColumns(); j++) {
					constantMatrix.setElementAt(
							i,
							constantMatrix.getNumColumns(),
							constantMatrix.getElementAt(i,
									constantMatrix.getNumColumns())
									- coefficientMatrix.getElementAt(i, j)
									* constantMatrix.getElementAt(j,
											constantMatrix.getNumColumns()));
				}
				constantMatrix.setElementAt(
						i,
						constantMatrix.getNumColumns(),constantMatrix.getElementAt(
								i,
								constantMatrix.getNumColumns())/coefficientMatrix.getElementAt(i, i));

			}
		} else {
			System.out.println("当前条件下无法求解！");
			return;
		}
		//将常数项，也就是解排好序
		constantMatrix.printMatrix();
		/*for(int i=0;i<coefficientMatrix.getNumRows()-1;i++)
			for(int j=0;j<coefficientMatrix.getNumColumns()-i-1;j++)
				if(record[j]>record[j+1]){
					System.out.println("---------");
					
					constantMatrix.exchangeRowValues(record[j+1], record[j]);
					int temp=record[j];
					record[j]=record[j+1];
					record[j+1]=temp;
				continue;
				}*/
		 for(int i=0;i<coefficientMatrix.getNumRows();i++)
		 {
		for(int j=i+1;j<coefficientMatrix.getNumColumns();j++)
			if(record[j]==i+1){
 				
				constantMatrix.exchangeRowValues(i+1, j+1);
				int temp=record[i];
				record[i]=record[j];
				record[j]=temp;
				System.out.println("-------------------------");

				constantMatrix.printMatrix();
				System.out.println("---------"+record[0]+record[1]+record[2]);
			continue;
			} 
		 }

	}

	public void solve(){
		elimination() ;
		backStrap();
	}
	public static void main(String[] args) {

		Solution e = new Solution();
		e.solve();
		e.constantMatrix.printMatrix();
		//e.constantMatrix.exchangeRowValues(3, 2);
		//e.constantMatrix.printMatrix();

	}

}
