/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: ��ͼ�����ͼ����������ࡣ
  * Version					: 1.0
  * 1.	2008.10.12 	�´�     		�½�
  **/
package com.tarena.project.paint;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * ��ͼ�����ͼ��������ߣ�֧�ִӰ�ָ��˳�����е�ͼ�꼯���л�ȡָ����ͼ�ꡣ
 * 2008-10-12
 * @author		���ڿƼ�[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(����) 
 */
public class ImagePaser {
	
	private BufferedImage bimg=null;
	private int px=0,py=0;
	private int width=0;
	private int height=0;
	
	/**
	 * ��ָ�����ļ�����ʼ��ͼ��������ߡ�
	 * @param file Java֧�ֵ�ͼ���ļ���
	 */
	public ImagePaser(File  file){
		try {
			bimg=ImageIO.read(file);			
		} catch (IOException e) {
			System.out.println("��ͼ���ļ���ȡ�쳣��");
			e.printStackTrace();
		}
	}
	public ImagePaser(URL url){
		try {
			bimg=ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ý�����ʼ�����ϵ�����
	 * @param x x����
	 * @param y y����
	 */
	public void setStartPosition(int x,int y){
		this.px=x;
		this.py=y;
	}
	/**
	 * ������Ҫ����ͼ��Ĵ�С��
	 * @param w ��Ҫ����ͼ��Ŀ��
	 * @param h ��Ҫ����ͼ��ĸ߶�
	 */
	public void setSubimageSize(int w,int h){
		this.width=w;
		this.height=bimg.getHeight();
	}
	
	/**
	 * ����ָ��������ʹ�С����ȡͼ�ꡣ
	 * @param x ͼ�����Ͻ�x����ֵ��
	 * @param y ͼ�����Ͻ�y����ֵ��
	 * @param w ��Ҫ����ͼ��Ŀ��
	 * @param h ��Ҫ����ͼ��ĸ߶�
	 * @return ��ָ������ȡ�õ�ͼ�ꡣ
	 */
	
	public ImageIcon getSubimage(int x,int y,int w,int h){
		ImageIcon icon=null;
		icon=new ImageIcon(bimg.getSubimage(x, y, w, h));
		return icon;
	}
	/**
	 * �Ƿ���ȡ����һ��ͼ�ꡣ
	 * @return ����ֵ��ʾ�Ƿ���ȡ���¸�ͼ�ꡣ
	 */
	public boolean hasNextImage(){
		if(px+width>bimg.getWidth()){
			return false;
		}
		return true;
	}
	
	/**
	 * ȡ���¸�ͼ�ꡣ
	 * @return ���ص�ͼ�ꡣ
	 */
	public ImageIcon getNextImage(){	
		ImageIcon icon=getSubimage(px, py, width, height);
		px+=width;
		return icon;
	}
	
}
