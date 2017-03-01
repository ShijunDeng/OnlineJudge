
import java.util.ArrayList;
import java.util.List;
/*
 * @author 邓仕军
 *  time：2012-04-14
 *  实现一个栈：入栈的时候可以自动识别“'”,并且可以打印栈中的元素，其他功能与stack一样
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
			if (i-1>=0 && ch[i] == '\'') {// 字母后面是"'"，则和该字母视为一个整体入栈
				push= String.valueOf(ch[i -1])+push;
				i--;//不要忘记
			}
			if (false == push.equals(""))
				stack.add(push);

			push = "";//清空
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
