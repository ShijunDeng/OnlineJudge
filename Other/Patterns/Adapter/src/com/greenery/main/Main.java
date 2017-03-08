package com.greenery.main;

import com.greenery.paint.PaintMethod;
import com.greenery.shape.Angle;
import com.greenery.shape.Circle;
import com.greenery.shape.Line;
import com.greenery.shape.Rectangle;
import com.greenery.shape.Adapter.AngleAdapter;

public class Main {


	public static void main(String[] args) {
		PaintMethod circle =new Circle();
		circle.draw();
		PaintMethod line=new Line();
		line.draw();
		PaintMethod rec=new Rectangle();
		rec.draw();
		System.out.println("Now start to run adapter method:");
		Angle angle=new Angle();
		PaintMethod angleAdapter=new AngleAdapter(angle);
		angleAdapter.draw();
	}

}
