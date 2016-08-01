package paintingDemo1;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;



public class MyPainting extends JFrame     //���࣬��չ��JFrame�࣬��������������
 {
  private ObjectInputStream  input;
  private ObjectOutputStream output; //����������������������úͱ���ͼ���ļ�

  private JButton choices[];         //��ť���飬����������ƵĹ��ܰ�ť

  private String names[]={
          "�½�",
          "��",
          "����",    //�������ǻ���������ť������"�½�"��"��"��"����"

        /*�����������ǵĻ�ͼ�������еĻ����ļ�����ͼ��Ԫ��ť*/

          "Ǧ��",		//Ǧ�ʻ���Ҳ����������϶��������ͼ
          "ֱ��",		//����ֱ��
          "���ľ���",		//���ƿ��ľ���
          "ʵ�ľ���",		//������ָ����ɫ����ʵ�ľ���
          "��Բ",		//���ƿ�����Բ
          "ʵ����Բ",		//������ָ����ɫ����ʵ����Բ
          "Բ",		//����Բ��
          "ʵ��Բ",	//������ָ����ɫ����ʵ��Բ��
          "Բ�Ǿ���",	//���ƿ���Բ�Ǿ���
          "ʵ��Բ�Ǿ���",		//������ָ����ɫ����ʵ��Բ�Ǿ���
          "��Ƥ��",		//��Ƥ������������ȥ�Ѿ����ƺõ�ͼ��
          "��ɫ",		//ѡ����ɫ��ť��������ѡ����Ҫ����ɫ
          "������ϸ",		//ѡ��������ϸ�İ�ť��������Ҫ����ֵ����ʵ�ֻ�ͼ������ϸ�ı仯
          "��������"		//�������ְ�ť�������ڻ�ͼ����ʵ����������
          };

  private String styleNames[]={
            " ���� " , " ���� " , " ���Ĳ��� " , " ����_GB2312 " , " �����п� " ,
            " �������� " , " Times New Roman " , " Serif " , " Monospaced " ,
            " SonsSerif " , " Garamond "
            };            //�ɹ�ѡ���������
                          //��Ȼ��������Ľṹ�����ö����Լ��������ϵͳ֧�ֵ�����

  private Icon items[];

  private String tipText[]={
                  //����������ƶ�����Ӧ��ť������ͣ��ʱ��������ʾ˵����
                  //���߿��Բ�������İ�ť������������
                "�½�һ����ͼ",
                "���ѱ���ͼ��",
                "��������ͼ��",
                "����϶����⻭",
                "����һ��ֱ��",
                "���ƿ��ľ���",
                "������ָ����ɫ����ʵ����Բ",
                "���ƿ�����Բ",
                "������ָ����ɫ����ʵ����Բ",
                "����Բ��",
                "������ָ����ɫ����ʵ��Բ��",
                "���ƿ���Բ�Ǿ���",
                "������ָ����ɫ����ʵ��Բ�Ǿ���",
                "��Ƥ������������ȥ�Ѿ����ƺõ�ͼ��",
                "ѡ����ɫ��ť��������ѡ����Ҫ����ɫ",
                "ѡ��������ϸ�İ�ť",
                "�������ְ�ť"
              };

  JToolBar buttonPanel ;      //���尴ť���
  JToolBar wordPanel;          //�������
  private JLabel statusBar;            //��ʾ���״̬����ʾ��

  private DrawPanel drawingArea;       //��ͼ����
  private int width=800,height=550;    //���廭ͼ�����ʼ��С

  drawings[] itemList=new drawings[5000]; //������Ż���ͼ�ε�����
  private int currentChoice=3;            //����Ĭ�ϻ�ͼ״̬Ϊ��ʻ�
  int index=0;                         //��ǰ�Ѿ����Ƶ�ͼ����Ŀ
  private Color color=Color.black;     //��ǰ������ɫ
  int R,G,B;                           //������ŵ�ǰɫ��ֵ

  private GridLayout grid1;  //button��ͼ������
  int f1,f2;                  //������ŵ�ǰ������
  String style1;              //������ŵ�ǰ����
  private float stroke=1.0f;  //���û��ʴ�ϸ��Ĭ��ֵΪ1.0f

  JCheckBox bold,italic;      //����������ѡ���
                              //boldΪ���壬italicΪб�壬���߿���ͬʱʹ��
  JComboBox styles;

  public MyPainting()        //���캯��
  {
   super("Transome�Ļ�ͼ����");
   JMenuBar bar=new JMenuBar();		//����˵���
   JMenu fileMenu=new JMenu("�ļ���F��");
   fileMenu.setMnemonic('F');

//�½��ļ��˵���
   JMenuItem newItem=new JMenuItem("�½���N��");
   newItem.setMnemonic('N');
   newItem.addActionListener(
          new ActionListener(){
                  public void actionPerformed(ActionEvent e)
                  {
                   newFile();		//�����������������½��ļ�������
                  }
          }
   );
   fileMenu.add(newItem);

//�����ļ��˵���
   JMenuItem saveItem=new JMenuItem("���棨S��");
   saveItem.setMnemonic('S');
   saveItem.addActionListener(
          new ActionListener(){
                  public void actionPerformed(ActionEvent e)
                  {
                   saveFile();		//���������������ñ����ļ�������
                  }
          }
   );
   fileMenu.add(saveItem);

//���ļ��˵���
   JMenuItem loadItem=new JMenuItem("�򿪣�L��");
   loadItem.setMnemonic('L');
   loadItem.addActionListener(
          new ActionListener(){
                  public void actionPerformed(ActionEvent e)
                  {
                   loadFile();		//���������������ô��ļ�������
                  }
          }
   );
   fileMenu.add(loadItem);

   fileMenu.addSeparator();

//�˳��˵���
   JMenuItem exitItem=new JMenuItem("�˳���X��");
   exitItem.setMnemonic('X');
   exitItem.addActionListener(
          new ActionListener(){
                  public void actionPerformed(ActionEvent e)
                  {
                   System.exit(0);	//��������������˳���ͼ�����
                  }
          }
   );
   fileMenu.add(exitItem);
   bar.add(fileMenu);

//������ɫ�˵���
   JMenu colorMenu=new JMenu("��ɫ��C��");
   colorMenu.setMnemonic('C');

//ѡ����ɫ�˵���
   JMenuItem colorItem=new JMenuItem("��ɫѡ��O��");
   colorItem.setMnemonic('O');
   colorItem.addActionListener(
           new ActionListener(){
                   public void actionPerformed(ActionEvent e)
                   {
                    chooseColor();	//����������������ѡ����ɫ������
                   }
       }
      );
   colorMenu.add(colorItem);
   bar.add(colorMenu);

//����������ϸ�˵���
    JMenu strokeMenu=new JMenu("������S��");
    strokeMenu.setMnemonic('S');

//����������ϸ�˵���
    JMenuItem strokeItem=new JMenuItem("����������ϸ��K��");
    strokeItem.setMnemonic('K');
    strokeItem.addActionListener(
           new ActionListener(){
                   public void actionPerformed(ActionEvent e)
                    {
                     setStroke();
                     }
                   }
              );
           strokeMenu.add(strokeItem);
           bar.add(strokeMenu);

//������ʾ�˵���
    JMenu helpMenu=new JMenu("������H��");
    helpMenu.setMnemonic('H');

//������ʾ�˵���
    JMenuItem aboutItem=new JMenuItem("���ڻ�ͼ��A��");
    aboutItem.setMnemonic('A');
    aboutItem.addActionListener(
           new ActionListener(){
                   public void actionPerformed(ActionEvent e)
                    {
                     JOptionPane.showMessageDialog(null,
                        "^@^^@^^@^^@^------------^@^^@^^@^^@^\n���transome�Ļ�ͼ����\n" +
                        "Transome Is HandSome\n������ϵQQ��542260523\n^@^^@^^@^^@^------------^@^^@^^@^^@^",
                        " ��ͼ�����˵�� ",
                         JOptionPane.INFORMATION_MESSAGE );
                     }
                   }
              );
    helpMenu.add(aboutItem);
    bar.add(helpMenu);

    items=new ImageIcon[names.length];

//�������ֻ���ͼ�εİ�ť
    grid1=new GridLayout(9,2,5,5);
    drawingArea=new DrawPanel();
    choices=new JButton[names.length];
    buttonPanel = new JToolBar( JToolBar.VERTICAL ) ;
    buttonPanel = new JToolBar( JToolBar.HORIZONTAL) ;
    buttonPanel.setLayout(grid1);
    buttonPanel.setBackground(Color.gray);
    ButtonHandler handler=new ButtonHandler();
    ButtonHandler1 handler1=new ButtonHandler1();

//����������Ҫ��ͼ��ͼ�꣬��Щͼ�궼�������Դ�ļ���ͬ��Ŀ¼����
    for(int i=0;i<choices.length;i++)
    {//items[i]=new ImageIcon( MiniDrawPad.class.getResource(names[i] +".gif"));
                       //�����jbuilder�����б�������Ӧ����������䵼��ͼƬ
     //items[i]=new ImageIcon(names[i] + ".gif");
                   //Ĭ�ϵ���jdk����jcreator�����У��ô���䵼��ͼƬ
     choices[i]=new JButton(names[i]);
     choices[i].setToolTipText(tipText[i]);
     buttonPanel.add(choices[i]);
    }

//���������������밴ť����
    for(int i=3;i<choices.length-3;i++)
    {
     choices[i].addActionListener(handler);
    }

    choices[0].addActionListener(
          new ActionListener(){
                  public void actionPerformed(ActionEvent e)
                  {
                   newFile();
                  }
          }
     );

    choices[1].addActionListener(
          new ActionListener(){
                  public void actionPerformed(ActionEvent e)
                  {
                   loadFile();
                  }
          }
     );

    choices[2].addActionListener(
          new ActionListener(){
                  public void actionPerformed(ActionEvent e)
                  {
                   saveFile();
                  }
          }
     );
    choices[choices.length-3].addActionListener(handler1);
    choices[choices.length-2].addActionListener(handler1);
    choices[choices.length-1].addActionListener(handler1);

//������ѡ��
    styles=new JComboBox(styleNames);
    styles.setMaximumRowCount(8);
    styles.addItemListener(
            new ItemListener(){
                    public void itemStateChanged(ItemEvent e)
                    {
                      style1=styleNames[styles.getSelectedIndex()];
                    }
               }
            );
//����ѡ��
    bold=new JCheckBox("BOLD");
    italic=new JCheckBox("ITALIC");

    checkBoxHandler cHandler=new checkBoxHandler();
    bold.addItemListener(cHandler);
    italic.addItemListener(cHandler);

    JPanel wordPanel=new JPanel();
    wordPanel.add(bold);
    wordPanel.setBackground(Color.getHSBColor(20, 200, 100));
    wordPanel.add(italic);
    wordPanel.add(styles);
    styles.setMinimumSize(  new Dimension ( 50, 20 ) );
    styles.setMaximumSize(new Dimension ( 100, 20 ) );

    Container c=getContentPane();
    super.setJMenuBar( bar );
    c.add(buttonPanel,BorderLayout.EAST);
    c.add(wordPanel,BorderLayout.NORTH);
    c.add(drawingArea,BorderLayout.CENTER);

    statusBar=new JLabel();
    c.add(statusBar,BorderLayout.SOUTH);
    statusBar.setText("��ӭ����transome�Ļ�ͼ����:)");

    createNewItem();
    setSize(width,height);

    show();
  }


//��ť������ButtonHanler�࣬�ڲ��࣬��������������ť�Ĳ���
public class ButtonHandler implements ActionListener
 {
  public void actionPerformed(ActionEvent e)
  {
   for(int j=3;j<choices.length-3;j++)
   {
      if(e.getSource()==choices[j])
         {currentChoice=j;
          createNewItem();
          repaint();}
        }
    }
 }

//��ť������ButtonHanler1�࣬����������ɫѡ�񡢻��ʴ�ϸ���á��������밴ť�Ĳ���
public class ButtonHandler1 implements ActionListener
 {
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==choices[choices.length-3])
         {chooseColor();}
    if(e.getSource()==choices[choices.length-2])
         {setStroke();}
    if(e.getSource()==choices[choices.length-1])
         {JOptionPane.showMessageDialog(null,
             "Please hit the drawing pad to choose the word input position",
             "Hint",JOptionPane.INFORMATION_MESSAGE );
          currentChoice=14;
          createNewItem();
          repaint();
          }
    }
 }


