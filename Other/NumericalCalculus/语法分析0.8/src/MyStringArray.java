 

import java.util.*;

class MyStringArrayList {

	List<String> stringList;

	public MyStringArrayList() {
		stringList = new ArrayList<String>();
	}

	String get(int i) {
		return stringList.get(i);
	}

	void add(String s) {
		if (s != null && s.equals("") == false) {
			for (int i = 0; i < stringList.size(); i++) {
				if (stringList.get(i) == null
						|| stringList.get(i).equals(s) == true)
					return;
			}
			stringList.add(s);
		}

	}

	int getSize() {
		return stringList.size();
	}

	void add(MyStringArrayList ls) {
		if (ls != null)
			for (int i = 0; i < ls.getSize(); i++) {
				 add(ls.get(i));
			}

	}
	boolean hasCommen(MyStringArrayList ls){
		for(int i=0;i<ls.getSize();i++)
		{
			if(exists(ls.get(i))==true)
				return true;
		}
		return false;
	}
 void addNeglectRepate(String s){
	if(s!=null&& s.equals("") == false)
		this.stringList.add(s);
 }
	List<String> getData() {
		return this.stringList;
	}

	boolean exists(String s) {
		for (int i = 0; i < this.stringList.size(); i++) {
			if (this.stringList.get(i).equals(s))
				return true;
		}
		return false;
	}

	void print() {
		for (int i = 0; i < this.stringList.size(); i++) {

			System.out.print(stringList.get(i) + " ");
		}
		System.out.println();
	}
	 
	String remove(String s){
		for(int i=0;i<this.stringList.size();i++)
			if(this.stringList.get(i).equals(s))
				return this.stringList.remove(i);
		return null;
	}

	public String MytoString(){
		String s="";
		for(int i=0;i<this.stringList.size();i++){
			s+=stringList.get(i);
			if(i<this.stringList.size()-1)
				s+=" , ";
		}
		return s;
	}

}
