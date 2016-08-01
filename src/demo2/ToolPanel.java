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
	 * ������������ϵİ�ť�������������
	 * @param toolsPanel
	 */
	public ToolPanel(final DrawingFrame DFrame){
		
        this.setBackground(new Color(240,240,240));
        this.setPreferredSize(new Dimension(66,200));
        //����һ�����С����񻯡����Ч���ı߿�
        this.setBorder(BorderFactory.createEtchedBorder());

		
		//��ť����
        String icons[] = {"star","dot_rect","eraser","fill","color_picker","magnifier","pencil",
        		"brush","air_brush","word","line","curve","rect","polygon","oval","round_rect"};
		//��������еĴ�Ű�ť�����
    	JPanel tools_panel_button= new JPanel();
    	tools_panel_button.setBackground(new Color(240,240,240));
    	tools_panel_button.setPreferredSize(new Dimension(53, 210));
    	tools_panel_button.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));

		//������ť
	    for(int i=0; i<icons.length; i++){
	    	JButton jbutton = new JButton();
	    	//���ð�ťͼ��
	    	jbutton.setIcon(new ImageIcon("images/" + icons[i] + ".jpg"));
	    	//���ð�ť��С
	    	Icon icon = jbutton.getIcon();
	    	jbutton.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

	    	//��Ӱ�ť���������	    	
	    	tools_panel_button.add(jbutton);
	    	this.add(tools_panel_button);
	    	
	    	//����command
	    	jbutton.setActionCommand(icons[i]);
	    	
	    	//��Ӱ�ť����(�ڲ���)
	    	ActionListener al = new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    			//����������õ�e.getActionCommand()������DrawingFrame����
	    			DFrame.setCommand_tools(e.getActionCommand());
	    		}
	    	};
	    	jbutton.addActionListener(al);

        }
	    
    	//���ô�ϸ�Ĵ�ť
    	JButton big_button = new JButton();
    	big_button.setPreferredSize(new Dimension(45, 70));
    	big_button.setBackground(new Color(240,240,240));  	
    	//����һ�����а���б���Ե�ı߿�
    	big_button.setBorder(BorderFactory.createLoweredBevelBorder());
    	this.add(big_button);
		
	}	
}
