import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author ���˾�
 * @time 2012-05-31
 * @version0.1
 * @function: ���Զಽ����Adams��ʽ��⹫ʽ ˵������΢�ַ�����ֵ�ⷨ-�Ľ���ŷ����ʽ(Ԥ��-У����Ƕ�빫ʽ��ƽ������ʽ)
 *            ���ǰ����ֵ������֪��һ��ֵ
 */
class Adams {
	Method f;
	double u_limit;
	double l_limit;
	double[][] result;// ���ֵ��
	double x0, y0;// ��ֵ
	double h;// ����

	public Adams(Method f, double l_limit, double u_limit, double x0,
			double y0, double h) {
		this.f = f;
		this.l_limit = l_limit;
		this.u_limit = u_limit;
		this.x0 = x0;
		this.y0 = y0;
		this.h = h;
		// ------���---��ʼ��result�����,(x0,y0)Ҳ��������---------------
		result = new double[(int) ((u_limit - l_limit) / h) + 1][2];
		result[0][0] = x0;
		result[0][1] = y0;
	}

	// -----------���----Ԥ����������--------------------------
	strictfp double[][] functionA() {
		int n = (int) ((this.u_limit - this.l_limit) / this.h) + 1;
		for (int i = 1; i < n; i++) {
			double temp = 0d;
			this.result[i][0] = this.x0 + i * this.h;
			try {
				if (i < 4) {
					temp = this.result[i - 1][1]
							+ this.h
							* ((Double) f.invoke(null, this.result[i - 1][0],
									this.result[i - 1][1]));
					this.result[i][1] = this.result[i - 1][1]
							+ this.h
							* ((Double) f.invoke(null, this.result[i][0], temp));
				} else {// �߱�ǰ�ĸ�ֵ��
					temp = this.result[i - 1][1]
							+ this.h
							/ 24
							* (55 * this.result[i - 1][1] - 59
									* this.result[i - 2][1] + 37
									* this.result[i - 3][1] - 9 * this.result[i - 4][1]);
					this.result[i][1] = this.result[i - 1][1]
							+ this.h
							/ 24
							* (9 * temp + 19 * this.result[i - 1][1] - 5
									* this.result[i - 2][1] + this.result[i - 3][1]);
				}
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

	// -----------���-----Ƕ�빫ʽ--------------------------
	strictfp double[][] functionB() {
		int n = (int) ((this.u_limit - this.l_limit) / this.h) + 1;
		for (int i = 1; i < n; i++) {
			double temp = 0d;
			this.result[i][0] = this.x0 + i * this.h;

			try {
				if (i < 4) {
					this.result[i][1] = this.result[i - 1][1]
							+ this.h
							/ 2
							* ((Double) f.invoke(null, this.result[i - 1][0],
									this.result[i - 1][1])
									+ (Double) f.invoke(null,
											this.result[i][0],
											this.result[i - 1][1]) + this.h
									* (Double) f.invoke(null,
											this.result[i - 1][0],
											this.result[i - 1][1]));
				} else {
					temp = this.result[i - 1][1]
							+ this.h
							/ 24
							* (55 * this.result[i - 1][1] - 59
									* this.result[i - 2][1] + 37
									* this.result[i - 3][1] - 9 * this.result[i - 4][1]);
					this.result[i][1] = this.result[i - 1][1]
							+ this.h
							/ 24
							* (9 * temp + 19 * this.result[i - 1][1] - 5
									* this.result[i - 2][1] + this.result[i - 3][1]);
				}
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

	// -------------���----ƽ������ʽ--------------------------
	strictfp double[][] functionC() {
		int n = (int) ((this.u_limit - this.l_limit) / this.h) + 1;
		for (int i = 1; i < n; i++) {
			double Yp = 0d, Yc = 0d;// Yp
			double temp = 0d;
			this.result[i][0] = this.x0 + i * this.h;
			try {
				if (i < 4) {
					Yp = this.result[i - 1][1]
							+ this.h
							* ((Double) f.invoke(null, this.result[i - 1][0],
									this.result[i - 1][1]));
					Yc = this.result[i - 1][1] + this.h
							* ((Double) f.invoke(null, this.result[i][0], Yp));
					this.result[i][1] = (Yp + Yc) / 2;
				} else {
					temp = this.result[i - 1][1]
							+ this.h
							/ 24
							* (55 * this.result[i - 1][1] - 59
									* this.result[i - 2][1] + 37
									* this.result[i - 3][1] - 9 * this.result[i - 4][1]);
					this.result[i][1] = this.result[i - 1][1]
							+ this.h
							/ 24
							* (9 * temp + 19 * this.result[i - 1][1] - 5
									* this.result[i - 2][1] + this.result[i - 3][1]);
				}
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
		System.out.printf("%8s", " Xȡֵ:");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12.5f", result[i][0]);
		}
		System.out.println();
		System.out.println();
		// -----------------Ԥ��-------У��----------
		for (int i = 0; i < n; i++) {
			if (i == (int) (n / 2 - 1))
				System.out.printf("%12s", "Adams---Ԥ��---У��");
			else
				System.out.printf("%12s", "-------------");
		}
		System.out.println();

		System.out.printf("%8s", "y=f(x)");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12.5f", result[i][1]);
		}
		System.out.println();

		// -----------------Ƕ�빫ʽ----------
		this.functionB();
		for (int i = 0; i < n; i++) {
			if (i == (int) (n / 2 - 1))
				System.out.printf("%12s", "Adams---��Ƕ�빫ʽ-");
			else
				System.out.printf("%12s", "-------------");
		}
		System.out.println();

		System.out.printf("%8s", "y=f(x)");
		for (int i = 0; i < n; i++) {
			System.out.printf("%12.5f", result[i][1]);
		}
		System.out.println();

		// -----------------ƽ������ʽ----------
		this.functionC();
		for (int i = 0; i < n; i++) {
			if (i == (int) (n / 2 - 1))
				System.out.printf("%12s", "Adams---ƽ������ʽ");
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
