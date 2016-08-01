package demo2;

import java.awt.event.*;
import java.awt.*;

//继承抽象类MouseAdapter
public class MyMouseAdapter extends MouseAdapter{
	//私有字段
	private Graphics g;
	private String command_tools;
	private int x1,x2,y1,y2;
	private int click_X1,click_Y1,click_X2,click_Y2;
	private int first_X,first_Y;       //用于多边形记录第一次点击时的坐标
	private int flag_FirstClick = 0;   //用于多边形第一点击
	
	private DrawingFrame df;	
	private MyList mylist = new MyList();
	private Shape shape;
	
	/**
	 * 构造方法，接收DrawingFrame对象
	 * @param df
	 */
	public MyMouseAdapter(DrawingFrame df){
		this.df = df; 				   
		//创建画布,getGraphicss()为DrawingFrame类的一个方法，用于得到画图面板的Graphics对象
		this.g = df.getGraphicss();	
	}
	
	/**
	 * 得到MyList对象mylist
	 */
	public MyList getMyList(){
		return mylist;
	}
	
				
	/**
	 * 1.鼠标按下
	 */
	public void mousePressed(MouseEvent e){			
		//得到鼠标按下时的坐标
		x1 = e.getX();
		y1 = e.getY();
		
	}
	
	
	/**
	 * 2.鼠标释放
	 */
	public void mouseReleased(MouseEvent e) {
		//获取按钮值
		this.command_tools = df.getCommand_tools();	
	
		x2 = e.getX();
		y2 = e.getY();	
				
 		//直线   （"直线".equals(command) -> 防止出现NullPointException）
 		if("line".equals(command_tools)){
 			shape = new Line(x1, y1, x2, y2, df.getCommand_colors());
 	 		shape.draw(g);
 	 		mylist.addElement(shape);			
 			 										
		}		
		//矩形
		else if("rect".equals(command_tools)){		
 			shape = new Rect(x1, y1, x2, y2, df.getCommand_colors());
 	 		shape.draw(g);
 	 		mylist.addElement(shape);											
		}		
		//椭圆
		else if("oval".equals(command_tools)){			
 			shape = new Oval(x1, y1, x2, y2, df.getCommand_colors());
 	 		shape.draw(g);
 	 		mylist.addElement(shape); 											
		}	
 		
		//多边形（第一次释放）
		if("polygon".equals(command_tools) && flag_FirstClick==0){
			
			//第一条直线
 			shape = new Line(x1, y1, x2, y2, df.getCommand_colors());
 			shape.draw(g);
 			mylist.addElement(shape);
 			
			//修改标志位
			flag_FirstClick = 1;	
																			
			//记录第一次按下的坐标
			first_X = x1;
			first_Y = y1;	

			click_X1 = x2;
		    click_Y1 = y2;
		  
		}		
	
	}	
	
		
	/**
	 * 3.鼠标点击（释放后执行）
	 */
	public void mouseClicked(MouseEvent e){
		//获取按钮值
		this.command_tools = df.getCommand_tools();
		
     	click_X2 = e.getX();
		click_Y2 = e.getY();	
 		
		//单击
		if(e.getClickCount()==1){
			//多边形
			if("polygon".equals(command_tools) && flag_FirstClick==1){
				
				//始终与第一个点进行比较，如果相差为2个像素之内，表示画完了
				int x = Math.abs(x1-first_X);
				int y = Math.abs(y1-first_Y);
				
	 			shape = new Line(click_X1, click_Y1, click_X2, click_Y2, df.getCommand_colors());
	 			shape.draw(g);
	 			mylist.addElement(shape);
	 			
				//矩形已画完,修改标志位
				if(x<2 && y<2){
					//重置标志位
					flag_FirstClick = 0;
		    }							
		  }			
		}	
		//保存前一坐标
		click_X1 = click_X2;
		click_Y1 = click_Y2;
		
		//双击
		if(e.getClickCount()==2){
			//多边形闭合
			if("polygon".equals(command_tools) && flag_FirstClick==1){

	 			shape = new Line(first_X, first_Y, click_X2, click_Y2, df.getCommand_colors());
	 			shape.draw(g);
	 			mylist.addElement(shape);
	 			
				//已画完，标志位置零
				flag_FirstClick = 0;
			}
			
		}
						
	}	
		
	
    /**
     * 4.鼠标拖拽（鼠标按下并移动时，不断触发，直到鼠标释放）
     */
    public void mouseDragged(MouseEvent e){
		//获取按钮值
		this.command_tools = df.getCommand_tools();
		
		//铅笔
		if("pencil".equals(command_tools)){	
			//其后的n次点击
			x2 = e.getX();
			y2 = e.getY();
			
			//铅笔由n条直线组成
			shape = new Line(x1, y1, x2, y2, df.getCommand_colors());
			shape.draw(g);
			mylist.addElement(shape);
				
			//交换坐标
			x1 = x2;
			y1 = y2;
	
		}
	}	
    
    /**
     * 鼠标移动
     */
    public void mouseMoved(MouseEvent e){
    	
		String x = e.getX()+"";
		String y = e.getY()+"";

		String info =" " + x + "," + y;
		StatePanel.setMouseInfo(info);
		
    }


	
}