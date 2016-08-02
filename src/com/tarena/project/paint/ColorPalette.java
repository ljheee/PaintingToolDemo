/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: 画图程序的调色板。
  * Version					: 1.0
  * 1.	2008.10.12 	陈达     		新建
  **/
package com.tarena.project.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * 画图程序的调色板。
 * 2008-10-12
 * @author		达内科技[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(建议) 
 */
public class ColorPalette extends JPanel {
	
	private JPanel root=new JPanel();
	private JLabel head=new JLabel();
	private JPanel body=new JPanel();
	
	private Color [][]palette={
		{Color.ORANGE,Color.MAGENTA,Color.BLUE,Color.GREEN,Color.CYAN,Color.DARK_GRAY,},
		{Color.WHITE,Color.BLACK,Color.YELLOW,Color.RED,Color.PINK,Color.LIGHT_GRAY}
	};
	
	private JLabel choose[][]=new JLabel[palette.length][palette[0].length];
	
	public ColorPalette(){
		rootInit();
	}
	public void rootInit(){
		body.setLayout(new GridLayout(choose.length,choose[0].length,2,2));
		for(int i=0;i<choose.length;i++){
			for(int j=0;j<choose[i].length;j++){
				choose[i][j]=new JLabel();
				choose[i][j].setBackground(palette[i][j]);
				choose[i][j].setBorder(new BevelBorder(BevelBorder.LOWERED));
				choose[i][j].setOpaque(true);
				choose[i][j].setPreferredSize(new Dimension(20,15));
				choose[i][j].addMouseListener(new ChangeColor());
				body.add(choose[i][j]);
			}
		}
	
		head.setBorder(new BevelBorder(BevelBorder.LOWERED));
		head.setPreferredSize(new Dimension(40,0));
		head.setBackground(Color.BLACK);
		head.setOpaque(true);
		
		root.setLayout(new BorderLayout(2,2));
		root.add(head,BorderLayout.WEST);
		root.add(body,BorderLayout.CENTER);
		this.setLayout(null);
		root.setSize(150, 30);
		root.setLocation(0,5);
		this.add(root);
	}
	/**
	 * 得到调色板的当前颜色。
	 * @return 调色板的当前颜色
	 */
	public Color getColor() {
		return head.getBackground();
	}

	class ChangeColor extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			Object obj=e.getSource();
			if(obj instanceof JLabel){
				head.setBackground(((JLabel)obj).getBackground());
			}
		}
	}
	
}
