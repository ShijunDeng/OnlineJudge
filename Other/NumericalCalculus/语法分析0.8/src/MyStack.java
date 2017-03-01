
import java.util.ArrayList;
import java.util.List;
/*
 * @author ���˾�
 *  time��2012-04-14
 *  ʵ��һ��ջ����ջ��ʱ������Զ�ʶ��'��,���ҿ��Դ�ӡջ�е�Ԫ�أ�����������stackһ��
 */
class MyStack {

	List<String> stack;

	public MyStack() {
		stack = new ArrayList<String>();
	}

	public String pop() {
		String re;
		re = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return re;
	}

	public void push(String e) {
		char ch[] = e.toCharArray();
		String push = "";
		for (int i = ch.length-1; i >=0; i--) {
			push = String.valueOf(ch[i]);
			if (i-1>=0 && ch[i] == '\'') {// ��ĸ������"'"����͸���ĸ��Ϊһ��������ջ
				push= String.valueOf(ch[i -1])+push;
				i--;//��Ҫ����
			}
			if (false == push.equals(""))
				stack.add(push);

			push = "";//���
		}

	}

	public int getLength() {
		return stack.size();
	}
	public String peek() {
		return stack.get(stack.size() - 1);
	}

	public String toString() {
		String re = "";
		for (String e : stack)
			re += e;
		return re;
	}
	
	
	/*
	 * 
	 * public static void main(String[] args) { 
	 * MyStack s = new MyStack();
	 * String ss = "E'F'G"; String s2 = "YA'"; s.push("MN"); s.push(ss);
	 * s.push(s2); System.out.println(s.toString());
	 * System.out.println(s.peek()); System.out.println(s.pop());
	 * System.out.println(s.pop()); System.out.println(s.pop());
	 * System.out.println(s.pop()); System.out.println(s.pop());
	 * System.out.println(s.pop()); System.out.println(s.pop());
	 * 
	 * }
	 */
}
