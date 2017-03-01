/**
 * @author:µÀ Àæ¸
 * @time:2012-04-26
 * Lagrange≤Â÷µ∑®≤‚ ‘
 */
public class TestProgram3_1 {

	public static void main(String[]args){
		/*
	    double [][]data =new double[][]{{144,12},{169,13},{225,15}};
		Program3_1 a=new Program3_1(data,3);
		a.print();
		System.out.println("≤‚ ‘f(175)="+a.interpolation(175));
		*/
		double [][]data =new double[][]{{0.56160,0.82741},{0.56280,0.82659},{0.56401,0.82577},{0.56521,0.82495}};
		Program3_1 a=new Program3_1(data,4);
		a.print();
		System.out.println("≤‚ ‘f(0.5635)="+a.interpolation(0.5635));
	}
	
	 
}
