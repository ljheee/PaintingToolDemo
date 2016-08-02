/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: 画图程序的工作区。
  * Version					: 1.0
  * 1.	2008.10.12 	陈达     		新建
  **/
package com.tarena.project.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

/**
 *  画图程序的工作区类。
 * 2008-10-12
 * @author		达内科技[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(建议) 
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
	 * 覆盖父类的paint函数，将缓冲画布的图像，写入工作区，以显示图片。
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(bimg,0,0,this);
	}
	
	/**
	 * 工作区内部类，负责监听工作区的鼠标事件。
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
