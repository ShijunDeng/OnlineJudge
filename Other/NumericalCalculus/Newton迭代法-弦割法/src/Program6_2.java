import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 邓仕军
 * @time 2012-06-07
 * @version 0.1
 * @function:Newton迭代法-弦割法
 * 
 */
class Program6_2 {

	Method f;
	double a, b;
	double precious;

	public Program6_2(Method f, double a, double b, double precious) {
		this.f = f;
		this.a = a;
		this.b = b;
		this.precious = precious;
	}

	public double function() {
		double Xk0 = this.a, Xk1 = this.b, Xk2 = this.b;
		try {
			Xk2 = Xk1
					- (Double) this.f.invoke(null, Xk1)
					/ (((Double) this.f.invoke(null, Xk1) - (Double) this.f
							.invoke(null, Xk0)) / (Xk1 - Xk0));
			Xk0 = Xk1;
			Xk1 = Xk2;
			Xk2 = Xk1
					- (Double) this.f.invoke(null, Xk1)
					/ (((Double) this.f.invoke(null, Xk1) - (Double) this.f
							.invoke(null, Xk0)) / (Xk1 - Xk0));
			while (Math.abs(Xk2 - Xk1) > this.precious) {
				Xk0 = Xk1;
				Xk1 = Xk2;
				Xk2 = Xk1
						- (Double) this.f.invoke(null, Xk1)
						/ (((Double) this.f.invoke(null, Xk1) - (Double) this.f
								.invoke(null, Xk0)) / (Xk1 - Xk0));
			}// while
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return (Xk1 + Xk2) / 2;
	}// function

	public double getPrecious() {
		return precious;
	}

	public void setPrecious(double precious) {
		this.precious = precious;
	}

}
