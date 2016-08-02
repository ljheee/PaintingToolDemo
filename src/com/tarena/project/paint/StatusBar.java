/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: ��ͼ�����״̬����
  * Version					: 1.0
  * 1.	2008.10.12 	�´�     		�½�
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
 *  ��ͼ�����״̬����
 * 2008-10-12
 * @author		���ڿƼ�[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(����) 
 */
public class StatusBar extends JPanel{
	
	private Font font=new Font("����",Font.PLAIN,12);
	private JLabel message=new JLabel("Ҫ��ð��������ڡ��������˵����У��������������⡱��");
	
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
	 * ����Ŀǰ��������λ�á�
	 * @param x ������ڵ�x����
	 * @param y ������ڵ�y����
	 */
	public void setShowPosition(int x,int y) {
		showPosition.setText(x+","+y);
	}
	
	/**
	 * ����Ŀǰѡȡ��Ĵ�С��
	 * @param width ѡȡ��Ŀ��
	 * @param height ѡȡ��ĸ߶�
	 */
	public void setShowSize(int width,int height) {
		showSize.setText(width+","+height);
	}
	
	
}
