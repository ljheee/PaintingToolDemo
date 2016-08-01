package demo2;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//����ֵ
	private Graphics graphics;
	private String command_tools = "pencil";
	private Color command_colors = Color.BLACK;
	private MyMouseAdapter ma;  

	
	/**
	 * ��ʾ������
	 */
	public void showUI(){	
		
		//���������ڵķ���
		setMainFrame();
		
		//�����˵���
		JMenuBar bar = new MenuBar();
		this.setJMenuBar(bar);	
		       
        //��๤�����  
        JPanel tools_panel = new ToolPanel(this);
        this.add(tools_panel, new GBC(0, 0).setFill(GBC.VERTICAL).setWeight(0, 100));
        
        //�Ҳ��ͼ���  
        JPanel draw_panel = new DrawPanel(this);
        this.add(draw_panel, new GBC(1, 0).setAnchor(GBC.NORTHWEST));        
        
        //�²���ɫѡ�����  
        JPanel color_panel = new ColorPanel(this);
        this.add(color_panel, new GBC(0, 1, 2, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0));    
        
        //�²�״̬���  
        JPanel state_panel = new StatePanel();
        this.add(state_panel, new GBC(0, 2, 2, 1).setFill(GBC.BOTH).setWeight(100, 0));

			
		
		//���������ڿɼ�
		this.setVisible(true);
		
        //�õ���ͼ���(�õ�����Ҫ�ڿɼ�֮��)
        graphics = draw_panel.getGraphics();
        		
		//��궯����Ҫ�ڵõ�����֮����Ϊ�������ִֻ��һ�Σ�Ӧ���õ��Ļ������ݹ�ȥ��
		ma = new MyMouseAdapter(this);
		
		//�˴�һ��Ҫ�ǶԻ滭����������
		draw_panel.addMouseListener(ma);
		draw_panel.addMouseMotionListener(ma);
							
	}

	/**
	 * ���������ڵķ���
	 */
	private void setMainFrame() {
		//����������
		this.setSize(850, 600);		
		this.setMinimumSize(new Dimension(635,490));
		this.setTitle("��ͼ��");	
		//������Ǽ���JFrame��Container�����ϵģ�����Ӧ�����õ���container�ı���
		this.getContentPane().setBackground(Color.LIGHT_GRAY);		
		//����������ͼ��
		this.setIconImage(new ImageIcon("images/icon.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		//������������Ϊ���������
		this.setLayout(new GridBagLayout());
	}
	
	
	//get��set����
	
	/**
	 * �õ�graphics
	 * Ӧע�⣬��Ҫ��ϵͳ�ķ�������
	 */
	public Graphics getGraphicss() {
		return graphics;
	}
	/**
	 * ����graphics
	 * @param graphics
	 */
	public void setGraphicss(Graphics graphics) {
		this.graphics = graphics;
	}


	/**
	 * �õ�command_tools
	 */
	public String getCommand_tools() {
		return command_tools;
	}
	/**
	 * ����command_tools
	 * @param command_tools
	 */
	public void setCommand_tools(String command_tools) {
		this.command_tools = command_tools;
	}



	/**
	 * �õ�command_colors
	 */
	public Color getCommand_colors() {
		return command_colors;
	}	
	/**
	 * ����command_colors
	 * @param command_colors
	 */
	public void setCommand_colors(Color command_colors) {
		this.command_colors = command_colors;
	}

	/**
	 * �õ� MyMouseAdapter����ma
	 */
	public MyMouseAdapter getMyMouseAdapter(){
		return ma;
	}
	
}
