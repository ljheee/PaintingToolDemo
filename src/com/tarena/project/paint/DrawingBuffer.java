/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: ��ͼ�����ͼ�񻺳��ࡣ
  * Version					: 1.0
  * 1.	2008.10.12 	�´�     		�½�
  **/
package com.tarena.project.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawingBuffer {
	
	private BufferedImage buffer;
	private Graphics2D graphics;
	/**
	 * ����Ĭ�ϴ�С�Ļ��廭��,Ĭ�ϴ�СΪ800x600��
	 */
	public DrawingBuffer(){
		this(800,600);
	}
	/**
	 * ����ָ����С�Ļ��廭����
	 * @param width ָ�������Ŀ��
	 * @param height ָ�������ĸ߶�
	 */
	public DrawingBuffer(int width,int height){
		buffer=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);	
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				buffer.setRGB(i, j, Color.WHITE.getRGB());
			}
		}
		graphics=buffer.createGraphics();
		graphics.setBackground(Color.WHITE);
	}
	
	/**
	 * �õ��û����Ļ���ͼ��
	 * @return �û����Ļ���ͼ��
	 */	
	public BufferedImage getBuffer() {
		return buffer;
	}
	/**
	 * ���øû����Ļ���ͼ��
	 * @param buffer ������ͼ�λ���ͼ��
	 */
	public void setBuffer(BufferedImage buffer) {
		this.buffer = buffer;
	}
		
	/**
	 * �õ��û�����ͼ�Ρ�
	 * @return �û�����ͼ��
	 */	
	public Graphics2D getGraphics() {
		return graphics;
	}
	/**
	 * ���øû�����ͼ�Ρ�
	 * @param graphics ������ͼ�ζ���
	 */
	public void setGraphics(Graphics2D graphics) {
		this.graphics = graphics;
	}
	
	/**
	 * ���û��廭������Ϊ�ļ���
	 * @param f �������ļ���
	 */
	
	public void save(File f){
		try {
			ImageIO.write(buffer, f.getName().toLowerCase().endsWith(".jpg")?"jpg":"gif", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡһ��ͼ���ļ����������廭����
	 * @param file Ҫ��ȡ��ͼ���ļ�������Ϊjava֧�ֵ�ͼ���ļ�������jpg,gif,png�ȡ�
	 */
	public void open(File file){
		try {
			this.buffer=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
