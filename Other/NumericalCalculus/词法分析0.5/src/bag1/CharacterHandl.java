package bag1;

/*
 * �ʷ����ַ�����
 * ������ĵ����ַ�ƴ�ɵ���,��������,ֻʣ�±�ʶ���͹ؼ���δ����
 * @version 0.5 2012-04-12
 * @author XiaoDeng
 */
import java.io.File;
import java.io.IOException;

class CharacterHandl implements CheckCharacter {
	// private static final int TWO = 2;//�ڱ��汾�в�����Ҫ
	private ReadData readData = null;
	private boolean hasNextWords = true;

	public CharacterHandl(File f) {
		readData = new ReadData(f);
	}

	public boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	public boolean isCharacter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_';
	}

	public boolean isOperator(char c) {
		switch (c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '&':
		case '!':
		case '|':
		case '%':
		case '>':
		case '<':
		case '=':
		case '#':
		case '^':
		case '~':
		case ':':
			return true;
		}
		return false;

	}

	public boolean isOperator(String s) {

		return s.equals(">=") || s.equals("<=") || s.equals("+=")
				|| s.equals("-=") || s.equals("*=") || s.equals("/=")
				|| s.equals("%=") || s.equals("!=") || s.equals(":=")
				|| s.equals("^=") || s.equals("&=") || s.equals("|=")
				|| s.equals("<<") || s.equals(">>") || s.equals("++")
				|| s.equals("--") || s.equals("&&") || s.equals("||");
	}

	public boolean isSeparator(char c) {
		switch (c) {
		case ',':
		case '.':
		case '{':
		case '}':
		case ';':
		case '(':
		case ')':
		case '[':
		case ']':
			return true;
		}
		return false;
	}

	public boolean isSpace(char c) {
		return c == ' ' || c == '\n';
	}

	public boolean hasNextWords() {
		return hasNextWords;
	}

	Words getNextWords() throws IOException {
		char c = ' ';
		String s = "";
		/*
		 * ��δ���ļ�β����ǰ�������£�������ַ�,����
		 */
		if (false == readData.hasNext()) {
			hasNextWords = false;
			return new Words(Words.ERROR);
		}
		while (readData.hasNext() && isSpace(c)) {
			c = readData.getNextChar();
		}

		/**
		 * ����ĸ(A-Z,a-z,_)
		 */
		if (readData.hasNext() && isCharacter(c)) {
			do {
				s += c;
				c = readData.getNextChar();
			} while (isCharacter(c) || isNumber(c));// ֻҪ��һ���������־���,�������ڲ�Ҫ����
			readData.setToPrevious();// ��Ϊ��Ϊ�жϵ��Ǹ��ַ�Ӧ������û����ĵ�,���������һλ
			return new Words(s, Words.STRING);
		}

		/**
		 * ������(0-9)
		 */
		else if (readData.hasNext() && isNumber(c)) {
			do {
				s += c;
				c = readData.getNextChar();
			} while (isNumber(c) || c == '.');
			readData.setToPrevious();// ��Ϊ��Ϊ�жϵ��Ǹ��ַ�Ӧ������û����ĵ�,���������һλ
			return new Words(s, Words.NUMBER);
		}
		/*
		 * �ǲ�����+,-,*,/,++,--�ȵ�
		 * ˼·�����ڷ���c,����ǡ�-����,���ǽ��������ǲ������֣������־�һֱ�ӵ�s����ָ���䲻�����֣����������������֣�������
		 * ���������������ģ��ǲ������ͼӵ�s�����жϣ��ǲ��Ƕ�Ԫ�ģ��Ǿͱ��棬���ǣ��Ѹոռӽ�ȥ��ɾ��������
		 * ���ڷ���c,���ǡ�-���ţ������ǽ��������ǲ���������������
		 * ���ǲ������ͼӵ�s�����жϣ��ǲ��Ƕ�Ԫ�ģ��Ǿͱ��棬���ǣ��Ѹոռӽ�ȥ��ɾ��������
		 */
		else if (readData.hasNext() && isOperator(c)) {
			s += c;
			if (c == '-') {// ����
				c = readData.getNextChar();
				if (isNumber(c)) {
					while (isNumber(c) || c == '.') {
						s += c;
						c = readData.getNextChar();
					}
					readData.setToPrevious();// ��Ϊ��Ϊ�жϵ��Ǹ��ַ�Ӧ������û����ĵ�,���������һλ
					return new Words(s, Words.NUMBER);// ����һ����Ҫд����NUMBER
				}// if
				else if (isOperator(c)) {// ��Ԫ�������������ʱ���ػ���
					s += c;
					if (isOperator(s)) {// ���֮���Ƕ�Ԫ������
						return new Words(s, Words.OPERATOR);
					} else {// ��������������������Ƕ�Ԫ������
						s = String.valueOf(s.toCharArray()[0]);
						readData.setToPrevious();// ��Ϊ��Ϊ�жϵ��Ǹ��ַ�Ӧ������û����ĵ�,���������һλ
						return new Words(s, Words.OPERATOR);
					}

				} else {// �������֣����ǲ�����
					readData.setToPrevious();// ��Ϊ��Ϊ�жϵ��Ǹ��ַ�Ӧ������û����ĵ�,���������һλ
					return new Words(s, Words.OPERATOR);
				}
			}// if(c=='-')

			else {
				c = readData.getNextChar();
				if (isOperator(c)) {
					s += c;
					if (isOperator(s)) {
						return new Words(s, Words.OPERATOR);
					} else {// ��������������������Ƕ�Ԫ������
						s = String.valueOf(s.toCharArray()[0]);
						readData.setToPrevious();// ��Ϊ��Ϊ�жϵ��Ǹ��ַ�Ӧ������û����ĵ�,���������һλ
						return new Words(s, Words.OPERATOR);
					}
				} else {
					readData.setToPrevious();// ��Ϊ��Ϊ�жϵ��Ǹ��ַ�Ӧ������û����ĵ�,���������һλ
					return new Words(s, Words.OPERATOR);
				}
			}// else

		}

		/*
		 * �ǽ�� , ( ) { }�ȵ�
		 */
		else if (readData.hasNext() && isSeparator(c)) {
			s += c;// ������ر��
			return new Words(s, Words.SEPARATOR);
		}
		/*
		 * �޷�ʶ��ķ���
		 */
		return new Words(Words.ERROR);

	}// getNextWord

}
