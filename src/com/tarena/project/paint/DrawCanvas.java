/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: ��ͼ����Ĺ�������
  * Version					: 1.0
  * 1.	2008.10.12 	�´�     		�½�
  **/
package com.tarena.project.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

/**
 *  ��ͼ����Ĺ������ࡣ
 * 2008-10-12
 * @author		���ڿƼ�[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(����) 
 */
public class DrawCanvas extends JLabel {
	
	private boolean isPressed=false;
	private BufferedImage bimg;
	private Color color=Color.WHITE;
	public DrawCanvas(){
		this.setOpaque(true);
		this.setBackground(color);		
		this.setSize(800,600);
		//this.addMouseMotionListener(new MyMouseMotionListener());
	}
	public DrawCanvas(BufferedImage bimg){
		this.bimg=bimg;
	}
	/**
	 * ���Ǹ����paint�����������廭����ͼ��д�빤����������ʾͼƬ��
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(bimg,0,0,this);
	}
	
	/**
	 * �������ڲ��࣬�������������������¼���
	 */
	class MyMouseListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			DrawCanvas.this.isPressed=true;
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			DrawCanvas.this.isPressed=false;
		}		
	}
	
}
