import java.util.HashMap;
import java.util.Map;

/*
 * @author ���˾�
 *  time��2012-04-14
 * ������:��mapʵ��
 * ���磺
 *       i
 * E    TE'
 * �ͽ�"Ei"��Ϊ��ֵ,"TE'"��Ϊֵ
 */
class ParseList {

	Map<String ,String > parseList;
	MyStringArrayList select;
	CharacterHandl handl;
	public ParseList(CharacterHandl h){
		parseList=new HashMap<String ,String >();
		this.handl=h;
		init();//Ĭ�ϴ�ֵ
	}
	
	public void put(String key,String value){
		parseList.put(key, value);
	}
	
	public String get(String key){
		return parseList.get(key);
	}
	
	//����Ĭ�Ϸ�����
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
