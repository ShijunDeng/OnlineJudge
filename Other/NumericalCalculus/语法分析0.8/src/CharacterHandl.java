/*
 * 词法分字符处理：
 * 将送入的单个字符拼成单词,初步处理,只剩下标识符和关键字未处理
 * @version 0.5 2012-04-12
 * @author XiaoDeng
 */
import java.io.File;
import java.io.IOException;
import java.util.*;

class CharacterHandl {
	private ReadData readData = null;
	private boolean hasNextWords = true;
	private String gramStart = "";// 文法开始符
	private MyStringArrayList startSList = new MyStringArrayList();// 每条文法的最左开始符
	private MyMap mRule = new MyMap();// 规则式
	private MyMap mFirst = new MyMap();// FIRST
	private MyMap mFollow = new MyMap();// FOLLOW
	private Map<String[], MyStringArrayList> mSelect = new HashMap<String[], MyStringArrayList>();// SELECT
	private static final int ONE=1;
	private static final int TWO=2;
	private static final int THREE=3;
	private static final int FOUR=4;
	List<String[]> keyOfSelect=new ArrayList<String[]>();	
	boolean isLL1=true;
	public CharacterHandl(File f) {
		readData = new ReadData(f);
	}

	void start(){
		 try {
			handlWords();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.countFirst();
		this.countFollow();
		this.countSelect();
	}

	public boolean isLowerCase(char c) {
		return c >= 'a' && c <= 'z';
	}

	public boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}
	public boolean isUppererCase(char c) {
		return c >= 'A' && c <= 'Z';
	}

	boolean isEmptyCharactor(char c) {
		return c == '$';
	}

	boolean isEmptyCharactor(String s) {
		return s.equals("$");
	}

	public boolean isTerminalSymbol(char c) {
		switch (c) {
		case '+':
		case '-':
		case '*':
		case '&':
		case '!':
		case '%':
		case '>':
		case '<':
		case '=':
		case '^':
		case '~':
		case ':':
		case '(':
		case ')':
		case '[':
		case ']':
			return true;
		}
		if (isLowerCase(c) || isEmptyCharactor(c)||isNumber(c))
			return true;
		return false;

	}

	public boolean isTerminalSymbol(String s) {
		char[] c = s.toCharArray();
		return c.length == 1 && isTerminalSymbol(c[0]);

	}

	public boolean isSyntacticTerm(char c) {
		if (this.isUppererCase(c) || c == '\'')
			return true;
		return false;
	}

	public boolean isSyntacticTerm(String s) {
		char[] c = s.toCharArray();// E'也只要判断第一个字母
		return isSyntacticTerm(c[0]);
	}

