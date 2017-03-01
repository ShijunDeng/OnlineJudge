import java.lang.reflect.Method;
import java.util.Arrays;

/*
 * @author 邓仕军
 * @time2012-05-17
 *  Romberg
 */
class Program4_2 {
	int length = 10;
	static final int TWO = 2;
	static final int LISTINCREMENT = 10;//申请空间增量
	double[] data = new double[length];
	Program4_1 T;
	double precious = 0.0000001d;

	public Program4_2(double l_limit, double u_limit, Method f,
			double precious, Object obj) {
		this.T = new Program4_1(l_limit,u_limit,f,precious,obj);
		this.precious = precious;// 精度
	}

	double function() {
		//int exp = 1;
		int n = 1;
		double temp1 = T.function(n), temp2 = T.function(n * 2);
		double pre = Math.abs(temp1 - temp2);
		while (pre > this.precious) {
			if(n>this.length-1){//空间不够，重新分配
				this.data=Arrays.copyOf(this.data, this.length+Program4_2.LISTINCREMENT);
				 this.length+=Program4_2.LISTINCREMENT;
			}
			for (int i = 0; i <= n; i++) {
				if (i <n) {
					pre = Math.abs(temp1 - temp2);
					temp1 = data[i];
				}
				data[i] = temp2;
				if (i <n) {
					temp2 = Math.pow(2, i + 1) / (Math.pow(2, i + 1) - 1)
							* temp2 - 1 / (Math.pow(2, i + 1) - 1) * temp1;
				}
				System.out.println(data[i]);
			}//for
			n++;
			temp2=T.function((int)Math.pow(2, n));
			System.out.println("-----------------------------------");
		}//while
		return data[n-1];
	}
}
