package wangshuo.program;

import java.awt.Image;

/*@author:��˷
 *@time:2012-05-11
 * ���
 */
class Gambler {
	private int ID;//��ҵ�����
	private Cards cards;//��ҵ���
	private Image image;//��ҵ�ͷ��
	public Gambler(int ID,Cards cards,Image image){
		this.setID(ID);
		this.cards=cards;
		this.setImage(image);
	}
	Cards getCards() {
		return cards;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	 
	
}
