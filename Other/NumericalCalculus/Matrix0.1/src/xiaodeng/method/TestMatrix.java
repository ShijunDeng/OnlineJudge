package xiaodeng.method;
public class TestMatrix {

	public static void main(String[] args) {
		Matrix m=new Matrix(3,3,new double[][]{{5,0,0},{0,4,0},{0,0,1}});
		m.invertMatrix();
		m.printMatrix();

	}

}
