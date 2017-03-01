public class TestProgram3_4 {

	public static void main(String[] args) {
		double[][] data = new double[][] { { 0, 0.9 }, { 0.2, 1.9 },
				{ 0.4, 2.8 }, { 0.6, 3.3 }, { 0.8, 4.0 }, { 1.0, 5.7 },
				{ 1.2, 6.5 } };
		Program3_4 pro=new Program3_4(data,7);
		pro.function();
		pro.print();

	}

}
