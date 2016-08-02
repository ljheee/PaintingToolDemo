/**
  * @(#)BrushMainForm.java  2008.10.12  
  * Copy Right Information	: Tarena
  * JDK version used		: jdk1.6.0_02
  * Comments				: ��ͼ������������ࡣ
  * Version					: 1.0
  * 1.	2008.10.12 	�´�     		�½�
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
 *  ��ͼ�������������
 * 2008-10-12
 * @author		���ڿƼ�[Tarena Training Group]
 * @version 	1.0
 * @since		JDK1.6(����) 
 */
public class BrushMainForm extends JFrame implements ActionListener{
	/**
	 *��ǰ���ڱ༭���ļ� 
	 */
	private File file=null;
	private String title=((file==null||file.getName()==null)?"δ����":file.getName())+" - ��ͼ";
	
	/**
	 * �������������ʽ����
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
	 * �˵��� 
	 */
	private JMenuBar menubar=new JMenuBar();

	/**
	 * �˵�����
	 */
	private JMenu []menus={
			new JMenu("�ļ�(F)"),new JMenu("�༭(E)"),new JMenu("�鿴(V)"),new JMenu("ͼ��(I)"),new JMenu("��ɫ(C)"),new JMenu("����(H)")
			
	};
	/**
	 * ���ò˵��Ŀ�ݼ�����
	 */
	private int []menu_acceler={
			KeyEvent.VK_F ,KeyEvent.VK_E ,KeyEvent.VK_V ,KeyEvent.VK_I ,KeyEvent.VK_C ,KeyEvent.VK_H
	};
	
	/**
	 * �˵�������
	 */
	private JMenuItem [][]items={
			{new JMenuItem("�½�(N)"),new JMenuItem("��(O)"),new JMenuItem("����(S)"),new JMenuItem("���Ϊ(A)"),new JMenuItem("�˳�(E)")},
			{new JMenuItem("����(C)"),new JMenuItem("ճ��(V)"),new JMenuItem("����(X)")},
			{new JRadioButtonMenuItem("������",true),new JRadioButtonMenuItem("��ɫ��",true),new JRadioButtonMenuItem("״̬��",true)},
			{new JMenuItem("��ת/��ת"),new JMenuItem("����/Ť��"),new JMenuItem("��ɫ"),new JMenuItem("����")},
			{new JMenuItem("�༭��ɫ")},
			{new JMenuItem("��������"),new JMenuItem("���ڻ�ͼ")}
	};
	
	/**
	 * ״̬��
	 */
	private StatusBar statusbar=new StatusBar();
	
	
	/**
	 * ͼ�ι�����
	 */
	private ShapTool tools=new ShapTool();
	
	
	/**
	 * ����
	 */
	private DrawCanvas canvas=null;
	private JPanel draw=new JPanel();
	
	/**
	 * ��ɫ��
	 */
	private ColorPalette palette=new ColorPalette();
	
	/**
	 * �ļ�ѡ����
	 */
	private JFileChooser filechooser=new JFileChooser();
	
	/**
	 * ��ͼ������
	 */
	private DrawingBuffer drawingbuffer=new DrawingBuffer();	
		
	private JPanel bottom=new JPanel();
	
	/**
	 * �޲ι�������
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
	 * �˵��ĳ�ʼ����
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
	 * ����ָ�����ı��õ���ݼ���
	 */
	private char findAccelerKey(String text){
		if(!text.contains("(")){
			return '0';
		}
		return text.charAt(text.indexOf('(')+1);
	}
	/**
	 * �������ĳ�ʼ��
	 */	
	private void toolsInit(){
		tools.setPreferredSize(new Dimension(60,0));
		this.add(tools,BorderLayout.WEST);
	}
	/**
	 * �����ĳ�ʼ��������
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
	 * �ײ����ĳ�ʼ��
	 */
	private void bottomInit(){
		bottom.setLayout(new BorderLayout());
		bottom.add(palette,BorderLayout.CENTER);
		bottom.add(statusbar,BorderLayout.SOUTH);
		palette.setPreferredSize(new Dimension(0,40));		
		this.add(bottom,BorderLayout.SOUTH);
	}
	/**
	 * �ļ�ѡ�����ĳ�ʼ��
	 */
	private void fileChooserInit(){
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		filechooser.setFileFilter(filter);
	}
	/**
	 * ��ͼ������������
	 * ����갴�²��ƶ�ʱ������ͼ�εĻ��ơ�
	 * @author ���ڿƼ�
	 *
	 */
	class MyMouseMotionListener extends MouseMotionAdapter{
		/**
		 * ������϶���ʱ�򣬸���ͼ�εĻ��ƣ��Լ�����������ĸ��¡�
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
		 * ������ƶ���ʱ���𹤾�������ĸ��¡�
		 */
		@Override
		public void mouseMoved(MouseEvent e) {
			statusbar.setShowPosition(e.getX(), e.getY());
			BrushMainForm.this.canvas.setCursor(
					BrushMainForm.this.cursors[BrushMainForm.this.tools.getSelectIdx()]);
		}
	
	}
	
	/**
	 * �˵����¼���������Ӧ��ͬ�Ĳ˵�������
	 */
	public void actionPerformed(ActionEvent e) {
		//�½��ļ�
		if(e.getSource()==items[0][0]){
			newFile();
		}
		//���ļ�
		if(e.getSource()==items[0][1]){
			openFile();
		}
		//�����ļ�
		if(e.getSource()==items[0][2]){
			saveFile();
		}
		//�ļ����Ϊ
		if(e.getSource()==items[0][3]){
			saveAs();
		}
		//�˳�����
		if(e.getSource()==items[0][4]){
			System.exit(0);
		}
		//�鿴
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
	 * ��һ���ļ���
	 */
	public void openFile(){	
		int returnVal = filechooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	      this.file=filechooser.getSelectedFile();
	    }
	    drawingbuffer.open(file);
	    canvas.repaint();
	    this.setTitle(file.getName()+" - "+"��ͼ");

	}
	/**
	 * �½�һ���ļ��ķ�����
	 */
	public void newFile(){
		int operator=JOptionPane.showConfirmDialog(this, "�Ƿ񱣴��ļ���");
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
	 * �����ļ���
	 */
	public void saveFile(){
		if(file==null){			
			int returnVal=filechooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			    this.file=filechooser.getSelectedFile();
			}				
		}
		drawingbuffer.save(file);
		this.setTitle(((file==null||file.getName()==null)?"δ����":file.getName())+" - ��ͼ");
	}
	/**
	 * ���Ϊ�ļ���
	 */
	public void saveAs(){		
		int returnVal=filechooser.showSaveDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		    this.file=filechooser.getSelectedFile();
		}				
		drawingbuffer.save(file);
		this.setTitle(((file==null||file.getName()==null)?"δ����":file.getName())+" - ��ͼ");
	}
	/**
	 * ��ͼ���е���������
	 * @param args
	 */
	public static void main(String[] args){
		new BrushMainForm();
	}
}
