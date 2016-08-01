package demo2;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
		
	public Line(int x1,int y1,int x2,int y2,Color color){

		//调用父类的构造函数super = Shape
		super(x1,y1,x2,y2,color);
		
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);	
	}
		
}
