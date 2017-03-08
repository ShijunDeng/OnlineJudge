package com.greenery.main;
import com.greenery.animals.PleasantGoat;
import com.greenery.skill.GreenApple;
import com.greenery.skill.RedApple;
import com.greenery.skill.YellowApple;

public class Main {

	public static void main(String[] args) {
		PleasantGoat pleasantGoat = new PleasantGoat("pleasantGoat");
		pleasantGoat.show();
		RedApple redApple = new RedApple();
		GreenApple greenApple = new GreenApple();
		YellowApple yellowApple = new YellowApple();

		System.out.println("技能组合一：");
		redApple.addSkill(pleasantGoat);
		greenApple.addSkill(redApple);
		yellowApple.addSkill(greenApple);

		yellowApple.show();
		
		System.out.println("技能组合二：");
		yellowApple.addSkill(pleasantGoat);
		greenApple.addSkill(yellowApple);
		redApple.addSkill(greenApple);

		redApple.show();
	}
}
