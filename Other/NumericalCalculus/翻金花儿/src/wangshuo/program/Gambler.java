package wangshuo.program;

import java.awt.Image;

/*@author:王朔
 *@time:2012-05-11
 * 玩家
 */
class Gambler {
	private int ID;//玩家的名字
	private Cards cards;//玩家的牌
	private Image image;//玩家的头像
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
