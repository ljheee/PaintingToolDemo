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
	 * ������ɫ����ϵİ�ť�������������
	 * @param toolsPanel
	 */
	public ColorPanel(final DrawingFrame DFrame){
		
		//���ñ���ɫ�ʹ�С
        this.setBackground(new Color(240,240,240));
        this.setPreferredSize(new Dimension(300,50));
        //������ɫ���Ϊ��ʽ���֣�������Ϊ����룬ˮƽ���Ϊ0����ʾ�봰����߽����ţ�����ֱ���Ϊ7
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 4));
        //����һ�����С����񻯡����Ч���ı߿�
        this.setBorder(BorderFactory.createEtchedBorder());
        
		//��ɫ����
	    Color colors[] = {new Color(0,0,0),new Color(128,128,128),new Color(128,0,0),new Color(128,128,0),
	    		new Color(0,128,0),new Color(0,128,128),new Color(0,0,128),new Color(128,0,128),new Color(128,128,64),
	    		new Color(0,64,64),new Color(0,128,255),new Color(0,64,128),new Color(128,0,255),new Color(128,64,0),
	    		new Color(255,255,255),new Color(192,192,192),new Color(255,0,0),new Color(255,255,0),new Color(0,255,0),
	    		new Color(0,255,255),new Color(0,0,255),new Color(255,0,255),new Color(255,255,128),new Color(0,255,128),
	    		new Color(128,255,255),new Color(128,128,255),new Color(255,0,128),new Color(255,128,64)};
	    
		//��ɫ����еĴ�Ű�ť�����
    	JPanel color_panel_button= new JPanel();
    	color_panel_button.setBackground(new Color(240,240,240));
    	color_panel_button.setPreferredSize(new Dimension(250, 36));
    	color_panel_button.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
    	 	
    	//��ʾǰ��ɫ������ɫ�Ĵ�ť
    	JButton big_button = new JButton();
    	big_button.setPreferredSize(new Dimension(36, 36));
    	big_button.setBackground(new Color(240,240,240));  	
    	//����һ�����а���б���Ե�ı߿�
    	big_button.setBorder(BorderFactory.createLoweredBevelBorder());
    	

    	//��Ӱ�ť����ɫ���
    	this.add(big_button);
 
		//������ť
		for(int i=0; i<colors.length; i++){
	    	JButton jbutton = new JButton();
	    	//���ð�ť��ɫ
	    	jbutton.setBackground(colors[i]);
	    	//���ð�ť��С
	    	jbutton.setPreferredSize(new Dimension(15, 15));
	    	//����һ�����а���б���Ե�ı߿�
	    	jbutton.setBorder(BorderFactory.createLoweredBevelBorder());
	    	
	    	//��Ӱ�ť����ɫ���
	    	color_panel_button.add(jbutton);
	    	this.add(color_panel_button);
	    	
	    	//��Ӱ�ť����(�ڲ���)
	    	ActionListener al = new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    			//��ȡ��ť����ɫ�������û���Ϊ����ɫ
	    			DFrame. setCommand_colors(((JButton)e.getSource()).getBackground());
	    			
	    		}
	    	};
	    	jbutton.addActionListener(al);
			
		}
	}

	


}
