/*@author ���˾�
 * time��2012-04-14
 * ��������,���дʷ�����
 */
public class LexicalAnalysis {
	MyStack analyseStack;// ����ջ
	MyStack inputStack;// �����ַ���ջ
	ParseList parseList;// ������
	String sAnalysis;// �ַ���Ҫ��������
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
		if (read.indexOf("#") < 0)// ��ֹ�û�û�����롰#��
			read += "#";
		else
			read = read.substring(0, read.indexOf("#") + 1);// ��#������ľͲ�Ҫ��

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
		String key = "";// �����ڷ�������ȡֵ��key
		String value = "";// �����ڷ�������ȡkey��Ӧ��ֵ
		analyseStack.push("#");
		analyseStack.push(h.getGramStart());// �ķ���ʼ��
		int step = 1;
		toString += "����";
	
		toString += "\t";
		toString += "����ջ";
	
		toString += "\t";
		toString += "ʣ���ַ���";
	
		toString += "\t";
		toString += "�Ƶ����ò���ʽ��ƥ��\r\n";
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
					toString += ("����:" + analyseStack.peek() + "��"
							+ inputStack.peek() + "��û�ж�Ӧ����ʽ");					 
					return;
				}

			}
			 
			
			toString += (analyseStack.peek() + "->" + value + "\r\n");
			if (value.equals("$") == false) {
				analyseStack.pop();
				analyseStack.push(value);
				value = "";// ���
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
				toString += ("\t"+inputStack.pop() + "ƥ��ɹ���\r\n");
				if (analyseStack.getLength() == inputStack.getLength()
						&& analyseStack.getLength() == 0) {
					toString += ("����ƥ��ɹ���\r\n");
					return;
				}
			}
			step++;
		}// while
		toString += inputStack.toString();
		toString += "ƥ��ʧ�ܣ�";
	}// startAnalyse()

	/*
	 * public static void main(String[] args) { LexicalAnalysis q = new
	 * LexicalAnalysis(); q.getData(); q.startAnalyse(); }
	 */
}// �����

