package cn.sjdeng.ds;


public class BiTNode{
	public BiTNode left,right;
	char data;
	public BiTNode(char data) {
		super();
		this.data = data;
	}
	
	public void selfPrint(){
		System.out.print(" "+data);
	}
	
}