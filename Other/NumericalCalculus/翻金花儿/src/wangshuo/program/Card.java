package wangshuo.program;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Random;

/*@author:王朔
 *@time:2012-05-11
 * 产生纸牌
 */
class Card {
	public static final int NUMBEROFTYPE = 4;// 牌的种类黑红梅方
	public static final int NUMBEROFEACHTYPE = 13;// 每种13张牌
	private int value;
	private int color;

	static Image[] cardImages = new Image[NUMBEROFTYPE * NUMBEROFEACHTYPE];

	private static Toolkit toolkit = Toolkit.getDefaultToolkit();
	private  Image image;
	static {
		for (int i = 1; i <= NUMBEROFTYPE; i++) {
			for (int j = 1; j <= NUMBEROFEACHTYPE; j++) {
				cardImages[(i - 1) * NUMBEROFEACHTYPE + j - 1] = toolkit.createImage(
								"resource" + File.separator + "images"
										+ File.separator + "cards"
										+ File.separator + i + "-" + (j + 1)
										+ ".jpg");
			}
		}

	}

	public Card(int value, int color) {
		init(value, color);
	}

	public Card() {
		Random rdm = new Random(System.currentTimeMillis());
		int number = rdm.nextInt() / 100;
		int a_value, a_color;
		while (!(number >= 2 && number <= 14)) {
			number = Math.abs(rdm.nextInt());
			if (number > 10000000) {
				number %= 10000000;
			} else if (number < 10000000 && number > 100000) {
				number %= 100000;
			} else if (number < 100000 && number > 1000) {
				number %= 1000;
			} else {
				number %= 100;
			}

		}
		a_value = number;

		number = Math.abs(rdm.nextInt() % 10000000);
		while (!(number >= 1 && number <= 4)) {
			number = Math.abs(rdm.nextInt());
			if (number > 10000000) {
				number %= 10000000;
			} else if (number < 10000000 && number > 100000) {
				number %= 100000;
			} else if (number < 100000 && number > 1000) {
				number %= 1000;
			} else {
				number %= 100;
			}
			number /= 5;
		}

		a_color = number;
		init(a_value, a_color);
	}// Card()

	void init(int value, int color) {
		this.value = value;
		this.color = color;
		// System.out.println(color +"    "+value);
		image = cardImages[(color - 1) * NUMBEROFEACHTYPE + value - 2];// 因为我的牌是从2开始的
	}

	int getValue() {
		return value;
	}

	int getColor() {
		return color;
	}

	public boolean compareTo(Card card) {
		return card.getColor() == this.getColor()
				&& card.getValue() == this.getValue();
	}

	public Image getImage() {
		return image;
	}

	public void draw(Graphics g, int xPos1, int yPos1) {

		g.drawImage(image, xPos1, yPos1, null);

	}

}
