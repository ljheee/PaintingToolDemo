package demo2;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape{
	
	/**
	 * 矩形构造方法
	 */
	public Rect(int x1,int y1,int x2,int y2,Color color){
		super(x1,y1,x2,y2,color);
	}
	
	/**
	 * 矩形绘图方法
	 */
	public void draw(Graphics g){
		//获取x坐标和y坐标的较小值	
		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		g.setColor(color);
		g.drawRect(x, y, Math.abs(x2-x1), Math.abs(y2-y1));	
	}

}
