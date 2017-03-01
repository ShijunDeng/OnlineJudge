
public class TestClass {
	public static void main(String[] args) {
		 
		double [][]value=new double [][]{{1,2,3,-1},{2,-1,9,17},{-3,4,-3,19},{4,-2,6,21}};
		Matrix testM=new Matrix(4,4,value);
		testM.printMatrix();
		System.out.println("L");
		DecomposeLU d=new DecomposeLU(testM);
		d.decomposeByGrout();
		d.getL().printMatrix();
		System.out.println("U");
		d.getU().printMatrix();
		System.out.println("LU");
		d.getL().multiplication(d.getU()).printMatrix();
	}

}
/*
1     2     3    -1    x1 =5      
2    -1     9    17    x2=3  
	-3     4    -3    19   x3= 17
4     -2    6    21  x4=-13
1  0  0  0       1  2  3   -1  
2  1  0  0       0 -5  3   19 
-3 -2  1  0       0  0  12  54 
	4  2 -1  1       0  0  0   41 
	  */
