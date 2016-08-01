package demo2;

import java.awt.event.*;
import java.awt.*;

//�̳г�����MouseAdapter
public class MyMouseAdapter extends MouseAdapter{
	//˽���ֶ�
	private Graphics g;
	private String command_tools;
	private int x1,x2,y1,y2;
	private int click_X1,click_Y1,click_X2,click_Y2;
	private int first_X,first_Y;       //���ڶ���μ�¼��һ�ε��ʱ������
	private int flag_FirstClick = 0;   //���ڶ���ε�һ���
	
	private DrawingFrame df;	
	private MyList mylist = new MyList();
	private Shape shape;
	
	/**
	 * ���췽��������DrawingFrame����
	 * @param df
	 */
	public MyMouseAdapter(DrawingFrame df){
		this.df = df; 				   
		//��������,getGraphicss()ΪDrawingFrame���һ�����������ڵõ���ͼ����Graphics����
		this.g = df.getGraphicss();	
	}
	
	/**
	 * �õ�MyList����mylist
	 */
	public MyList getMyList(){
		return mylist;
	}
	
				
	/**
	 * 1.��갴��
	 */
	public void mousePressed(MouseEvent e){			
		//�õ���갴��ʱ������
		x1 = e.getX();
		y1 = e.getY();
		
	}
	
	
	/**
	 * 2.����ͷ�
	 */
	public void mouseReleased(MouseEvent e) {
		//��ȡ��ťֵ
		this.command_tools = df.getCommand_tools();	
	
		x2 = e.getX();
		y2 = e.getY();	
				
 		//ֱ��   ��"ֱ��".equals(command) -> ��ֹ����NullPointException��
 		if("line".equals(command_tools)){
 			shape = new Line(x1, y1, x2, y2, df.getCommand_colors());
 	 		shape.draw(g);
 	 		mylist.addElement(shape);			
 			 										
		}		
		//����
		else if("rect".equals(command_tools)){		
 			shape = new Rect(x1, y1, x2, y2, df.getCommand_colors());
 	 		shape.draw(g);
 	 		mylist.addElement(shape);											
		}		
		//��Բ
		else if("oval".equals(command_tools)){			
 			shape = new Oval(x1, y1, x2, y2, df.getCommand_colors());
 	 		shape.draw(g);
 	 		mylist.addElement(shape); 											
		}	
 		
		//����Σ���һ���ͷţ�
		if("polygon".equals(command_tools) && flag_FirstClick==0){
			
			//��һ��ֱ��
 			shape = new Line(x1, y1, x2, y2, df.getCommand_colors());
 			shape.draw(g);
 			mylist.addElement(shape);
 			
			//�޸ı�־λ
			flag_FirstClick = 1;	
																			
			//��¼��һ�ΰ��µ�����
			first_X = x1;
			first_Y = y1;	

			click_X1 = x2;
		    click_Y1 = y2;
		  
		}		
	
	}	
	
		
	/**
	 * 3.��������ͷź�ִ�У�
	 */
	public void mouseClicked(MouseEvent e){
		//��ȡ��ťֵ
		this.command_tools = df.getCommand_tools();
		
     	click_X2 = e.getX();
		click_Y2 = e.getY();	
 		
		//����
		if(e.getClickCount()==1){
			//�����
			if("polygon".equals(command_tools) && flag_FirstClick==1){
				
				//ʼ�����һ������бȽϣ�������Ϊ2������֮�ڣ���ʾ������
				int x = Math.abs(x1-first_X);
				int y = Math.abs(y1-first_Y);
				
	 			shape = new Line(click_X1, click_Y1, click_X2, click_Y2, df.getCommand_colors());
	 			shape.draw(g);
	 			mylist.addElement(shape);
	 			
				//�����ѻ���,�޸ı�־λ
				if(x<2 && y<2){
					//���ñ�־λ
					flag_FirstClick = 0;
		    }							
		  }			
		}	
		//����ǰһ����
		click_X1 = click_X2;
		click_Y1 = click_Y2;
		
		//˫��
		if(e.getClickCount()==2){
			//����αպ�
			if("polygon".equals(command_tools) && flag_FirstClick==1){

	 			shape = new Line(first_X, first_Y, click_X2, click_Y2, df.getCommand_colors());
	 			shape.draw(g);
	 			mylist.addElement(shape);
	 			
				//�ѻ��꣬��־λ����
				flag_FirstClick = 0;
			}
			
		}
						
	}	
		
	
    /**
     * 4.�����ק����갴�²��ƶ�ʱ�����ϴ�����ֱ������ͷţ�
     */
    public void mouseDragged(MouseEvent e){
		//��ȡ��ťֵ
		this.command_tools = df.getCommand_tools();
		
		//Ǧ��
		if("pencil".equals(command_tools)){	
			//����n�ε��
			x2 = e.getX();
			y2 = e.getY();
			
			//Ǧ����n��ֱ�����
			shape = new Line(x1, y1, x2, y2, df.getCommand_colors());
			shape.draw(g);
			mylist.addElement(shape);
				
			//��������
			x1 = x2;
			y1 = y2;
	
		}
	}	
    
    /**
     * ����ƶ�
     */
    public void mouseMoved(MouseEvent e){
    	
		String x = e.getX()+"";
		String y = e.getY()+"";

		String info =" " + x + "," + y;
		StatePanel.setMouseInfo(info);
		
    }


	
}