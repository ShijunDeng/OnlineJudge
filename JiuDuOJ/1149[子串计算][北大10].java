import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
/**
 * @author xiaodeng wust_dengshijun@163.com
 * @version 1.1 <br/>
 *          website:<a href="http://www.dengshijun.icoc.cc/">xiaodeng</a> <br>
 *          time:2015-02-25 Copyright (C),2012-2015,xiaodeng <br>
 *          This program is protected by xiaodeng
 *
 *	��Ŀ1149���Ӵ�����
 *	ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��918�����512
 *	��Ŀ������
 *	����һ��01�ַ��������Ȳ�����100��������ÿһ���Ӵ����ֵĴ�����
 *	���룺
 *	����������У�ÿ��һ���ַ�����
 *	�����
 *	��ÿ���ַ�������������г��ִ�����1�����ϵ��Ӵ�������Ӵ����ֵĴ�����������ֵ�������
 *	�������룺
 *	10101
 *	���������
 *	0 2
 *	01 2
 *	1 3
 *	10 2
 *	101 2
 *	��Դ��
 *	2010�걱����ѧ������о�����������
 *	���ɣ�
 *	������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7872-1-1.html
 */

public class Main {

	private Map<String, Integer> subStr;

	public Main() {
		subStr = new TreeMap<String, Integer>();
	}

	public void countSubStr(String str) {
		String sub;
		subStr.clear();//����Ҫ
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				sub = str.substring(i, j);
				if (subStr.get(sub) == null) {
					subStr.put(sub, 1);
				} else {
					subStr.put(sub, subStr.get(sub) + 1);
				}

			}
		}

		for (Map.Entry<String, Integer> e : subStr.entrySet()) {
			if (e.getValue() > 1) {
				System.out.println(e.getKey() + " " + e.getValue());
			}
		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Main ma = new Main();
		while (sc.hasNext()) {
			String str = sc.next();
			ma.countSubStr(str);
		}
	}

}
