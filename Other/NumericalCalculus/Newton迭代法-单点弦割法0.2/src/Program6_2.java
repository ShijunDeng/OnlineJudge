import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ���˾�
 * @time 2012-06-07
 * @version 0.2
 * @function:Newton������-�����Ҹ(���Ƕ����з������ã�Ҫ������)���̶�a��
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
		double Xk1 = this.b, Xk2 = 0;
		try {
			Xk2 = Xk1
					- (Double) this.f.invoke(null, Xk1)
					/ (((Double) this.f.invoke(null, Xk1) - (Double) this.f
							.invoke(null, this.a)) / (Xk1 - this.a));
			Xk1 = Xk2;
			Xk2 = Xk1
					- (Double) this.f.invoke(null, Xk1)
					/ (((Double) this.f.invoke(null, Xk1) - (Double) this.f
							.invoke(null, this.a)) / (Xk1 - this.a));
			while (Math.abs(Xk2 - Xk1) > this.precious) {
				Xk1 = Xk2;
				Xk2 = Xk1
						- (Double) this.f.invoke(null, Xk1)
						/ (((Double) this.f.invoke(null, Xk1) - (Double) this.f
								.invoke(null, this.a)) / (Xk1 - this.a));
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
