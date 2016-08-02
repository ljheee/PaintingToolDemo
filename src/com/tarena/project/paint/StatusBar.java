/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: 画图程序的状态条。
  * Version					: 1.0
  * 1.	2008.10.12 	陈达     		新建
  **/

package com.tarena.project.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

/**
 *  画图程序的状态条。
 * 2008-10-12
 * @author		达内科技[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(建议) 
 */
public class StatusBar extends JPanel{
	
	private Font font=new Font("宋体",Font.PLAIN,12);
	private JLabel message=new JLabel("要获得帮助，请在“帮助”菜单栏中，单击“帮助主题”。");
	
	private JPanel status=new JPanel();
	private JLabel showPosition=new JLabel();
	private JLabel showSize=new JLabel();
	
	/**
	 * 
	 */
	public StatusBar(){
		message.setFont(font);
		message.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		showPosition.setFont(font);
		showPosition.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		showSize.setFont(font);
		showSize.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		status.setLayout(new GridLayout(1,2));
		status.add(showPosition);
		status.add(showSize);
		status.setPreferredSize(new Dimension(200,0));
		
		this.setLayout(new BorderLayout());
		this.add(message,BorderLayout.CENTER);
		this.add(status,BorderLayout.EAST);
		this.setBorder(new EtchedBorder());
	}

	/**
	 * 设置目前鼠标的最新位置。
	 * @param x 鼠标所在的x坐标
	 * @param y 鼠标所在的y坐标
	 */
	public void setShowPosition(int x,int y) {
		showPosition.setText(x+","+y);
	}
	
	/**
	 * 设置目前选取框的大小。
	 * @param width 选取框的宽度
	 * @param height 选取框的高度
	 */
	public void setShowSize(int width,int height) {
		showSize.setText(width+","+height);
	}
	
	
}
