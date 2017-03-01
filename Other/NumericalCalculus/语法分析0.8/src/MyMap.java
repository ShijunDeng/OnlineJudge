 

import java.util.*;

class MyMap {
	Map<String, MyStringArrayList> map;

	public MyMap() {
		map = new HashMap<String, MyStringArrayList>();
	}

	void put(String key, String value) {
		if(value!=null){
			MyStringArrayList temp;
		temp = this.map.get(key);
		if (temp == null) {
			temp = new MyStringArrayList();
		}
		temp.add(value);
		this.map.put(key, temp);
		}
		
	}

	void put(String key, MyStringArrayList value) {
		if (value != null)
			for (int i = 0; i < value.getSize(); i++) {
				this.put(key, value.get(i));
			}
	}

	boolean exists(String key, String s) {
		if(this.map.get(key)==null)
			return false;
		return this.map.get(key).exists(s);
	}

	Map<String, MyStringArrayList> getMapData() {
		return this.map;
	}

	MyStringArrayList get(String key) {
		return this.map.get(key);
	}
	
	void print(String key) {
		MyStringArrayList teprint=this.map.get(key);
		teprint.print();
	}

	String MyToString(String key){
		return map.get(key).MytoString();
	}
}
