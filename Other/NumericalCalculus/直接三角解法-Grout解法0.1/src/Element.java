/*
 * @author:邓仕军
 * time:2012-04-14
 * 保存矩阵中某个位置的值的行列属性及值
 */
public class Element implements Cloneable
{
	int rowsPosition;
	int columnsPosition;
	double value;
	
	public Element(int rowsPosition, int columnsPosition, double value) {
		this.rowsPosition = rowsPosition;
		this.columnsPosition = columnsPosition;
		this.value = value;
	}
	public Element() {
		this.rowsPosition =0;
		this.columnsPosition = 0;
		this.value = 0;
	}
	
	public Element(Element element) {
		this.rowsPosition = element.getRowsPosition();
		this.columnsPosition = element.getColumnsPosition();
		this.value = element.getValue();
	}
	
	Element getElement(){	 
 
			return (Element)this.clone();
		 
	}
	
	public Element clone()  
	   {
	      return new Element(this);
	   }


	int getRowsPosition() {
		return rowsPosition;
	}

	void setRowsPosition(int rowsPosition) {
		this.rowsPosition = rowsPosition;
	}

	int getColumnsPosition() {
		return columnsPosition;
	}

	void setColumnsPosition(int columnsPosition) {
		this.columnsPosition = columnsPosition;
	}

	public double getValue() {
		return value;
	}

	void setValue(double value) {
		this.value = value;
	}
	
	public void setValue(int rowsPosition, int columnsPosition, double value) {
		this.rowsPosition = rowsPosition;
		this.columnsPosition = columnsPosition;
		this.value = value;
	}
	
}
