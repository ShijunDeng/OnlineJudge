import java.util.HashMap;
import java.util.Map;

/*
 * @author 邓仕军
 *  time：2012-04-14
 * 分析表:用map实现
 * 例如：
 *       i
 * E    TE'
 * 就将"Ei"作为键值,"TE'"作为值
 */
class ParseList {

	Map<String ,String > parseList;
	MyStringArrayList select;
	CharacterHandl handl;
	public ParseList(CharacterHandl h){
		parseList=new HashMap<String ,String >();
		this.handl=h;
		init();//默认储值
	}
	
	public void put(String key,String value){
		parseList.put(key, value);
	}
	
	public String get(String key){
		return parseList.get(key);
	}
	
	//存入默认分析表
	public void init(){	 
		for(int i=0;i<handl.getKeyOfSelect().size();i++){
			String[] key=handl.getKeyOfSelect().get(i);
			select=handl.getmSelect().get(key);
			for(int j=0;j<select.getSize();j++){
				parseList.put(key[0]+select.get(j), key[1]);
			}
		}
			  
	}
	
}