//����¼�mouseA�࣬�̳���MouseAdapter��������������Ӧ�¼�����
 class mouseA extends MouseAdapter
 {
   public void mousePressed(MouseEvent e)
    {statusBar.setText("                               Mouse Pressed @:[" + e.getX() +
                              ", " + e.getY() + "]");//����״̬��ʾ

     itemList[index].x1=itemList[index].x2=e.getX();
     itemList[index].y1=itemList[index].y2=e.getY();

    //�����ǰѡ���ͼ������ʻ�������Ƥ�������������Ĳ���
    if(currentChoice==3||currentChoice==13)
    {
     itemList[index].x1=itemList[index].x2=e.getX();
     itemList[index].y1=itemList[index].y2=e.getY();
     index++;
     createNewItem();
     }

    //�����ǰѡ���ͼ��ʽ�������룬������������
     if(currentChoice==14)
     {
      itemList[index].x1=e.getX();
      itemList[index].y1=e.getY();

      String input;
      input=JOptionPane.showInputDialog(
          "Please input the text you want!");
      itemList[index].s1=input;
      itemList[index].x2=f1;
      itemList[index].y2=f2;
      itemList[index].s2=style1;

      index++;
      currentChoice=14;
      createNewItem();
      drawingArea.repaint();
      }
    }

   public void mouseReleased(MouseEvent e)
    {statusBar.setText("														Mouse Released @:[" + e.getX() +
                              ", " + e.getY() + "]");

    if(currentChoice==3||currentChoice==13)
    {
     itemList[index].x1=e.getX();
     itemList[index].y1=e.getY();
    }
     itemList[index].x2=e.getX();
     itemList[index].y2=e.getY();
     repaint();
     index++;
     createNewItem();
    }

   public void mouseEntered(MouseEvent e)
   {
           statusBar.setText("														Mouse Entered @:[" + e.getX() +
                              ", " + e.getY() + "]");
           }

   public void mouseExited(MouseEvent e)
   {
           statusBar.setText("														Mouse Exited @:[" + e.getX() +
                              ", " + e.getY() + "]");
           }
  }


