package bag1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ClassifyWords {

	CharacterHandl charHandl = null;
	List<String> keyWords = new ArrayList<String>();// 存入关键字(保留字)
	List<String> identifiers = new ArrayList<String>();// 存入标识符
	List<String> separator = new ArrayList<String>();// 存入分界符
	List<String> operator = new ArrayList<String>();// 存入运算符
	List<String> number = new ArrayList<String>();// 存入数
	private static final String LINEFEED="\r\n";
	static String akeyWords[] = { "begin", "call", "const", "do", "end", "if",
			"odd", "procedure", "read", "then", "var", "while", "write" };// 保留字表
	String sK = "";//存储keyWords中遍历出来的内容，以下类似
	String sI = "";//注意不用null，因为null也会被写进去
	String sO = "";
	String sS = "";
	String sN = "";
	
	public ClassifyWords(File f) {
		charHandl = new CharacterHandl(f);
	}

	String getsK() {
		return sK;
	}

	String getsI() {
		return sI;
	}

	String getsO() {
		return sO;
	}

	String getsS() {
		return sS;
	}

	String getsN() {
		return sN;
	}

	List<String> getKeyWords() {
		return keyWords;
	}

	List<String> getIdentifiers() {
		return identifiers;
	}

	List<String> getSeparator() {
		return separator;
	}

	List<String> getOperator() {
		return operator;
	}

	List<String> getNumber() {
		return number;
	}

	void classify() {
		Words words=null;
		String getWords = null;
		while (charHandl.hasNextWords()) {
			try {
				words = charHandl.getNextWords();
				getWords = words.getWord();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.println(words==null);
			
			switch (words.getID()) {
			case Words.STRING:

				if (isKeyWords(getWords)) {
					keyWords.add(getWords);
				} else {
					identifiers.add(getWords);
				}
				break;

			case Words.NUMBER:
				number.add(getWords);
				break;

			case Words.OPERATOR:

				operator.add(getWords);

				break;
			case Words.SEPARATOR:
				separator.add(getWords);
				break;
			case Words.ERROR:
				break;
			}// switch
		}// while
	}// classify

	/**
	 * 将处理结果写到文件中去
	 * 步骤：
	 * 新建文件夹 result-->建立keyWords,number,identifiers,operator,separator文本文件,并存储对应容器中的结果
	 */
	void writeIntoFile(){
		File storeFile=new File("result");
		
		if(false==storeFile.exists()){
			storeFile.mkdir();
		}
		try {
			FileWriter fw_keyWords=new FileWriter(storeFile.getPath()+File.separator+"keyWords.txt",false);
			FileWriter fw_identifiers=new FileWriter(storeFile.getPath()+File.separator+"identifiers.txt",false);
			FileWriter fw_operator=new FileWriter(storeFile.getPath()+File.separator+"operator.txt",false);
			FileWriter fw_separator=new FileWriter(storeFile.getPath()+File.separator+"separator.txt",false);
			FileWriter fw_number=new FileWriter(storeFile.getPath()+File.separator+"number.txt",false);
			
			BufferedWriter bfw_keyWords=new BufferedWriter(fw_keyWords);
			BufferedWriter bfw_identifiers=new BufferedWriter(fw_identifiers);
			BufferedWriter bfw_operator=new BufferedWriter(fw_operator);
			BufferedWriter bfw_separator=new BufferedWriter(fw_separator);
			BufferedWriter bfw_number=new BufferedWriter(fw_number);
			
			for (String s : keyWords)
				sK+=(s+LINEFEED);				 
			for (String s : identifiers)
				sI+=(s+LINEFEED);
 			for (String s : number)
				sN+=(s+LINEFEED);
 			for (String s : operator)
				sO+=(s+LINEFEED);
 			for (String s : separator)
				sS+=(s+LINEFEED);
 			bfw_keyWords.write(sK);
 			bfw_identifiers.write(sI);
 			bfw_operator.write(sO);
 			bfw_separator.write(sS);
 			bfw_number.write(sN);
 			
 			bfw_keyWords.close();
 			bfw_identifiers.close();
 			bfw_operator.close();
 			bfw_separator.close();
 			bfw_number.close();
 			
 			fw_keyWords.close();
 			fw_identifiers.close();
 			fw_operator.close();
 			fw_separator.close();
 			fw_number.close();

 		} catch (IOException e) {
			e.printStackTrace();
		}
	}//writeIntoFile
	
	
	/**
	 * 判断是否为关键字
	 * 
	 * @param s
	 * @return 是保留字返回true否则返回false
	 */
	boolean isKeyWords(String words) {
		for (String s : akeyWords)
			if (words.equals(s))
				return true;
		return false;
	}

	
	/*public static void main(String[] args) throws IOException {
		ClassifyWords rea = new ClassifyWords(new File("资源"+File.separator+"测试.txt"));
		rea.classify();
		for (String s : rea.keyWords)
			System.out.println(s);
		for (String s : rea.identifiers)
			System.out.println(s);
		for (String s : rea.number)
			System.out.println(s);
		for (String s : rea.operator)
			System.out.println(s);
		for (String s : rea.separator)
			System.out.println(s);
		rea.writeIntoFile();
	}*/

}// class结束
