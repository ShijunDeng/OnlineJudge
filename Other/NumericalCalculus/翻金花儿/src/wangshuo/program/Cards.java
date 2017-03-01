package wangshuo.program;

import java.util.*;

/*@author:��˷
 *@time:2012-05-11
 * һ����
 */
class Cards {

	static final int MAXOFTONGHUA = 100;
	static final int VALUEOFTONGHUA = 100;
	static final int VALUEOFSHUNZI = 90;
	static final int VALUEOFTONGDIAN = 80;
	static final int VALUEOFDUIZI = 70;
	static final int VALUEOFBUTONGSEZAPAI = 60;// ��ͬ��ɫ����
	static final int VALUEOFTONGSEZAPAI = 50;// ͬ��ɫ����
	List<Card> cards = new ArrayList<Card>();
	private int ID;// ��һ���Ƶı�ʶ��ͬ��˳��˳��......
	private int[] detailID;// ��װ�������Ϣ��

	// ͬ��˳��˳�ӣ������Ƶ�ֵ
	// ͬ�㣺���ֵ
	// ���ӣ����ӵ�ֵ���������Ǹ��Ƶ�ֵ
	// ���ƣ���֮��

	/*
	 * @parameter:number����ֽ����Ŀ
	 */
	public Cards(int number) {
		for (int i = 0; i < number; i++) {
			Card c = new Card();
			if (false == this.exsit(c)) {
				this.putCard(c);
			} else
				i--;
		}

	}

	public Cards() {

	}

	/*
	 * �ж���ʲô�ƣ�ͬ��˳��˳��......
	 */
	public void judge() {
		this.sort();// ������
		int n = this.cards.size();
		int[] value = new int[n];
		int[] color = new int[n];// ��Ϊ������ʸ��죬��������
		Card c = new Card();

		for (int i = 0; i < n; i++) {
			c = cards.get(i);
			value[i] = c.getValue();
			color[i] = c.getColor();
		}

		// ˳��
		if (color[0] == color[1] && color[1] == color[2]) {
			// ͬ��˳
			this.ID = Cards.VALUEOFTONGHUA;
			this.detailID = new int[2];
			this.detailID[0]=0;
			if(value[2]==14&&value[1]==13&&value[0]==12)
				this.detailID[0]=MAXOFTONGHUA;
			this.detailID[1] =value[0]+value[1] +value[2];
		} else if (value[2] - value[1] == 1 && value[1] - value[0] == 1) {
			// ��ͬ��ɫ��˳��
			this.ID = Cards.VALUEOFSHUNZI;
			this.detailID = new int[1];
			this.detailID[0] = value[2];
		} else if (value[0] == value[1] && value[1] == value[2]) {
			// ͬ��
			this.ID = Cards.VALUEOFTONGDIAN;
			this.detailID = new int[1];
			this.detailID[0] = value[2];
		} else if (value[0] == value[1] || value[1] == value[2]) {
			// ����
			this.ID = Cards.VALUEOFDUIZI;
			this.detailID = new int[2];
			if (value[0] == value[1]) {
				// ����445
				this.detailID[0] = value[0];// ����4
				this.detailID[1] = value[2];// ����5
			} else {
				// ����688
				this.detailID[0] = value[2];// ����4
				this.detailID[1] = value[1];// ����5
			}

		} else if (value[0] != value[1] && value[1] != value[2]
				&& value[0] != value[2]) {
			// ����
			this.detailID = new int[1];
			this.detailID[0] = value[0] + value[1] + value[2];// ��֮��
			if (color[0] == color[1] && color[1] == color[2]) {
				// ͬ��ɫ����
				this.ID = Cards.VALUEOFTONGSEZAPAI;
			} else {
				// ��ͬ��ɫ����
				this.ID = Cards.VALUEOFBUTONGSEZAPAI;
			}

		}
		// ����if����

	}// judge

	public void putCard(Card card) {
		this.cards.add(card);
	}

	int getSize() {
		return this.cards.size();
	}

	Card getCard(Card card) {
		Card c = null;
		for (int i = 0; i < this.cards.size(); i++) {
			if (cards.get(i).compareTo(card) == true)
				c = cards.get(i);
		}
		return c;
	}

	Card getCard(int index) {
		return this.cards.get(index);

	}

	int getID() {
		return ID;
	}

	int[] getDetailID() {
		return detailID;
	}

	Card removeCard(Card card) {
		Card c = null;
		for (int i = 0; i < this.cards.size(); i++) {
			if (cards.get(i).compareTo(card) == true) {
				c = cards.get(i);
				this.cards.remove(i);
			}
		}
		return c;
	}

	boolean exsit(Card card) {
		for (Card e : cards) {
			if (card.compareTo(e) == true)
				return true;
		}
		return false;
	}

	public void sort() {
		boolean change = true;
		for (int i = this.cards.size() - 1; i >= 1 && change; i--) {
			change = false;
			for (int j = 0; j < i; j++) {
				if (this.cards.get(j).getValue() > this.cards.get(j + 1)
						.getValue()) {
					Card card = this.cards.get(j);
					this.cards.set(j, this.cards.get(j + 1));
					this.cards.set(j + 1, card);
					change = true;
				}
			}
		}
	}// sort
	/*
	 * public static void main(String args[]){ Cards c=new Cards(); for(int
	 * i=0;i<10;i++){ Card cc=new Card(); if(false==c.exsit(cc)) {
	 * c.putCard(cc); } else i--; }
	 * 
	 * for(int i=0;i<10;i++){ System.out.print(c.cards.get(i).getValue()+"  ");
	 * } System.out.println(); c.sort(); for(int i=0;i<10;i++){
	 * System.out.print(c.cards.get(i).getValue()+"  "); } }
	 */
}// Cards
