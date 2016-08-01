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
	 * 画图面板
	 * @param DFrame
	 */
	public DrawPanel(DrawingFrame DFrame){		
		//设置背景色和大小
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(550,350));
    	//创建一个具有凹入斜面边缘的边框
    	this.setBorder(BorderFactory.createLoweredBevelBorder());
        
        this.DFrame = DFrame;
		
	}

	/**
	 * 重写paint方法
	 */
	public void paint(Graphics g){
		
		super.paint(g);
		
		//通过MyMouseAdapter的对象ml调用在MyMouseAdapter中声明的MyList的对象mylist，然后赋值给一个MyList的对象ml
		MyList shape = DFrame.getMyMouseAdapter().getMyList();
		
		for(int i=0; i<shape.getLength(); i++){
			
			shape.getElement(i).draw(g);
			
		}
		
	}
	

}
