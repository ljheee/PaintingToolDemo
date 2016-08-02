/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: 画图程序的图标解析工具类。
  * Version					: 1.0
  * 1.	2008.10.12 	陈达     		新建
  **/
package com.tarena.project.paint;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 画图程序的图标解析工具，支持从按指定顺序排列的图标集合中获取指定的图标。
 * 2008-10-12
 * @author		达内科技[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(建议) 
 */
public class ImagePaser {
	
	private BufferedImage bimg=null;
	private int px=0,py=0;
	private int width=0;
	private int height=0;
	
	/**
	 * 从指定的文件，初始化图标解析工具。
	 * @param file Java支持的图像文件。
	 */
	public ImagePaser(File  file){
		try {
			bimg=ImageIO.read(file);			
		} catch (IOException e) {
			System.out.println("【图标文件读取异常】");
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
	 * 设置解析起始的左上点坐标
	 * @param x x坐标
	 * @param y y坐标
	 */
	public void setStartPosition(int x,int y){
		this.px=x;
		this.py=y;
	}
	/**
	 * 设置所要解析图标的大小。
	 * @param w 所要设置图标的宽度
	 * @param h 所要设置图标的高度
	 */
	public void setSubimageSize(int w,int h){
		this.width=w;
		this.height=bimg.getHeight();
	}
	
	/**
	 * 根据指定的坐标和大小，获取图标。
	 * @param x 图标左上角x坐标值。
	 * @param y 图标左上角y坐标值。
	 * @param w 所要设置图标的宽度
	 * @param h 所要设置图标的高度
	 * @return 按指定参数取得的图标。
	 */
	
	public ImageIcon getSubimage(int x,int y,int w,int h){
		ImageIcon icon=null;
		icon=new ImageIcon(bimg.getSubimage(x, y, w, h));
		return icon;
	}
	/**
	 * 是否还能取得下一个图标。
	 * @return 布尔值表示是否能取得下个图标。
	 */
	public boolean hasNextImage(){
		if(px+width>bimg.getWidth()){
			return false;
		}
		return true;
	}
	
	/**
	 * 取得下个图标。
	 * @return 返回的图标。
	 */
	public ImageIcon getNextImage(){	
		ImageIcon icon=getSubimage(px, py, width, height);
		px+=width;
		return icon;
	}
	
}
