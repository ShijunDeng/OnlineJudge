package com.greenery.main;

import com.greenery.animals.PleasantGoat;
import com.greenery.skill.Apple;
import com.greenery.skill.GreenApple;
import com.greenery.skill.RedApple;
import com.greenery.skill.YellowApple;

public class Main {

	public static void main(String[] args) {
		PleasantGoat pleasantGoat = new PleasantGoat("pleasantGoat");
		pleasantGoat.show();
		Apple redApple = new RedApple();
		Apple greenApple = new GreenApple();
		Apple yellowApple = new YellowApple();

		System.out.println("�������һ��");
		redApple.addSkill(pleasantGoat);
		greenApple.addSkill(redApple);
		yellowApple.addSkill(greenApple);

		yellowApple.show();
		
		System.out.println("������϶���");
		yellowApple.addSkill(pleasantGoat);
		greenApple.addSkill(yellowApple);
		redApple.addSkill(greenApple);

		redApple.show();
	}

}
