package bag1;
/*
 * 字符串+身份
 * @version 0.5 2012-04-12
 * @author XiaoDeng
 */
class Words {

	public static final int STRING=1;
	public static final int NUMBER=2;
	public static final int OPERATOR=3;
	public static final int SEPARATOR=4;
	public static final int ERROR=-1;
	private String word;
	private int ID;
	
	public Words(String s, int iD) {
		this.word = s;
		ID = iD;
	}
	
	public Words( int iD) {
		this.word = "Error:无法识别";
		ID = iD;
	}

	String getWord() {
		return word;
	}

	 
	int getID() {
		return ID;
	}

	 
	
}
