/*数组中只出现一次的数字
时间限制：1秒 空间限制：32768K 热度指数：7640
本题知识点： 数组
 算法知识视频讲解
题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
*/

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
	public int getFirstOneBit(int x) {
		return x & (~(x - 1));
	}

	public void FindTwoNumsAppearOnce(int[] array, int num1[], int num2[]) {
		int aXORb = 0;
		int a = 0;
		int b = 0;
		for (int x : array) {
			aXORb ^= x;
		}
		int firstOnebit = getFirstOneBit(aXORb);
		for (int x : array) {
			if ((x&firstOnebit) != 0) {
				a ^= x;
			}
		}
		b = aXORb ^ a;

		num1[0] = a;
		num2[0] = b;
	}

	public void FindThreeoNumsAppearOnce(int[] array, int num1[], int num2[], int num3[]) {
		int aXORbXORc = 0;
		int a = 0;
		int abcFirstOneBit = 0;
		for (int x : array) {
			aXORbXORc ^= x;
		}
		for (int x : array) {
			abcFirstOneBit ^= getFirstOneBit(aXORbXORc ^ x);
		}

		int firstOnebit = getFirstOneBit(abcFirstOneBit);
		for (int x : array) {
			if (getFirstOneBit(x ^ aXORbXORc) == firstOnebit) {
				a ^= x;
			}
		}
		num1[0] = a;
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = a;		
		FindTwoNumsAppearOnce(array, num2, num3);
	}	
	
	public void test1() {
		int[] array= { 2, 5, 8, 2, 5, 8, 7, 1};
		int[][] x = new int[2][1];
		FindTwoNumsAppearOnce(array, x[0], x[1]);
		System.out.printf("%d %d\n", x[0][0], x[1][0]);
	}	
	@Test
	public void test2() {
		int[] array= { 2, 5, 8, 2, 5, 8, 6, 7, 1 };
		int[][] x = new int[3][1];
		FindThreeoNumsAppearOnce(array, x[0], x[1], x[2]);
		System.out.printf("%d %d %d\n", x[0][0], x[1][0], x[2][0]);
	}
}
