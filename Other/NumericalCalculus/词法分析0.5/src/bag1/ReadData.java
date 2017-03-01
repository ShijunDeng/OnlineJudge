package bag1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * 读数据：只要知道一个File对象，便可以读书数据,返回单个字符
 * @version 0.5 2012-04-12
 * @author XiaoDeng
 */
class ReadData {

	private char data;//读到的数据
	private boolean isEnd;//是否结束
	private static final int TAG=100;//IO中mark用到的
	private BufferedInputStream bin;//流

	public ReadData(File f) {
		try {
			bin = new BufferedInputStream(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.data = ' ';
		this.isEnd = false;
	}

	char getNextChar() throws IOException {
		int read = -1;
		bin.mark(TAG);
		if ((read = bin.read()) == -1) {
			isEnd = true;
			return ' ';
		} else {
			data = (char) read;	
			return data;
		}

	}

	boolean hasNext() {
		return isEnd==false;
	}

	void setToPrevious() {
		try {
			bin.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

/*	public static void main(String []args) throws IOException{
		ReadData rea=new ReadData(new File("G:"+File.separator+"Users"+File.separator+"hp"+File.separator+"workspace"+File.separator+"词法分析"+File.separator+"资源"+File.separator+"测试.txt"));
		System.out.println(rea.getNextChar());
		System.out.println(rea.getNextChar());
		System.out.println(rea.getNextChar());
		System.out.println(rea.getNextChar());
		rea.setToPrevious( );
		System.out.println(rea.getNextChar());
		System.out.println(rea.getNextChar());
		System.out.println(rea.getNextChar());
		System.out.println(rea.getNextChar());
	}*/

}
