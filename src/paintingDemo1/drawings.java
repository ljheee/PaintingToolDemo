package paintingDemo1;

import java.awt.Graphics2D;
import java.io.Serializable;

//���廭ͼ�Ļ���ͼ�ε�Ԫ
public class drawings implements Serializable//���࣬����ͼ�ε�Ԫ���õ����л��ӿڣ�����ʱ����
 {
  int x1,y1,x2,y2;	//������������
  int R,G,B;		//����ɫ������
  float stroke;		//����������ϸ����
  int type;		//������������
  String s1;
  String s2;		//��������������

  void draw(Graphics2D g2d){};//�����ͼ����
 }
