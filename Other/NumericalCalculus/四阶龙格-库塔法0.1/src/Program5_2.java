import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author 邓仕军
 * @time 2012-05-28
 * @version0.1
 * @function:四阶龙格-库塔法
 */
class Program5_2 {
	Method f;
	double u_limit;
	double l_limit;
	double[][] result;// 结果值表
	double x0, y0;// 初值
	double h;// 步长

	public Program5_2(Method f, double l_limit, double u_limit, double x0,
			double y0, double h) {
		this.f = f;
		this.l_limit = l_limit;
		this.u_limit = u_limit;
		this.x0 = x0;
		this.y0 = y0;
		this.h = h;
		// -----------初始化result结果集,(x0,y0)也存入其中---------------
		result = new double[(int) ((u_limit - l_limit) / h) + 1][2];
		result[0][0] = x0;
		result[0][1] = y0;
	}

	strictfp double[][] functionA() {
		int n = (int) ((this.u_limit - this.l_limit) / this.h) + 1;
		double K1 = 0d, K2 = 0d, K3 = 0d, K4 = 0d;
		for (int i = 1; i < n; i++) {
			this.result[i][0] = this.x0 + i * this.h;
			try {
				K1 = (Double) f.invoke(null, this.result[i - 1][0],
						this.result[i - 1][1]);
				K2 = (Double) f.invoke(null, this.result[i - 1][0] + h / 2,
						this.result[i - 1][1] + h / 2 * K1);
				K3 = (Double) f.invoke(null, this.result[i - 1][0] + h / 2,
						this.result[i - 1][1] + h / 2 * K2);
				K4 = (Double) f.invoke(null, this.result[i - 1][0] + h,
						this.result[i - 1][1] + h * K3);

				this.result[i][1] = this.result[i - 1][1] + this.h / 6
						* (K1 + 2 * K2 + 2 * K3 + K4);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}// for
		return this.result;
	}// functionA

	void print() {

		int n = (int) ((this.u_limit - this.l_limit) / this.h) + 1;
		
		System.out.printf("%8s", "i:");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12s", i);
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.printf("%12s", "-------------");
		}
		this.functionA();
		System.out.println();
				
		System.out.printf("%8s", "X取值:");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12.5f", result[i][0]);
		}
		System.out.println();
	
		System.out.printf("%8s", "y=f(x)");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12.5f", result[i][1]);
		}
		System.out.println();

	}
}
