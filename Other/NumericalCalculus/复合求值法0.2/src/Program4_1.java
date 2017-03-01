import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 邓仕军
 * @time2012-05-17
 * 复合求积
 */
class Program4_1 {

	double u_limit;
	double l_limit;
	Method f;
	Object obj;
	double precious = 10E-6;// 精度

	public Program4_1(double l_limit, double u_limit, Method f,
			double precious, Object obj) {
		init(l_limit, u_limit, f, obj);
		this.precious = precious;
	}

	public Program4_1(double l_limit, double u_limit, Method f, Object obj) {
		init(l_limit, u_limit, f, obj);
	}

	/**
	 * Description：初始化
	 * 
	 * @param l_limit
	 *            下限
	 * @param u_limit
	 *            上限
	 * @param f
	 *            函数对象
	 */
	private void init(double l_limit, double u_limit, Method f, Object obj) {
		this.l_limit = l_limit;
		this.u_limit = u_limit;
		this.f = f;
		this.obj = obj;
	}

	strictfp double function() {
		int n = 1;
		double h = (this.u_limit - this.l_limit) / n;
		double T1 = 0d, T2 = 0d;
		try {
			T1 = ((Double) (f.invoke(this.obj, this.l_limit)) + (Double) (f
					.invoke(this.obj, this.u_limit))) * h / 2;

			T2 = T1 / 2 + h / 2
					* ((Double) (f.invoke(this.obj, this.l_limit + 1 / 2 * h)));
			System.out.println("T1=" + T1);
			System.out.println("T2=" + T2);
			n *= 2;
			h = (this.u_limit - this.l_limit) / n;
			while (Math.abs(T2 - T1) > this.precious) {
				System.out.println("---------------------");
				double sum = 0d;
				T1 = T2;
				T2 /= 2;
				for (int i = 1; i <= n; i++) {
					sum += (Double) (f.invoke(this.obj, this.l_limit + i * h));
				}
				sum *= (h / 2);
				T2 += sum;
				n *= 2;
				h = (this.u_limit - this.l_limit) / n;
				System.out.println("T1=" + T1);
				System.out.println("T2=" + T2);
			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return T1;
	}

	strictfp double function(int count) {
		int n = 1;
		double h = (this.u_limit - this.l_limit) / n;
		double T1 = 0d, T2 = 0d;
		try {
			T1 = ((Double) (f.invoke(this.obj, this.l_limit)) + (Double) (f
					.invoke(this.obj, this.u_limit))) * h / 2;

			T2 = T1 / 2 + h / 2
					* ((Double) (f.invoke(this.obj, this.l_limit + 1 / 2 * h)));
			System.out.println("T1=" + T1);
			System.out.println("T2=" + T2);
			n *= 2;
			h = (this.u_limit - this.l_limit) / n;
			while (n <= count) {
				System.out.println("---------------------");
				double sum = 0d;
				T1 = T2;
				T2 /= 2;
				for (int i = 1; i <= n; i++) {
					sum += (Double) (f.invoke(this.obj, this.l_limit + i * h));
					sum *= (h / 2);
					T2 += sum;
				}
				n *= 2;
				h = (this.u_limit - this.l_limit) / n;
				System.out.println("T1=" + T1);
				System.out.println("T2=" + T2);
			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return T1;
	}

	double getPrecious() {
		return precious;
	}

	void setPrecious(double precious) {
		this.precious = precious;
	}
}
