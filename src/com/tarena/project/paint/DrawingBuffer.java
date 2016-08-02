/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: 画图程序的图像缓冲类。
  * Version					: 1.0
  * 1.	2008.10.12 	陈达     		新建
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
	 * 构造默认大小的缓冲画布,默认大小为800x600。
	 */
	public DrawingBuffer(){
		this(800,600);
	}
	/**
	 * 构造指定大小的缓冲画布。
	 * @param width 指定画布的宽度
	 * @param height 指定画布的高度
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
	 * 得到该画布的缓冲图像。
	 * @return 该画布的缓冲图像
	 */	
	public BufferedImage getBuffer() {
		return buffer;
	}
	/**
	 * 设置该画布的缓冲图像。
	 * @param buffer 给定的图形缓冲图像
	 */
	public void setBuffer(BufferedImage buffer) {
		this.buffer = buffer;
	}
		
	/**
	 * 得到该画布的图形。
	 * @return 该画布的图形
	 */	
	public Graphics2D getGraphics() {
		return graphics;
	}
	/**
	 * 设置该画布的图形。
	 * @param graphics 给定的图形对象
	 */
	public void setGraphics(Graphics2D graphics) {
		this.graphics = graphics;
	}
	
	/**
	 * 将该缓冲画布保存为文件。
	 * @param f 保存后的文件。
	 */
	
	public void save(File f){
		try {
			ImageIO.write(buffer, f.getName().toLowerCase().endsWith(".jpg")?"jpg":"gif", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 读取一个图像文件，建立缓冲画布。
	 * @param file 要读取的图像文件，必须为java支持的图像文件，例：jpg,gif,png等。
	 */
	public void open(File file){
		try {
			this.buffer=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