//����¼�mouseB��̳���MouseMotionAdapter�������������϶�������ƶ�ʱ����Ӧ����
 class mouseB extends MouseMotionAdapter
 {
  public void mouseDragged(MouseEvent e)
  {statusBar.setText("														Mouse Dragged @:[" + e.getX() +
                              ", " + e.getY() + "]");

   if(currentChoice==3||currentChoice==13)
   {
    itemList[index-1].x1=itemList[index].x2=itemList[index].x1=e.getX();
    itemList[index-1].y1=itemList[index].y2=itemList[index].y1=e.getY();
    index++;
    createNewItem();
   }
   else
    {
     itemList[index].x2=e.getX();
     itemList[index].y2=e.getY();
    }
   repaint();
   }

  public void mouseMoved(MouseEvent e)
   {statusBar.setText("														Mouse Moved @:[" + e.getX() +
                              ", " + e.getY() + "]");}
  }


//ѡ��������ʱ���õ����¼��������࣬���뵽�������ѡ�����
private class checkBoxHandler implements ItemListener
 {
  public void itemStateChanged(ItemEvent e)
  {
   if(e.getSource()==bold)
     if(e.getStateChange()==ItemEvent.SELECTED)
        f1=Font.BOLD;
      else
        f1=Font.PLAIN;
   if(e.getSource()==italic)
     if(e.getStateChange()==ItemEvent.SELECTED)
        f2=Font.ITALIC;
      else
        f2=Font.PLAIN;
          }
 }


