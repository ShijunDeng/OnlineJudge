package bag1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * �����ݣ�ֻҪ֪��һ��File���󣬱���Զ�������,���ص����ַ�
 * @version 0.5 2012-04-12
 * @author XiaoDeng
 */
class ReadData {

	private char data;//����������
	private boolean isEnd;//�Ƿ����
	private static final int TAG=100;//IO��mark�õ���
	private BufferedInputStream bin;//��

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
		ReadData rea=new ReadData(new File("G:"+File.separator+"Users"+File.separator+"hp"+File.separator+"workspace"+File.separator+"�ʷ�����"+File.separator+"��Դ"+File.separator+"����.txt"));
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
