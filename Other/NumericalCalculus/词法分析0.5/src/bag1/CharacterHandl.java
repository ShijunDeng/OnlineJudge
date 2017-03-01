package bag1;

/*
 * 词法分字符处理：
 * 将送入的单个字符拼成单词,初步处理,只剩下标识符和关键字未处理
 * @version 0.5 2012-04-12
 * @author XiaoDeng
 */
import java.io.File;
import java.io.IOException;

class CharacterHandl implements CheckCharacter {
	// private static final int TWO = 2;//在本版本中不再需要
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
		 * 在未到文件尾部的前提条件下，处理空字符,换行
		 */
		if (false == readData.hasNext()) {
			hasNextWords = false;
			return new Words(Words.ERROR);
		}
		while (readData.hasNext() && isSpace(c)) {
			c = readData.getNextChar();
		}

		/**
		 * 是字母(A-Z,a-z,_)
		 */
		if (readData.hasNext() && isCharacter(c)) {
			do {
				s += c;
				c = readData.getNextChar();
			} while (isCharacter(c) || isNumber(c));// 只要第一个不是数字就行,所以现在不要紧了
			readData.setToPrevious();// 因为作为判断的那个字符应该算作没处理的的,标记往回设一位
			return new Words(s, Words.STRING);
		}

		/**
		 * 是数字(0-9)
		 */
		else if (readData.hasNext() && isNumber(c)) {
			do {
				s += c;
				c = readData.getNextChar();
			} while (isNumber(c) || c == '.');
			readData.setToPrevious();// 因为作为判断的那个字符应该算作没处理的的,标记往回设一位
			return new Words(s, Words.NUMBER);
		}
		/*
		 * 是操作符+,-,*,/,++,--等等
		 * 思路：对于符号c,如果是‘-’号,考虑接下来的是不是数字，是数字就一直加到s里面指导其不是数字，若接下来不是数字，考虑是
		 * 操作符还是其他的，是操作符就加到s，再判断，是不是二元的，是就保存，不是，把刚刚加进去的删除，回设
		 * 对于符号c,不是‘-’号，考虑是接下来的是操作符还是其他的
		 * ，是操作符就加到s，再判断，是不是二元的，是就保存，不是，把刚刚加进去的删除，回设
		 */
		else if (readData.hasNext() && isOperator(c)) {
			s += c;
			if (c == '-') {// 负数
				c = readData.getNextChar();
				if (isNumber(c)) {
					while (isNumber(c) || c == '.') {
						s += c;
						c = readData.getNextChar();
					}
					readData.setToPrevious();// 因为作为判断的那个字符应该算作没处理的的,标记往回设一位
					return new Words(s, Words.NUMBER);// 这里一定不要写错了NUMBER
				}// if
				else if (isOperator(c)) {// 二元操作符情况：此时不必回设
					s += c;
					if (isOperator(s)) {// 组合之后是二元操作符
						return new Words(s, Words.OPERATOR);
					} else {// 两个操作符组合起来不是二元操作符
						s = String.valueOf(s.toCharArray()[0]);
						readData.setToPrevious();// 因为作为判断的那个字符应该算作没处理的的,标记往回设一位
						return new Words(s, Words.OPERATOR);
					}

				} else {// 不是数字，不是操作符
					readData.setToPrevious();// 因为作为判断的那个字符应该算作没处理的的,标记往回设一位
					return new Words(s, Words.OPERATOR);
				}
			}// if(c=='-')

			else {
				c = readData.getNextChar();
				if (isOperator(c)) {
					s += c;
					if (isOperator(s)) {
						return new Words(s, Words.OPERATOR);
					} else {// 两个操作符组合起来不是二元操作符
						s = String.valueOf(s.toCharArray()[0]);
						readData.setToPrevious();// 因为作为判断的那个字符应该算作没处理的的,标记往回设一位
						return new Words(s, Words.OPERATOR);
					}
				} else {
					readData.setToPrevious();// 因为作为判断的那个字符应该算作没处理的的,标记往回设一位
					return new Words(s, Words.OPERATOR);
				}
			}// else

		}

		/*
		 * 是界符 , ( ) { }等等
		 */
		else if (readData.hasNext() && isSeparator(c)) {
			s += c;// 不用设回标记
			return new Words(s, Words.SEPARATOR);
		}
		/*
		 * 无法识别的符号
		 */
		return new Words(Words.ERROR);

	}// getNextWord

}
