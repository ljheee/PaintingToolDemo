package demo2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	
	private static final long serialVersionUID = 1L;

	/**�����˵���*/
	public MenuBar(){
		this.setBackground(new Color(240,240,240));
		this.setPreferredSize(new Dimension(300,22));
		
			
		//�����˵�
		JMenu menu_file = new JMenu("�ļ�(F)");
		JMenu menu_edit = new JMenu("�༭(E)");
		JMenu menu_look = new JMenu("�鿴(V)");
		JMenu menu_image = new JMenu("ͼ��(I)");
		JMenu menu_color = new JMenu("��ɫ(C)");
		JMenu menu_help = new JMenu("����(H)");
		//�����˵���
		//�ļ�menu_file
		JMenuItem item_new = new JMenuItem("�½�(N)         Ctrl+N");
		JMenuItem itm_open = new JMenuItem("��(O)...      Ctrl+O");
		JMenuItem itm_save = new JMenuItem("����(S)         Ctrl+S");
		JMenuItem itm_save_as = new JMenuItem("���Ϊ(A)...");
		JMenuItem itm_form_camera = new JMenuItem("��ɨ���ǻ������(C)...");
		JMenuItem itm_print_preview = new JMenuItem("��ӡԤ��(V)");
		JMenuItem itm_page_set = new JMenuItem("ҳ������(U)...");
		JMenuItem itm_print = new JMenuItem("��ӡ(P)...         Ctrl+P");
		JMenuItem itm_send = new JMenuItem("����(E)...");
		JMenuItem itm_set_wallpaper_tile = new JMenuItem("����Ϊǽֽ(ƽ��)(B)");
		JMenuItem itm_wallpaper_center = new JMenuItem("����Ϊǽֽ(����)(K)");
		JMenuItem itm_nearest_used = new JMenuItem("���ʹ�ù����ļ�");
		JMenuItem itm_exit = new JMenuItem("�˳�(x)         Alt+F4");				
		//�༭menu_edit
		JMenuItem itm_undo = new JMenuItem("����");
		JMenuItem itm_repeat = new JMenuItem("�ظ�");
		JMenuItem itm_cut = new JMenuItem("����");
		JMenuItem itm_copy = new JMenuItem("����");
		JMenuItem itm_paste = new JMenuItem("ճ��");			
		//�鿴menu_look
		JMenuItem itm_tool_box = new JMenuItem("������");
		JMenuItem itm_color_box = new JMenuItem("���Ϻ�");
		JMenuItem itm_status_bar = new JMenuItem("״̬��");				
		//ͼ��menu_image
		JMenuItem itm_rotate = new JMenuItem("��ת/��ת");
		JMenuItem itm_stretch = new JMenuItem("����/Ť��");
		JMenuItem itm_inverse = new JMenuItem("��ɫ");
		JMenuItem itm_attribute = new JMenuItem("����");			
		//��ɫmenu_color
		JMenuItem itm_edit_color = new JMenuItem("�༭��ɫ(E)...   ");
		//����menu_help
		JMenuItem itm_help_theme = new JMenuItem("��������(H)");
		JMenuItem itm_about_drawing = new JMenuItem("���ڻ�ͼ(A)");

		
		//��Ӳ˵�
		this.add(menu_file);
		this.add(menu_edit);
		this.add(menu_look);
		this.add(menu_image);
		this.add(menu_color);
		this.add(menu_help);	
		
		//��Ӳ˵���	
		//�ļ�menu_file
		menu_file.add(item_new);
		menu_file.add(itm_open);
		menu_file.add(itm_save);
		menu_file.add(itm_save_as);
		menu_file.add(itm_form_camera);
		menu_file.add(itm_print_preview);
		menu_file.add(itm_page_set);
		menu_file.add(itm_print);
		menu_file.add(itm_send);
		menu_file.add(itm_set_wallpaper_tile);
		menu_file.add(itm_wallpaper_center);
		menu_file.add(itm_nearest_used);
		menu_file.add(itm_exit);		
		//�༭menu_edit
		menu_edit.add(itm_undo);
		menu_edit.add(itm_repeat);
		menu_edit.add(itm_cut);
		menu_edit.add(itm_copy);
		menu_edit.add(itm_paste);
		//�鿴menu_look
		menu_look.add(itm_tool_box);
		menu_look.add(itm_color_box);
		menu_look.add(itm_status_bar);
		//ͼ��menu_image
		menu_image.add(itm_rotate);
		menu_image.add(itm_stretch);
		menu_image.add(itm_inverse);
		menu_image.add(itm_attribute);
		//��ɫmenu_color
		menu_color.add(itm_edit_color);
		//����menu_help
		menu_help.add(itm_help_theme);
		menu_help.add(itm_about_drawing);

	}	
		
}

