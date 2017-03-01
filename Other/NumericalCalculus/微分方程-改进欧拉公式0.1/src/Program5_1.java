import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author 邓仕军
 * @time 2012-05-24
 * @version0.1
 * @function:微分方程数值解法-改进的欧拉公式(预报-校正、嵌入公式、平均化形式)
 */
class Program5_1 {
	Method f;
	double u_limit;
	double l_limit;
	double[][] result;// 结果值表
	double x0, y0;// 初值
	double h;// 步长

	public Program5_1(Method f, double l_limit, double u_limit, double x0,
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

	// -------------------预报——矫正--------------------------
	strictfp double[][] functionA() {
		int n = (int) ((this.u_limit - this.l_limit) / this.h) + 1;
		for (int i = 1; i < n; i++) {
			double temp = 0d;
			this.result[i][0] = this.x0 + i * this.h;
			try {
				temp = this.result[i - 1][1]
						+ this.h
						* ((Double) f.invoke(null, this.result[i - 1][0],
								this.result[i - 1][1]));
				this.result[i][1] = this.result[i - 1][1] + this.h
						* ((Double) f.invoke(null, this.result[i][0], temp));
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

	// -------------------嵌入公式--------------------------
	strictfp double[][] functionB() {
		int n = (int) ((this.u_limit - this.l_limit) / this.h) + 1;
		for (int i = 1; i < n; i++) {
			// double temp = 0d;
			this.result[i][0] = this.x0 + i * this.h;
			try {
				this.result[i][1] = this.result[i - 1][1]
						+ this.h
						/ 2
						* ((Double) f.invoke(null, this.result[i - 1][0],
								this.result[i - 1][1])
								+ (Double) f.invoke(null, this.result[i][0],
										this.result[i - 1][1]) + this.h
								* (Double) f.invoke(null,
										this.result[i - 1][0],
										this.result[i - 1][1]));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}// for
		return this.result;
	}// functionB

	// -------------------平均化形式--------------------------
	strictfp double[][] functionC() {
		int n = (int) ((this.u_limit - this.l_limit) / this.h) + 1;
		for (int i = 1; i < n; i++) {
			double Yp = 0d, Yc = 0d;// Yp
			this.result[i][0] = this.x0 + i * this.h;
			try {
				Yp = this.result[i - 1][1]
						+ this.h
						* ((Double) f.invoke(null, this.result[i - 1][0],
								this.result[i - 1][1]));
				Yc = this.result[i - 1][1] + this.h
						* ((Double) f.invoke(null, this.result[i][0], Yp));
				this.result[i][1] = (Yp + Yc) / 2;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}// for
		return this.result;
	}// functionC

	void print() {

		int n = (int) ((this.u_limit - this.l_limit) / this.h) + 1;
		System.out.printf("%8s", "i:");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12s", i);
		}
		System.out.println();
		this.functionA();
		System.out.printf("%8s", " X取值:");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12.5f", result[i][0]);
		}
		System.out.println();
		System.out.println();
		// -----------------预报-------校正----------
		for (int i = 0; i < n; i++) {
			if (i == (int) (n / 2 - 1))
				System.out.printf("%12s", "预报-------校正");
			else
				System.out.printf("%12s", "-------------");
		}
		System.out.println();

		System.out.printf("%8s", "y=f(x)");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12.5f", result[i][1]);
		}
		System.out.println();

		// -----------------嵌入公式----------
		this.functionB();
		for (int i = 0; i < n; i++) {
			if (i == (int) (n / 2 - 1))
				System.out.printf("%12s", "---报嵌入公式---");
			else
				System.out.printf("%12s", "-------------");
		}
		System.out.println();

		System.out.printf("%8s", "y=f(x)");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12.5f", result[i][1]);
		}
		System.out.println();

		// -----------------平均化形式----------
		this.functionC();
		for (int i = 0; i < n; i++) {
			if (i == (int) (n / 2 - 1))
				System.out.printf("%12s", "---平均化形式---");
			else
				System.out.printf("%12s", "-------------");
		}
		System.out.println();

		System.out.printf("%8s", "y=f(x)");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12.5f", result[i][1]);
		}
		System.out.println();

	}

}
