/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: ��ͼ������Զ��������ʽ�ࡣ
  * Version					: 1.0
  * 1.	2008.10.12 	�´�     		�½�
  **/
package com.tarena.project.paint;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;


/**
 * �Զ��������ʽ��
 * 2008-10-12
 * @author		���ڿƼ�[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(����) 
 */
public class MyCustomCursor{
	private static final Toolkit toolkit=Toolkit.getDefaultToolkit();
	private static final Point CURSOR_SIZE=new Point(16,16);
	private static final String FILE_DIR="resource/";
	/**
	 * ˢ�ӹ��ߵ������ʽ��
	 */
	public static final Cursor BRUSH = toolkit.createCustomCursor(new ImageIcon(MyCustomCursor.class.getResource(FILE_DIR+"brush.png")).getImage(),CURSOR_SIZE,"BRUSH");
	/**
	 * �ιܹ��ߵ������ʽ��
	 */
	public static final Cursor BURET = toolkit.createCustomCursor(new ImageIcon(MyCustomCursor.class.getResource(FILE_DIR+"buret.png")).getImage(),CURSOR_SIZE,"BURET");
	public static final Cursor FLUSH = toolkit.createCustomCursor(new ImageIcon(MyCustomCursor.class.getResource(FILE_DIR+"flush.png")).getImage(),CURSOR_SIZE,"FLUSH");
	public static final Cursor MAGNIFER = toolkit.createCustomCursor(new ImageIcon(MyCustomCursor.class.getResource(FILE_DIR+"magnifer.png")).getImage(),CURSOR_SIZE,"MAGNIFER");
	public static final Cursor MOVE = toolkit.createCustomCursor(new ImageIcon(MyCustomCursor.class.getResource(FILE_DIR+"move.png")).getImage(),CURSOR_SIZE,"MOVE");
	public static final Cursor PEN = toolkit.createCustomCursor(new ImageIcon(MyCustomCursor.class.getResource(FILE_DIR+"pen.png")).getImage(),new Point(12,22),"PEN");
	public static final Cursor SELECT = toolkit.createCustomCursor(new ImageIcon(MyCustomCursor.class.getResource(FILE_DIR+"select.png")).getImage(),CURSOR_SIZE,"SELECT");
	public static final Cursor SPRAY = toolkit.createCustomCursor(new ImageIcon(MyCustomCursor.class.getResource(FILE_DIR+"spray.png")).getImage(),CURSOR_SIZE,"SPRAY");
	
}
