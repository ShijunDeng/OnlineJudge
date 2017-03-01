package wangshuo.program;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

import javax.swing.JOptionPane;

class Record {
	String str = "";
	int[][] record;
	int count ;

	public Record(int[][] record, int count) {
		this.record = record;
		this.count = count;
	}

	void saveRecord() {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(new File("resource" + File.separator
					+ "properties" + File.separator + "record.txt"), false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String s = "";
			s += (record[0][0] + "\r\n" + record[0][1] + "\r\n" + record[0][2] + "\r\n");
			s += (record[1][0] + "\r\n" + record[1][1] + "\r\n" + record[1][2] + "\r\n");
			s += (record[2][0] + "\r\n" + record[2][1] + "\r\n" + record[2][2] + "\r\n");
			s += (record[3][0] + "\r\n" + record[3][1] + "\r\n" + record[3][2] + "\r\n");
			s += (record[4][0] + "\r\n" + record[4][1] + "\r\n" + record[4][2] + "\r\n");
			s += (count + "\r\n");
			bufferedWriter.write(s);
			bufferedWriter.flush();

			fileWriter.close();
			bufferedWriter.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	void clearRecord() {
		 setData(new int[][]{{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}},0);
		 saveRecord();
	}

	void lookRecord() {
		try {
			FileInputStream fis = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			List<String> ls = new ArrayList<String>();
			String str = "";
			fis = new FileInputStream("resource" + File.separator
					+ "properties" + File.separator + "record.txt");// FileInputStream
			// ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
			isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
			br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new
											// InputStreamReader�Ķ���
			while ((str = br.readLine()) != null) {
				ls.add(str);

			}
			if (ls.size() != 0) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						record[i][j] += Integer.parseInt(ls.get(i * 3 + j));
					}
				}
				count += Integer.parseInt(ls.get(ls.size() - 1));
			}
			saveRecord();
			NumberFormat nt = NumberFormat.getPercentInstance();
			// ���ðٷ�����ȷ��2��������λС��
			nt.setMinimumFractionDigits(2);
			str = "";
			if (count != 0)
				str += ("��������"
						+ count
						+ "����Ϸ    ʤ����"
						+ nt.format((double)(record[0][0] + record[1][0] + record[2][0]
								+ record[3][0] + record[4][0])
								/ count) + "\n");
			else
				str += ("��������"
						+ count
						+ "����Ϸ    ʤ����"
						+ nt.format(0) + "\n");
			str += ("ͬ�� �� ʤ" + record[0][0] + ",ƽ" + record[0][1] + ",��"
					+ record[0][2] + "\n");
			str += ("˳�� �� ʤ" + record[1][0] + ",ƽ" + record[1][1] + ",��"
					+ record[1][2] + "\n");
			str += ("ͬ�� �� ʤ" + record[2][0] + ",ƽ" + record[2][1] + ",��"
					+ record[2][2] + "\n");
			str += ("���� �� ʤ" + record[3][0] + ",ƽ" + record[3][1] + ",��"
					+ record[3][2] + "\n");
			str += ("���ƣ� ʤ" + record[4][0] + ",ƽ" + record[4][1] + ",��"
					+ record[4][2] + "\n");

			JOptionPane.showMessageDialog(null, str, "ͳ�Ƽ�¼",
					JOptionPane.INFORMATION_MESSAGE);
			str = "";
			br.close();
			isr.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void setData(int[][] record, int count) {

		this.record = record;
		this.count = count;
	}

}
