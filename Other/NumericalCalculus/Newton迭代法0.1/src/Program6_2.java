import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Program6_2 {

	Method f;
	double x0;
	int count;
	int K;
	double precious;
	Derivative derivaFx;// 导数

	public Program6_2(Method f, double x0, int count, double precious) {
		this.f = f;
		this.x0 = x0;
		this.count = count;
		this.precious = precious;
		derivaFx = new Derivative(this, this.f);
		derivaFx.setPrecision(this.precious);
	}

	/**
	 * @return:如果x0的值使得C1*C2=0,返回false,其他情况返回true
	 */
	public boolean function() {
		int k = 1;
		double C1 = 0d, C2 = 0d;
		double x = 0d, DT = 0d;
		try {
			while (k <= this.count) {
				C1 = (Double) f.invoke(null, this.x0);
				C2 = (Double) derivaFx.getDerivative(this.x0);

				// 这行代码的位置一定要放对地方
				this.K = k;

				if (Math.abs(C1 * C2) < this.precious) {
					return false;
				} else {
					x = this.x0 - C1 / C2;
				}
				if (Math.abs(x) <= 1) {
					DT = Math.abs(x - x0);
				} else {
					DT = Math.abs((x - x0) / x);
				}

				if (DT < this.precious) {
					return true;
				}
				this.x0 = x;
				k++;

			}// while
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return true;
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

	public int getK() {
		return K;
	}
}
