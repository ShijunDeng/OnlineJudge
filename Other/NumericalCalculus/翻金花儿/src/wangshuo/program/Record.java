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
			// 从文件系统中的某个文件中获取字节
			isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
			br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new
											// InputStreamReader的对象
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
			// 设置百分数精确度2即保留两位小数
			nt.setMinimumFractionDigits(2);
			str = "";
			if (count != 0)
				str += ("共进行了"
						+ count
						+ "场游戏    胜出率"
						+ nt.format((double)(record[0][0] + record[1][0] + record[2][0]
								+ record[3][0] + record[4][0])
								/ count) + "\n");
			else
				str += ("共进行了"
						+ count
						+ "场游戏    胜出率"
						+ nt.format(0) + "\n");
			str += ("同花 ： 胜" + record[0][0] + ",平" + record[0][1] + ",负"
					+ record[0][2] + "\n");
			str += ("顺子 ： 胜" + record[1][0] + ",平" + record[1][1] + ",负"
					+ record[1][2] + "\n");
			str += ("同点 ： 胜" + record[2][0] + ",平" + record[2][1] + ",负"
					+ record[2][2] + "\n");
			str += ("对子 ： 胜" + record[3][0] + ",平" + record[3][1] + ",负"
					+ record[3][2] + "\n");
			str += ("杂牌： 胜" + record[4][0] + ",平" + record[4][1] + ",负"
					+ record[4][2] + "\n");

			JOptionPane.showMessageDialog(null, str, "统计记录",
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
