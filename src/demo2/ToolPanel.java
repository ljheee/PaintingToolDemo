package demo2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * 创建工具面板上的按钮集，并添加侦听
	 * @param toolsPanel
	 */
	public ToolPanel(final DrawingFrame DFrame){
		
        this.setBackground(new Color(240,240,240));
        this.setPreferredSize(new Dimension(66,200));
        //创建一个具有“浮雕化”外观效果的边框
        this.setBorder(BorderFactory.createEtchedBorder());

		
		//按钮数组
        String icons[] = {"star","dot_rect","eraser","fill","color_picker","magnifier","pencil",
        		"brush","air_brush","word","line","curve","rect","polygon","oval","round_rect"};
		//工具面板中的存放按钮的面板
    	JPanel tools_panel_button= new JPanel();
    	tools_panel_button.setBackground(new Color(240,240,240));
    	tools_panel_button.setPreferredSize(new Dimension(53, 210));
    	tools_panel_button.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));

		//创建按钮
	    for(int i=0; i<icons.length; i++){
	    	JButton jbutton = new JButton();
	    	//设置按钮图标
	    	jbutton.setIcon(new ImageIcon("images/" + icons[i] + ".jpg"));
	    	//设置按钮大小
	    	Icon icon = jbutton.getIcon();
	    	jbutton.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

	    	//添加按钮到工具面板	    	
	    	tools_panel_button.add(jbutton);
	    	this.add(tools_panel_button);
	    	
	    	//设置command
	    	jbutton.setActionCommand(icons[i]);
	    	
	    	//添加按钮侦听(内部类)
	    	ActionListener al = new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    			//将侦听所获得的e.getActionCommand()，传给DrawingFrame对象
	    			DFrame.setCommand_tools(e.getActionCommand());
	    		}
	    	};
	    	jbutton.addActionListener(al);

        }
	    
    	//设置粗细的大按钮
    	JButton big_button = new JButton();
    	big_button.setPreferredSize(new Dimension(45, 70));
    	big_button.setBackground(new Color(240,240,240));  	
    	//创建一个具有凹入斜面边缘的边框
    	big_button.setBorder(BorderFactory.createLoweredBevelBorder());
    	this.add(big_button);
		
	}	
}
