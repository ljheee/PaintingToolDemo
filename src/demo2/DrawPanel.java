package demo2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	DrawingFrame DFrame;

	/**
	 * ��ͼ���
	 * @param DFrame
	 */
	public DrawPanel(DrawingFrame DFrame){		
		//���ñ���ɫ�ʹ�С
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(550,350));
    	//����һ�����а���б���Ե�ı߿�
    	this.setBorder(BorderFactory.createLoweredBevelBorder());
        
        this.DFrame = DFrame;
		
	}

	/**
	 * ��дpaint����
	 */
	public void paint(Graphics g){
		
		super.paint(g);
		
		//ͨ��MyMouseAdapter�Ķ���ml������MyMouseAdapter��������MyList�Ķ���mylist��Ȼ��ֵ��һ��MyList�Ķ���ml
		MyList shape = DFrame.getMyMouseAdapter().getMyList();
		
		for(int i=0; i<shape.getLength(); i++){
			
			shape.getElement(i).draw(g);
			
		}
		
	}
	

}
