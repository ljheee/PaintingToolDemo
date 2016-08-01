package demo2;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//属性值
	private Graphics graphics;
	private String command_tools = "pencil";
	private Color command_colors = Color.BLACK;
	private MyMouseAdapter ma;  

	
	/**
	 * 显示主窗口
	 */
	public void showUI(){	
		
		//设置主窗口的方法
		setMainFrame();
		
		//创建菜单栏
		JMenuBar bar = new MenuBar();
		this.setJMenuBar(bar);	
		       
        //左侧工具面板  
        JPanel tools_panel = new ToolPanel(this);
        this.add(tools_panel, new GBC(0, 0).setFill(GBC.VERTICAL).setWeight(0, 100));
        
        //右侧绘图面板  
        JPanel draw_panel = new DrawPanel(this);
        this.add(draw_panel, new GBC(1, 0).setAnchor(GBC.NORTHWEST));        
        
        //下侧颜色选择面板  
        JPanel color_panel = new ColorPanel(this);
        this.add(color_panel, new GBC(0, 1, 2, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0));    
        
        //下侧状态面板  
        JPanel state_panel = new StatePanel();
        this.add(state_panel, new GBC(0, 2, 2, 1).setFill(GBC.BOTH).setWeight(100, 0));

			
		
		//设置主窗口可见
		this.setVisible(true);
		
        //得到绘图面板(得到画布要在可见之后)
        graphics = draw_panel.getGraphics();
        		
		//鼠标动作（要在得到画布之后，因为以下语句只执行一次，应将得到的画布传递过去）
		ma = new MyMouseAdapter(this);
		
		//此处一定要是对绘画面板添加侦听
		draw_panel.addMouseListener(ma);
		draw_panel.addMouseMotionListener(ma);
							
	}

	/**
	 * 设置主窗口的方法
	 */
	private void setMainFrame() {
		//设置主窗口
		this.setSize(850, 600);		
		this.setMinimumSize(new Dimension(635,490));
		this.setTitle("画图板");	
		//组件都是加在JFrame的Container对象上的，所以应该设置的是container的背景
		this.getContentPane().setBackground(Color.LIGHT_GRAY);		
		//设置主窗口图标
		this.setIconImage(new ImageIcon("images/icon.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		//将主窗口设置为网格包布局
		this.setLayout(new GridBagLayout());
	}
	
	
	//get和set方法
	
	/**
	 * 得到graphics
	 * 应注意，不要与系统的方法重名
	 */
	public Graphics getGraphicss() {
		return graphics;
	}
	/**
	 * 设置graphics
	 * @param graphics
	 */
	public void setGraphicss(Graphics graphics) {
		this.graphics = graphics;
	}


	/**
	 * 得到command_tools
	 */
	public String getCommand_tools() {
		return command_tools;
	}
	/**
	 * 设置command_tools
	 * @param command_tools
	 */
	public void setCommand_tools(String command_tools) {
		this.command_tools = command_tools;
	}



	/**
	 * 得到command_colors
	 */
	public Color getCommand_colors() {
		return command_colors;
	}	
	/**
	 * 设置command_colors
	 * @param command_colors
	 */
	public void setCommand_colors(Color command_colors) {
		this.command_colors = command_colors;
	}

	/**
	 * 得到 MyMouseAdapter对象ma
	 */
	public MyMouseAdapter getMyMouseAdapter(){
		return ma;
	}
	
}