//��ͼ����࣬������ͼ
 class DrawPanel extends JPanel
 {
   public DrawPanel()
  {
   setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
   setBackground(Color.white);
   addMouseListener(new mouseA());
   addMouseMotionListener(new mouseB());
  }

    public void paintComponent(Graphics g)
    {
      super.paintComponent(g);

      Graphics2D g2d=(Graphics2D)g;	//���廭��

      int j=0;
      while (j<=index)
      {
        draw(g2d,itemList[j]);
        j++;
      }
    }

    void draw(Graphics2D g2d,drawings i)
    {
      i.draw(g2d);//�����ʴ��뵽���������У�������ɸ��ԵĻ�ͼ
    }
 }


//�½�һ����ͼ������Ԫ����ĳ����
 void createNewItem()
  { if(currentChoice==14)//������Ӧ���α�����
          drawingArea.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
          else
          drawingArea.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

    switch (currentChoice)
    {
      case 3:
        itemList[index]=new Pencil();
        break;
      case 4:
        itemList[index]=new Line();
        break;
      case 5:
        itemList[index]=new Rect();
        break;
      case 6:
        itemList[index]=new fillRect();
        break;
      case 7:
        itemList[index]=new Oval();
        break;
      case 8:
        itemList[index]=new fillOval();
        break;
      case 9:
        itemList[index]=new Circle();
        break;
      case 10:
        itemList[index]=new fillCircle();
        break;
      case 11:
        itemList[index]=new RoundRect();
        break;
      case 12:
        itemList[index]=new fillRoundRect();
        break;
      case 13:
        itemList[index]=new Rubber();
        break;
      case 14:
        itemList[index]=new Word();
        break;
    }
    itemList[index].type=currentChoice;
    itemList[index].R=R;
    itemList[index].G=G;
    itemList[index].B=B;
    itemList[index].stroke=stroke;
  }


