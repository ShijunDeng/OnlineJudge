/*
 *@author µÀ Àæ¸
 *@version 0.1
 *@time 2012-05-03
 *≤‚ ‘ Hermite≤Â÷µ
 */
public class TestHermite {
	public static void main(String[] args) {
		double[][] data = new double[][] { { 0.0000, 1.0000, 0.0000 },
				{ 1.0000, 0.50000, -0.50000 }, { 2.0000, 0.20000, -0.16000 },
				{ 3.0000, 0.10000, -0.06000 }, { 4.0000, 0.05882, -0.02768 },
				{ 5.0000, 0.03846, -0.01479 } };
		int size = 6;
		Hermite a = new Hermite(data, size);
		double result = 0d;

		result = a.function(0.5);
		a.print();
		System.out.printf("%15S%.5f\n", "≤‚ ‘f(0.5)=", result);

		result = a.function(1.5);
		System.out.printf("%15S%.5f\n", "≤‚ ‘f(1.5)=", result);

		result = a.function(2.5);
		System.out.printf("%15S%.5f\n", "≤‚ ‘f(2.5)=", result);

		result = a.function(3.5);
		System.out.printf("%15S%.5f\n", "≤‚ ‘f(3.5)=", result);

		result = a.function(4.5);
		System.out.printf("%15S%.5f\n", "≤‚ ‘f(4.5)=", result);

	}

}
