package bag1;
/*
 * �Ը����ַ��жϷ����Ľӿ�
 * @version 0.5 2012-04-12
 * @author XiaoDeng
 */
abstract interface CheckCharacter {
	boolean isNumber(char c);

	boolean isCharacter(char c);

	boolean isOperator(char c);

	boolean isOperator(String s);

	boolean isSeparator(char c);

	boolean isSpace(char c);

	boolean hasNextWords();
}
