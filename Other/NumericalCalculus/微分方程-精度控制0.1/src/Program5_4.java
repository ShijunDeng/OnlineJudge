import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author 邓仕军
 * @time 2012-06-01
 * @version0.1
 * @function:微分方程数值解法-改进的欧拉公式(预报-校正、嵌入公式、平均化形式),可以控制精度 通过控制精度，来求得指定x值的微分方程数值解
 */
class Program5_4 {
	Method f;
	double h;
	double x0, y0;// 初值
	double precious = 0d;

	public Program5_4(Method f, double x0, double y0, double precious) {
		this.f = f;
		this.x0 = x0;
		this.y0 = y0;
		this.precious = precious;
		this.h = 0d;

	}

	double getValueOfdifferentiationA(double x) {
		this.h = x - this.x0;
		double temp1 = this.functionA(x);
		this.h /= 2;
		double temp2 = this.functionA(x);
		while (Math.abs(temp1 - temp2) > this.precious) {
			this.h /= 2;
			temp1 = temp2;
			temp2 = this.functionA(x);
		}
		return (temp1 + temp2) / 2;
	}

	double getValueOfdifferentiationB(double x) {
		this.h = x - this.x0;
		double temp1 = this.functionA(x);
		this.h /= 2;
		double temp2 = this.functionA(x);
		while (Math.abs(temp1 - temp2) > this.precious) {
			this.h /= 2;
			temp1 = temp2;
			temp2 = this.functionA(x);
		}
		return (temp1 + temp2) / 2;
	}

	double getValueOfdifferentiationC(double x) {
		this.h = x - this.x0;
		double temp1 = this.functionA(x);
		this.h /= 2;
		double temp2 = this.functionA(x);
		while (Math.abs(temp1 - temp2) > this.precious) {
			this.h /= 2;
			temp1 = temp2;
			temp2 = this.functionA(x);
		}
		return (temp1 + temp2) / 2;
	}

	// -------------------预报——矫正--------------------------
	strictfp double functionA(double x) {
		// -----------初始化result结果集,(x0,y0)也存入其中---------------
		double[][] result = new double[(int) ((x - this.x0) / h) + 1][2];// 结果值表
		result[0][0] = x0;
		result[0][1] = y0;
		int n = (int) ((x - this.x0) / this.h) + 1;
		for (int i = 1; i < n; i++) {
			double temp = 0d;
			result[i][0] = this.x0 + i * this.h;
			try {
				temp = result[i - 1][1]
						+ this.h
						* ((Double) f.invoke(null, result[i - 1][0],
								result[i - 1][1]));
				result[i][1] = result[i - 1][1] + this.h
						* ((Double) f.invoke(null, result[i][0], temp));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}// for
		return result[n - 1][1];
	}// functionA

	// -------------------嵌入公式--------------------------
	strictfp double functionB(double x) {
		double[][] result = new double[(int) ((x - this.x0) / h) + 1][2];// 结果值表
		result[0][0] = x0;
		result[0][1] = y0;
		int n = (int) ((x - this.x0) / this.h) + 1;
		for (int i = 1; i < n; i++) {
			// double temp = 0d;
			result[i][0] = this.x0 + i * this.h;
			try {
				result[i][1] = result[i - 1][1]
						+ this.h
						/ 2
						* ((Double) f.invoke(null, result[i - 1][0],
								result[i - 1][1])
								+ (Double) f.invoke(null, result[i][0],
										result[i - 1][1]) + this.h
								* (Double) f.invoke(null, result[i - 1][0],
										result[i - 1][1]));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}// for
		return result[n - 2][1];
	}// functionB

	// -------------------平均化形式--------------------------
	strictfp double functionC(double x) {
		double[][] result = new double[(int) ((x - this.x0) / h) + 1][2];// 结果值表
		result[0][0] = x0;
		result[0][1] = y0;
		int n = (int) ((x - this.x0) / this.h) + 1;
		for (int i = 1; i < n; i++) {
			double Yp = 0d, Yc = 0d;// Yp
			result[i][0] = this.x0 + i * this.h;
			try {
				Yp = result[i - 1][1]
						+ this.h
						* ((Double) f.invoke(null, result[i - 1][0],
								result[i - 1][1]));
				Yc = result[i - 1][1] + this.h
						* ((Double) f.invoke(null, result[i][0], Yp));
				result[i][1] = (Yp + Yc) / 2;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}// for
		return result[n - 2][1];
	}// functionC

	double getPrecious() {
		return precious;
	}

	void setPrecious(double precious) {
		this.precious = precious;
	}

}
