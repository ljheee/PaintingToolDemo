package demo2;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape{
	
	/**
	 * ���ι��췽��
	 */
	public Rect(int x1,int y1,int x2,int y2,Color color){
		super(x1,y1,x2,y2,color);
	}
	
	/**
	 * ���λ�ͼ����
	 */
	public void draw(Graphics g){
		//��ȡx�����y����Ľ�Сֵ	
		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		g.setColor(color);
		g.drawRect(x, y, Math.abs(x2-x1), Math.abs(y2-y1));	
	}

}