	public boolean isSeparator(char c) {
		switch (c) {
		case ',':
		case '.':
		case ';':
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

	void hand(String s) {
		char[] c = s.toCharArray();
		String start = "";
		String st = "";
		for (int i = 0; i < c.length; i++) {
			if (i == 0) {//
				st += c[0];
				if (1 < c.length && c[1] == '\'') {
					st += c[1];
					i++;
				}
				start = st;
				startSList.add(start);
				st = "";
			} else {//
				if (i + 1 < c.length && c[i] == '-' && c[i + 1] == '>') {// /
					i++;
				} else {// /
					if (c[i] != '|') {// //
						st += c[i];
					} else {// //					 
						mRule.put(start, st);
						st = "";
					}// //
				}// /
			}//
		}// for
		mRule.put(start, st);
		gramStart = startSList.get(0);
	}

	void handlWords() throws IOException {
		char c = readData.getNextChar();
		String s = "";
		while (readData.hasNext()) {
			if (c != ';' && isSpace(c) == false && c != '\r') {
				s += c;
			} else if (c == ';') {
				hand(s);
				s = "";
			}
			c = readData.getNextChar();
		}// readData.hasNext()

	}// handlWords

	MyStringArrayList toArrayList(String s) {
		MyStringArrayList re = new MyStringArrayList();
		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			String st = "";
			st += c[i];
			if (i + 1 < c.length && c[i + 1] == '\'') {
				st += c[i + 1];
				i++;
			}
			re.addNeglectRepate(st);
		}
		return re;

	}

	String getGramStart() {
		return gramStart;
	}

	MyStringArrayList getStartS() {
		return startSList;
	}

	MyMap getmRule() {
		return mRule;
	}

	MyMap getmFirst() {
		return mFirst;
	}

	MyMap getmFollow() {
		return mFollow;
	}

	Map<String[], MyStringArrayList> getmSelect() {
		return mSelect;
	}

	List<String[]> getKeyOfSelect() {
		return keyOfSelect;
	}

void countFirst() {
		boolean end = false;
		MyStringArrayList mRightList = new MyStringArrayList();// 右部规则集合
		String tempStartS = "";// 每条规则开始符
		String mRightS = "";// 右部某条规则串
		for (int i = 0; i < startSList.getSize(); i++) {
			tempStartS = startSList.get(i);
			mRightList = mRule.get(tempStartS);
			for (int j = 0; j < mRightList.getSize(); j++) {
				mRightS = mRightList.get(j);
				MyStringArrayList sl = this.toArrayList(mRightS);
				if (this.isTerminalSymbol(sl.get(0))) {
					mFirst.put(tempStartS, sl.get(0));

				}

			}// for---2---得到右部规则式集合后的循环
		}// for--1---左部规则集合循环--startSList

		while (end == false) {
			end = true;
			int record1[] = new int[startSList.getSize()];
			for (int i = 0; i < startSList.getSize(); i++) {
				if (mFirst.get(startSList.get(i)) != null)
					record1[i] = mFirst.get(startSList.get(i)).getSize();
				else
					record1[i] = 0;
			}

			for (int i = 0; i < startSList.getSize(); i++) {
				tempStartS = startSList.get(i);
				mRightList = mRule.get(tempStartS);
				for (int j = 0; j < mRightList.getSize(); j++) {
					mRightS = mRightList.get(j);
					MyStringArrayList toArrayList = this.toArrayList(mRightS);
					for (int k = 0; k < toArrayList.getSize(); k++) {
						if (this.isTerminalSymbol(toArrayList.get(k)))
							break;
						MyStringArrayList toArraFirstOf = mFirst
								.get(toArrayList.get(k));
						if (toArraFirstOf != null)
							mFirst.put(tempStartS, toArraFirstOf);
						if (mFirst.exists(toArrayList.get(k), "$") == false)
							break;
					}// for----3
				}// for----2

			}// for----1

			int record2[] = new int[startSList.getSize()];
			for (int i = 0; i < startSList.getSize(); i++) {
				if (mFirst.get(startSList.get(i)) != null)
					record2[i] = mFirst.get(startSList.get(i)).getSize();
				else
					record2[i] = 0;
			}
			for (int i = 0; i < record1.length; i++) {
				if (record1[i] != record2[i]) {
					end = false;
				}

			}
		}// while(end=true)
	}
	void countFollow() {
		boolean end = false;
		MyStringArrayList mRightList = new MyStringArrayList();// 右部规则集合
		String tempStartS = "";// 每条规则开始符
		String mRightS = "";// 右部某条规则串

		mFollow.put(this.gramStart, "#");

		for (int i = 0; i < startSList.getSize(); i++) {
			tempStartS = startSList.get(i);
			mRightList = mRule.get(tempStartS);
			for (int j = 0; j < mRightList.getSize(); j++) {
				mRightS = mRightList.get(j);
				MyStringArrayList sl = this.toArrayList(mRightS);																// sl.get(0));
				for (int k = 0; k < sl.getSize(); k++) {
					if (k + 1 < sl.getSize() && this.isSyntacticTerm(sl.get(k))
							&& this.isTerminalSymbol(sl.get(k + 1))) {
						mFollow.put(sl.get(k), sl.get(k + 1));
						k++;// k+1为终结符,自然不用做了
					}
				}

			}// for---2---得到右部规则式集合后的循环
		}// for--1---左部规则集合循环--startSList

		while (end == false) {
			end = true;
			int record1[] = new int[startSList.getSize()];
			for (int i = 0; i < startSList.getSize(); i++) {
				if (mFirst.get(startSList.get(i)) != null)
					record1[i] = mFirst.get(startSList.get(i)).getSize();
				else
					record1[i] = 0;
			}
			for (int i = 0; i < startSList.getSize(); i++) {
				tempStartS = startSList.get(i);
				mRightList = mRule.get(tempStartS);
				for (int j = 0; j < mRightList.getSize(); j++) {
					mRightS = mRightList.get(j);
					MyStringArrayList sl = this.toArrayList(mRightS);
					for (int k = sl.getSize() - 1; k >= 0; k--) {
						if (this.isSyntacticTerm(sl.get(k))) {
							mFollow.put(sl.get(k), mFollow.get(tempStartS));

						}
						if (mFirst.exists(sl.get(k), "$") == false)
							break;
					}
					for (int k = sl.getSize() - 1; k >= 0; k--) {
						if (k - 1 >= 0 && this.isSyntacticTerm(sl.get(k))
								&& this.isSyntacticTerm(sl.get(k - 1))) {
							MyStringArrayList temp = mFirst.get(sl.get(k));
							if(temp.exists("$")){
								temp.remove("$");
								mFollow.put(sl.get(k - 1), temp);
								temp.add("$");
							}
							else
								mFollow.put(sl.get(k - 1), temp);
							
							
						}

					}

				}// for---2---得到右部规则式集合后的循环
			}// for--1---左部规则集合循环--startSList

			int record2[] = new int[startSList.getSize()];
			for (int i = 0; i < startSList.getSize(); i++) {
				if (mFirst.get(startSList.get(i)) != null)
					record2[i] = mFirst.get(startSList.get(i)).getSize();
				else
					record2[i] = 0;
			}
			for (int i = 0; i < record1.length; i++) {
				if (record1[i] != record2[i]) {
					end = false;
				}

			}
		}// while(end=true)*/
	}

	void countSelect() {
		MyStringArrayList mRightList = new MyStringArrayList();// 右部规则集合
		MyStringArrayList isLL1List ;
		String tempStartS = "";// 每条规则开始符
		String []key;
		for (int i = 0; i < startSList.getSize(); i++) {
			tempStartS = startSList.get(i);
			int k=0;
			isLL1List= new MyStringArrayList();
			mRightList = mRule.get(tempStartS);
			for (int j = 0; j < mRightList.getSize(); j++) {
				 key=new String[]{tempStartS,mRightList.get(j)};
				 keyOfSelect.add(key);
				 unionFirst(key);
				 MyStringArrayList ll = mSelect.get(key);
				 if(k>0){
					if(isLL1List.hasCommen(ll))
						isLL1=false;
				 }
				 isLL1List.add(ll);
			}// for---2
		}// for---1
	}

	void unionFirst(String []s) {
		MyStringArrayList temp = this.toArrayList(s[1]);
		MyStringArrayList re = new MyStringArrayList();
		 boolean canBeEmpty=true;
		 switch(chooseID(s[1])){
		 case ONE:
			 int i1=0;
			 while(i1<temp.getSize()&&this.isTerminalSymbol(temp.get(i1))){
				 re.add(temp.get(i1));
					 i1++;
			 }
			 mSelect.put(s, re);
			 break;
		 case TWO:
			 for(int i2=0;i2<temp.getSize()&&canBeEmpty;i2++){
				 re.add(mFirst.get(temp.get(i2)));
				 if(mFirst.get(temp.get(i2)).exists("$")==false)
					 canBeEmpty=false;
			 }
			 if(canBeEmpty){
				 re.remove("$");
				 re.add(mFollow.get(s[0]));
			 }
			 mSelect.put(s, re);
			 break;
		 case THREE:
			 int i3=0;			
			 while(i3<temp.getSize()&&this.isSyntacticTerm(temp.get(i3))&&canBeEmpty){
				 re.add(mFirst.get(temp.get(i3)));
					 i3++;
					 if(i3<temp.getSize()&&mFirst.get(temp.get(i3))!=null&&mFirst.get(temp.get(i3)).exists("$")==false)
						 canBeEmpty=false;
			 }
			 while(canBeEmpty&&i3<temp.getSize()&&this.isTerminalSymbol(temp.get(i3))){
				 re.add(temp.get(i3));
					 i3++;
			 }
			 mSelect.put(s, re);//不用删$
			 break;
		 case FOUR:
			 re.add(mFollow.get(s[0]));
			 mSelect.put(s, re);
			 break;
			 
		 }
 	}
	
	
	
	int chooseID(String s){
		MyStringArrayList ls=this.toArrayList(s);
		if(ls.get(0).equals("$")==false&&this.isTerminalSymbol(ls.get(0))){
			return  ONE;//aEF或者a
		}
		else if(ls.get(0).equals("$")==true){
			return   FOUR;//$
		}
		else{
			for(int i=0;i<ls.getSize();i++)
				if(this.isTerminalSymbol(ls.get(i)))
						return  THREE;//AaB
				return  TWO;//AB
		}
		 
	}

	boolean isLL1() {
		return isLL1;
	}

}
