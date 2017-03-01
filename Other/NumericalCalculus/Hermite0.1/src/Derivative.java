import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *@author 邓仕军
 *@version 0.1
 *@time 2012-05-03
 * Derivative:求一个函数的导数，运用反射机制
 */
class Derivative {
	Method method;
	Object obj;
	double Dx = 10E-4;// 增量 △X
	double precision = 10E-10;// 精度

	public Derivative(Object obj, Method f) {
		this.method = f;
		this.obj = obj;
	}

	strictfp double getDerivative(double x) {
		double deriva1 = 0d, deriva2 = 0d;
		boolean flag = true;
		double dx = this.Dx;
		try {
			deriva1 = ((Double) this.method.invoke(obj, x + dx) - (Double) method
					.invoke(obj, x)) / dx;
			dx /= 2;
			while (flag) {
				deriva1 = ((Double) this.method.invoke(obj, x + dx) - (Double) method
						.invoke(obj, x)) / dx;
				if (Math.abs(deriva1 - deriva2) <= this.precision&&Math.abs(dx)<= this.precision)
					flag = false;
				else {
					deriva2 = deriva1;
					dx /= 2;
				}
			}// while

		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		return (deriva1 + deriva2) / 2;

	}// getDerivative

	public double getDx() {
		return Dx;
	}

	public void setDx(double dx) {
		Dx = dx;
	}

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}
}
