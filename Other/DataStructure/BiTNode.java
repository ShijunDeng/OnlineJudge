package cn.sjdeng.ds;


public class BiTNode{
	public BiTNode left,right;
	int data;
	public BiTNode(int data) {
		super();
		this.data = data;
	}
	
	public void selfPrint(){
		System.out.print(" "+data);
	}
	
}