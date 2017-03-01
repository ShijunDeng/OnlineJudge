/**
 * @author 邓仕军
 * @time 2012-06-07
 * @version 0.2
 * Newton迭代法
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Program6_2 {

	Method f;
	double x0;
	double precious;
	Derivative derivaFx;// 导数

	public Program6_2(Method f, double x0, double precious) {
		this.f = f;
		this.x0 = x0;
		this.precious = precious;
		derivaFx = new Derivative(this, this.f);
		derivaFx.setPrecision(this.precious);
	}

	public double function() {
		double Xk = 0d, Xk1 = 0d;
		try {
			Xk = this.x0 - (Double) this.f.invoke(null, this.x0)
					/ this.derivaFx.getDerivative(this.x0);
			Xk1 = Xk - (Double) this.f.invoke(null, Xk)
					/ this.derivaFx.getDerivative(Xk);
			while (Math.abs(Xk - Xk1) > this.precious) {
				Xk = Xk1;
				Xk1 = Xk - (Double) this.f.invoke(null, Xk)
						/ this.derivaFx.getDerivative(Xk);
			}// while
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return (Xk + Xk1) / 2;
	}// function

	public double getX0() {
		return x0;
	}

	public void setX0(double x0) {
		this.x0 = x0;
	}

	public double getPrecious() {
		return precious;
	}

	public void setPrecious(double precious) {
		this.precious = precious;
	}

}
