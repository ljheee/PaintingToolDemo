/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: 画图程序的图形工具栏。
  * Version					: 1.0
  * 1.	2008.10.12 	陈达     		新建
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
 *  画图程序的图形工具栏类。
 * 2008-10-12
 * @author		达内科技[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(建议) 
 */
public class ShapTool extends JPanel{
	private int shaptype;
	
	private JPanel root=new JPanel();
	private ButtonGroup buttongroup=new ButtonGroup();
	private ImagePaser parser=null;
	
	//当按下其中一按钮时，当前按钮呈现下陷状态，剩下所有按钮是弹起状态
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
	 * 得到当前工具栏所选择的工具
	 * @return 返回选择工具的索引
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


