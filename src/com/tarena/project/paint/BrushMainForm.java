/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: 画图程序的主运行类。
  * Version					: 1.0
  * 1.	2008.10.12 	陈达     		新建
  **/

package com.tarena.project.paint;

import java.awt.BorderLayout;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *  画图程序的主运行类
 * 2008-10-12
 * @author		达内科技[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(建议) 
 */
public class BrushMainForm extends JFrame implements ActionListener{
	/**
	 *当前正在编辑的文件 
	 */
	private File file=null;
	private String title=((file==null||file.getName()==null)?"未命名":file.getName())+" - 画图";
	
	/**
	 * 工具栏的鼠标样式数组
	 */
	private Cursor[] cursors={
			MyCustomCursor.SELECT,MyCustomCursor.SELECT,
			MyCustomCursor.SELECT,MyCustomCursor.SPRAY,
			MyCustomCursor.BURET,MyCustomCursor.MAGNIFER,
			MyCustomCursor.PEN,MyCustomCursor.BRUSH,
			MyCustomCursor.FLUSH,MyCustomCursor.SELECT,
			MyCustomCursor.SELECT,MyCustomCursor.SELECT,
			MyCustomCursor.SELECT,MyCustomCursor.SELECT,
			MyCustomCursor.SELECT,MyCustomCursor.SELECT,
	};
	
	/**
	 * 菜单栏 
	 */
	private JMenuBar menubar=new JMenuBar();

	/**
	 * 菜单数组
	 */
	private JMenu []menus={
			new JMenu("文件(F)"),new JMenu("编辑(E)"),new JMenu("查看(V)"),new JMenu("图像(I)"),new JMenu("颜色(C)"),new JMenu("帮助(H)")
			
	};
	/**
	 * 设置菜单的快捷键数组
	 */
	private int []menu_acceler={
			KeyEvent.VK_F ,KeyEvent.VK_E ,KeyEvent.VK_V ,KeyEvent.VK_I ,KeyEvent.VK_C ,KeyEvent.VK_H
	};
	
	/**
	 * 菜单项数组
	 */
	private JMenuItem [][]items={
			{new JMenuItem("新建(N)"),new JMenuItem("打开(O)"),new JMenuItem("保存(S)"),new JMenuItem("另存为(A)"),new JMenuItem("退出(E)")},
			{new JMenuItem("复制(C)"),new JMenuItem("粘贴(V)"),new JMenuItem("剪贴(X)")},
			{new JRadioButtonMenuItem("工具箱",true),new JRadioButtonMenuItem("调色板",true),new JRadioButtonMenuItem("状态栏",true)},
			{new JMenuItem("翻转/旋转"),new JMenuItem("拉伸/扭曲"),new JMenuItem("反色"),new JMenuItem("属性")},
			{new JMenuItem("编辑颜色")},
			{new JMenuItem("帮助主题"),new JMenuItem("关于画图")}
	};
	
	/**
	 * 状态条
	 */
	private StatusBar statusbar=new StatusBar();
	
	
	/**
	 * 图形工具栏
	 */
	private ShapTool tools=new ShapTool();
	
	
	/**
	 * 画布
	 */
	private DrawCanvas canvas=null;
	private JPanel draw=new JPanel();
	
	/**
	 * 调色板
	 */
	private ColorPalette palette=new ColorPalette();
	
	/**
	 * 文件选择器
	 */
	private JFileChooser filechooser=new JFileChooser();
	
	/**
	 * 绘图缓冲区
	 */
	private DrawingBuffer drawingbuffer=new DrawingBuffer();	
		
	private JPanel bottom=new JPanel();
	
	/**
	 * 无参构造器。
	 */
	public BrushMainForm(){
		
		menuInit();		
		toolsInit();
		canvasInit();
		bottomInit();
		fileChooserInit();
		
		this.setSize(600,400);
		this.setTitle(title);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * 菜单的初始化。
	 */
	private void menuInit(){		
		char temp;
		for(int i=0;i<menus.length;i++){
			for(int j=0;j<items[i].length;j++){
				menus[i].add(items[i][j]);
				items[i][j].addActionListener(this);
				if((temp=findAccelerKey(items[i][j].getText()))!='0'){					
					items[i][j].setAccelerator(KeyStroke.getKeyStroke("control "+temp));
				}
			}
			menus[i].setMnemonic(menu_acceler[i]);
			menubar.add(menus[i]);
		}
		
		this.setJMenuBar(menubar);
	}
	
	/**
	 * 根据指定的文本得到快捷键。
	 */
	private char findAccelerKey(String text){
		if(!text.contains("(")){
			return '0';
		}
		return text.charAt(text.indexOf('(')+1);
	}
	/**
	 * 工具栏的初始化
	 */	
	private void toolsInit(){
		tools.setPreferredSize(new Dimension(60,0));
		this.add(tools,BorderLayout.WEST);
	}
	/**
	 * 画布的初始化函数。
	 */
	private void canvasInit(){
		canvas=new DrawCanvas(drawingbuffer.getBuffer());
		draw.setLayout(new BorderLayout());
		draw.add(canvas);
		this.add(new JScrollPane(draw),BorderLayout.CENTER);
		canvas.addMouseMotionListener(new MyMouseMotionListener());
		canvas.setSize(800, 600);
	}
	
	/**
	 * 底部面板的初始化
	 */
	private void bottomInit(){
		bottom.setLayout(new BorderLayout());
		bottom.add(palette,BorderLayout.CENTER);
		bottom.add(statusbar,BorderLayout.SOUTH);
		palette.setPreferredSize(new Dimension(0,40));		
		this.add(bottom,BorderLayout.SOUTH);
	}
	/**
	 * 文件选择器的初始化
	 */
	private void fileChooserInit(){
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		filechooser.setFileFilter(filter);
	}
	/**
	 * 画图的鼠标监听器。
	 * 当鼠标按下并移动时，负责图形的绘制。
	 * @author 达内科技
	 *
	 */
	class MyMouseMotionListener extends MouseMotionAdapter{
		/**
		 * 当鼠标拖动的时候，负责图形的绘制，以及工具栏坐标的更新。
		 */
		@Override
		public void mouseDragged(MouseEvent e) {
			statusbar.setShowPosition(e.getX(), e.getY());			
			Graphics2D g=drawingbuffer.getGraphics();
			g.setColor(palette.getColor());
			g.fillOval(e.getX(), e.getY(), 2, 2);
			canvas.repaint();
			BrushMainForm.this.canvas.setCursor(
					BrushMainForm.this.cursors[BrushMainForm.this.tools.getSelectIdx()]);
		}
		/**
		 * 当鼠标移动的时候负责工具栏坐标的更新。
		 */
		@Override
		public void mouseMoved(MouseEvent e) {
			statusbar.setShowPosition(e.getX(), e.getY());
			BrushMainForm.this.canvas.setCursor(
					BrushMainForm.this.cursors[BrushMainForm.this.tools.getSelectIdx()]);
		}
	
	}
	
	/**
	 * 菜单的事件监听，相应不同的菜单操作。
	 */
	public void actionPerformed(ActionEvent e) {
		//新建文件
		if(e.getSource()==items[0][0]){
			newFile();
		}
		//打开文件
		if(e.getSource()==items[0][1]){
			openFile();
		}
		//保存文件
		if(e.getSource()==items[0][2]){
			saveFile();
		}
		//文件另存为
		if(e.getSource()==items[0][3]){
			saveAs();
		}
		//退出程序
		if(e.getSource()==items[0][4]){
			System.exit(0);
		}
		//查看
		if(e.getSource()==items[2][0]){
			if(items[2][0].isSelected()){
				this.add(tools,BorderLayout.WEST);
			}else{
				this.remove(tools);				
			}
		}
		if(e.getSource()==items[2][1]){
			if(items[2][1].isSelected()){
				bottom.add(palette,BorderLayout.CENTER);
			}else{
				bottom.remove(palette);				
			}
		}
		if(e.getSource()==items[2][2]){
			if(items[2][2].isSelected()){
				bottom.add(statusbar,BorderLayout.SOUTH);
			}else{
				bottom.remove(statusbar);				
			}
		}
	}
	/**
	 * 打开一个文件。
	 */
	public void openFile(){	
		int returnVal = filechooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	      this.file=filechooser.getSelectedFile();
	    }
	    drawingbuffer.open(file);
	    canvas.repaint();
	    this.setTitle(file.getName()+" - "+"画图");

	}
	/**
	 * 新建一个文件的方法。
	 */
	public void newFile(){
		int operator=JOptionPane.showConfirmDialog(this, "是否保存文件？");
		if(operator==JOptionPane.CANCEL_OPTION){
			return ;
		}
		if(operator==JOptionPane.OK_OPTION){
			int returnVal=filechooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			     System.out.println(filechooser.getSelectedFile().getName());
			}
			
		}
		this.canvasInit();
	}
	/**
	 * 保存文件。
	 */
	public void saveFile(){
		if(file==null){			
			int returnVal=filechooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			    this.file=filechooser.getSelectedFile();
			}				
		}
		drawingbuffer.save(file);
		this.setTitle(((file==null||file.getName()==null)?"未命名":file.getName())+" - 画图");
	}
	/**
	 * 另存为文件。
	 */
	public void saveAs(){		
		int returnVal=filechooser.showSaveDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		    this.file=filechooser.getSelectedFile();
		}				
		drawingbuffer.save(file);
		this.setTitle(((file==null||file.getName()==null)?"未命名":file.getName())+" - 画图");
	}
	/**
	 * 画图运行的主函数。
	 * @param args
	 */
	public static void main(String[] args){
		new BrushMainForm();
	}
}
