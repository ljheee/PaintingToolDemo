package demo2;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape{
	/**
	 * ��Բ���췽��
	 */
	public Oval(int x1,int y1,int x2,int y2,Color color){
		super(x1,y1,x2,y2,color);
	}
	/**
	 * ��Բ��ͼ����
	 */
	public void draw(Graphics g){
		//��ȡx�����y����Ľ�Сֵ	
		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		g.setColor(color);
		g.drawOval(x, y, Math.abs(x2-x1), Math.abs(y2-y1));	
	}
}
