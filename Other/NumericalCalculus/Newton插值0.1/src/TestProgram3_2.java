
public class TestProgram3_2 {
	 
	public static void main(String[] args) {	 
			double [][]data =new double[][]{{144,12},{169,13},{225,15}};
			int size=3;
			Program3_2 a=new Program3_2(data,size);
			a.print();
			System.out.println("≤‚ ‘f(175)="+a.function(175));
			
			System.out.println("-----------------------------------");
			data =new double[][]{{0.4,0.41075},{0.55,0.57815},{0.65,0.69675},{0.80,0.88811}};
			size=4;
			a.setData(data, size);
			a.print();
			System.out.println("≤‚ ‘f(0.596)="+a.function(0.596));
			
			System.out.println("-----------------------------------");
			data =new double[][]{{0.80,0.88811},{0.90,1.02652},{1.05,1.25382}};
			size=3;
			a.setData(data, size);
			a.print();
			System.out.println("≤‚ ‘f(0.955)="+a.function(0.955));
		}	 
}
