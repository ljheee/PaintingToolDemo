package demo2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * 创建颜色面板上的按钮集，并添加侦听
	 * @param toolsPanel
	 */
	public ColorPanel(final DrawingFrame DFrame){
		
		//设置背景色和大小
        this.setBackground(new Color(240,240,240));
        this.setPreferredSize(new Dimension(300,50));
        //设置颜色面板为流式布局，并设置为左对齐，水平间距为0（表示与窗口左边紧贴着），垂直间距为7
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 4));
        //创建一个具有“浮雕化”外观效果的边框
        this.setBorder(BorderFactory.createEtchedBorder());
        
		//颜色数组
	    Color colors[] = {new Color(0,0,0),new Color(128,128,128),new Color(128,0,0),new Color(128,128,0),
	    		new Color(0,128,0),new Color(0,128,128),new Color(0,0,128),new Color(128,0,128),new Color(128,128,64),
	    		new Color(0,64,64),new Color(0,128,255),new Color(0,64,128),new Color(128,0,255),new Color(128,64,0),
	    		new Color(255,255,255),new Color(192,192,192),new Color(255,0,0),new Color(255,255,0),new Color(0,255,0),
	    		new Color(0,255,255),new Color(0,0,255),new Color(255,0,255),new Color(255,255,128),new Color(0,255,128),
	    		new Color(128,255,255),new Color(128,128,255),new Color(255,0,128),new Color(255,128,64)};
	    
		//颜色面板中的存放按钮的面板
    	JPanel color_panel_button= new JPanel();
    	color_panel_button.setBackground(new Color(240,240,240));
    	color_panel_button.setPreferredSize(new Dimension(250, 36));
    	color_panel_button.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
    	 	
    	//显示前景色、背景色的大按钮
    	JButton big_button = new JButton();
    	big_button.setPreferredSize(new Dimension(36, 36));
    	big_button.setBackground(new Color(240,240,240));  	
    	//创建一个具有凹入斜面边缘的边框
    	big_button.setBorder(BorderFactory.createLoweredBevelBorder());
    	

    	//添加按钮到颜色面板
    	this.add(big_button);
 
		//创建按钮
		for(int i=0; i<colors.length; i++){
	    	JButton jbutton = new JButton();
	    	//设置按钮颜色
	    	jbutton.setBackground(colors[i]);
	    	//设置按钮大小
	    	jbutton.setPreferredSize(new Dimension(15, 15));
	    	//创建一个具有凹入斜面边缘的边框
	    	jbutton.setBorder(BorderFactory.createLoweredBevelBorder());
	    	
	    	//添加按钮到颜色面板
	    	color_panel_button.add(jbutton);
	    	this.add(color_panel_button);
	    	
	    	//添加按钮侦听(内部类)
	    	ActionListener al = new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    			//获取按钮背景色，并设置画笔为此颜色
	    			DFrame. setCommand_colors(((JButton)e.getSource()).getBackground());
	    			
	    		}
	    	};
	    	jbutton.addActionListener(al);
			
		}
	}

	


}
