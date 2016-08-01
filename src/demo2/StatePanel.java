package demo2;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StatePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private static JLabel  mouse_info1;
	private static JLabel  mouse_info2;

	/**
	 * ����״̬����ϵ��ı���ʾ���Լ�������ʾ
	 * @param state_panel
	 */
	public StatePanel() {
		//���ñ���ɫ�ʹ�С
        this.setBackground(new Color(240,240,240));
        this.setPreferredSize(new Dimension(200,25));
        this.setLayout(null);
        //����һ�����С����񻯡����Ч���ı߿�
        this.setBorder(BorderFactory.createEtchedBorder());

		JLabel label_help = new JLabel("Ҫ��ð���  ,  ����\"����\"�˵���  ,  ����\"��������\"��");
		//�ƶ�������������С
		label_help.setBounds(3, 1, 500, 22);
		
		mouse_info1 = new JLabel();
		mouse_info2 = new JLabel();
		//�ƶ�������������С
		mouse_info1.setBounds(550, 1, 100, 22);
		mouse_info2.setBounds(650, 1, 500, 22);
        //����һ���������Ա߿�����Ч��
		mouse_info1.setBorder(BorderFactory.createLineBorder(new Color(215,215,215)));
		mouse_info2.setBorder(BorderFactory.createLineBorder(new Color(215,215,215)));

		
		this.add(label_help);
		this.add(mouse_info1);
		this.add(mouse_info2);
		
	}
	
	/**
	 * ���������Ϣ
	 */
	public static void setMouseInfo(String info){
		mouse_info1.setText(info);
	}

}
