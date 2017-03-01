/*@author 邓仕军
 * time：2012-04-14
 * 读入数据,进行词法分析
 */
public class LexicalAnalysis {
	MyStack analyseStack;// 分析栈
	MyStack inputStack;// 输入字符串栈
	ParseList parseList;// 分析表
	String sAnalysis;// 字符串要被分析的
	String toString;
	CharacterHandl h;

	public LexicalAnalysis(CharacterHandl h, String s) {
		analyseStack = new MyStack();
		inputStack = new MyStack();
		this.h = h;
		parseList = new ParseList(h);
		toString = "";
		sAnalysis = s;
	}

	private void getData() {
		String read = sAnalysis.trim();
		if (read.indexOf("#") < 0)// 防止用户没有输入“#”
			read += "#";
		else
			read = read.substring(0, read.indexOf("#") + 1);// “#”后面的就不要了

		int length = read.length();

		while (length > 0) {
			String temp = read.substring(length - 1, length);
			inputStack.push(temp);
			length--;
		}

	}// getData()

	String getToString() {
		return toString;
	}

	public void startAnalyse() {
		getData();
		String key = "";// 用来在分析表中取值的key
		String value = "";// 用来在分析表中取key对应的值
		analyseStack.push("#");
		analyseStack.push(h.getGramStart());// 文法开始符
		int step = 1;
		toString += "步骤";
	
		toString += "\t";
		toString += "分析栈";
	
		toString += "\t";
		toString += "剩余字符串";
	
		toString += "\t";
		toString += "推导所用产生式或匹配\r\n";
		while (analyseStack.getLength() > 0) {
			toString += step;
			toString += "\t";
			toString += analyseStack.toString();
			
			toString += "\t";
			toString += (inputStack.toString());
			
			toString += "\t";
			key = analyseStack.peek() + inputStack.peek();
			value = parseList.get(key);

			if (value == null || true == value.equals("")) {
				if (h.getmFirst().get(analyseStack.peek())!=null&&h.getmFirst().get(analyseStack.peek()).exists("$")) {
					analyseStack.pop();
					value="$";
				} else {
					toString += ("错误:" + analyseStack.peek() + "在"
							+ inputStack.peek() + "下没有对应产生式");					 
					return;
				}

			}
			 
			
			toString += (analyseStack.peek() + "->" + value + "\r\n");
			if (value.equals("$") == false) {
				analyseStack.pop();
				analyseStack.push(value);
				value = "";// 清空
			} else {
				analyseStack.pop();
			}
			while (analyseStack.peek().equals(inputStack.peek())) {
				step++;
				toString += step;
				toString += "\t";
				toString += analyseStack.toString();
				toString += "\t";
				toString += inputStack.toString();
				analyseStack.pop();
				toString += ("\t"+inputStack.pop() + "匹配成功！\r\n");
				if (analyseStack.getLength() == inputStack.getLength()
						&& analyseStack.getLength() == 0) {
					toString += ("所有匹配成功！\r\n");
					return;
				}
			}
			step++;
		}// while
		toString += inputStack.toString();
		toString += "匹配失败！";
	}// startAnalyse()

	/*
	 * public static void main(String[] args) { LexicalAnalysis q = new
	 * LexicalAnalysis(); q.getData(); q.startAnalyse(); }
	 */
}// 类结束

