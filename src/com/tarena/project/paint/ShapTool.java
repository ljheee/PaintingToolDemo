/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: ��ͼ�����ͼ�ι�������
  * Version					: 1.0
  * 1.	2008.10.12 	�´�     		�½�
  **/
package com.tarena.project.paint;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;


/**
 *  ��ͼ�����ͼ�ι������ࡣ
 * 2008-10-12
 * @author		���ڿƼ�[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(����) 
 */
public class ShapTool extends JPanel{
	private int shaptype;
	
	private JPanel root=new JPanel();
	private ButtonGroup buttongroup=new ButtonGroup();
	private ImagePaser parser=null;
	
	//����������һ��ťʱ����ǰ��ť��������״̬��ʣ�����а�ť�ǵ���״̬
	private JToggleButton tools[]=new JToggleButton[16];
	
	private JPanel northpan=new JPanel();
	private JList list=new JList();
	public ShapTool(){		
		parser=new ImagePaser(ShapTool.class.getResource("resource/tools.png"));		
		northpanInit();
		listInit();
		rootInit();
		
		this.setLayout(null);
		this.add(root);
		root.setSize(50,230);
		root.setLocation(5, 5);
	}
	
	
	
	private void northpanInit(){
		
		parser.setStartPosition(0, 0);
		parser.setSubimageSize(16, 24);
		
		northpan.setLayout(new GridLayout(8,2,1,1));
		
		for(int i=0;i<16;i++){
			tools[i]=new JToggleButton(parser.getNextImage());
			northpan.add(tools[i]);
			buttongroup.add(tools[i]);
		}
	
		tools[6].setSelected(true);
	}
	
	private void listInit(){
			
		list.setBorder(new BevelBorder(BevelBorder.LOWERED));
		list.setPreferredSize(new Dimension(0,60));
	}
	
	private void rootInit(){
		root.setLayout(new BorderLayout());
		root.add(northpan,BorderLayout.CENTER);
		root.add(list,BorderLayout.SOUTH);		
	}
	
	/**
	 * �õ���ǰ��������ѡ��Ĺ���
	 * @return ����ѡ�񹤾ߵ�����
	 */
	public int getSelectIdx(){
		for(int i=0;i<tools.length;i++){
			if(tools[i].isSelected()){
				return i;
			}
		}
		return -1;
	}
}