//ѡ��ǰ��ɫ�����
public void chooseColor()
 {
    color=JColorChooser.showDialog(MyPainting.this,
                          "Choose a color",color);
    R=color.getRed();
    G=color.getGreen();
    B=color.getBlue();
    itemList[index].R=R;
    itemList[index].G=G;
    itemList[index].B=B;
  }

//ѡ��ǰ������ϸ�����
public void setStroke()
 {
  String input;
  input=JOptionPane.showInputDialog(
          "������һ������0����");
  try{                                    //�쳣�����жϡ�������������������
  stroke=Float.parseFloat(input);}
  catch(NumberFormatException numberFormatException){
	  JOptionPane.showMessageDialog(this, "������������0����","���Ϸ�������",JOptionPane.ERROR_MESSAGE);
	  
  }
  if(stroke>0)
  {
  itemList[index].stroke=stroke;
  }
  else 
  {
	  JOptionPane.showMessageDialog(this, "�������������","����",JOptionPane.ERROR_MESSAGE);
  }
  }

//����ͼ���ļ������
 public void saveFile()
 {
    JFileChooser fileChooser=new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result =fileChooser.showSaveDialog(this);
    if(result==JFileChooser.CANCEL_OPTION)
             return ;
    File fileName=fileChooser.getSelectedFile();
    fileName.canWrite();

    if (fileName==null||fileName.getName().equals(""))
    JOptionPane.showMessageDialog(fileChooser,"Invalid File Name",
            "Invalid File Name", JOptionPane.ERROR_MESSAGE);
    else{
      try {
       fileName.delete();
       FileOutputStream fos=new FileOutputStream(fileName);

       output=new ObjectOutputStream(fos);
       drawings record;

       output.writeInt( index );

       for(int i=0;i< index ;i++)
       {
               drawings p= itemList[ i ] ;
        output.writeObject(p);
        output.flush();    //������ͼ����Ϣǿ��ת���ɸ������Ի��洢���ļ���
               }
      output.close();
      fos.close();
      }
       catch(IOException ioe)
       {
         ioe.printStackTrace();
       }
      }
   }

//��һ��ͼ���ļ������
 public void loadFile()
 {

    JFileChooser fileChooser=new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result =fileChooser.showOpenDialog(this);
    if(result==JFileChooser.CANCEL_OPTION)
          return ;
    File fileName=fileChooser.getSelectedFile();
    fileName.canRead();
    if (fileName==null||fileName.getName().equals(""))
       JOptionPane.showMessageDialog(fileChooser,"���淶������",
            "���淶������", JOptionPane.ERROR_MESSAGE);
    else {
      try {

          FileInputStream fis=new FileInputStream(fileName);

          input=new ObjectInputStream(fis);
          drawings inputRecord;

          int countNumber=0;
          countNumber=input.readInt();

          for(index=0;index< countNumber ;index++)
          {
            inputRecord=(drawings)input.readObject();
            itemList[ index ] = inputRecord ;

          }

          createNewItem();
          input.close();

          repaint();
          }
           catch(EOFException endofFileException){
            JOptionPane.showMessageDialog(this,"no more record in file",
                           "class not found",JOptionPane.ERROR_MESSAGE );
          }
          catch(ClassNotFoundException classNotFoundException){
            JOptionPane.showMessageDialog(this,"Unable to Create Object",
                           "end of file",JOptionPane.ERROR_MESSAGE );
          }
          catch (IOException ioException){
            JOptionPane.showMessageDialog(this,"error during read from file",
                           "read Error",JOptionPane.ERROR_MESSAGE );
            }
          }
       }


//�½�һ���ļ������
 public void newFile()
 {
  index=0;
  currentChoice=3;
  color=Color.black;
  stroke=1.0f;
  createNewItem();
  repaint();//���й�ֵ����Ϊ��ʼ״̬�������ػ�
 }



//��������
 public static void main(String args[])
  {try {
        UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
        }
     catch ( Exception e ) {}//����������Ϊ��ǰwindows���

   MyPainting newPad=new MyPainting();
   newPad.addWindowListener(
        new WindowAdapter(){
           public void windowClosing(WindowEvent e)
           {System.exit(0);}});
  }
}
