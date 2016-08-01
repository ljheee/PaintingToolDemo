package demo2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	
	private static final long serialVersionUID = 1L;

	/**创建菜单栏*/
	public MenuBar(){
		this.setBackground(new Color(240,240,240));
		this.setPreferredSize(new Dimension(300,22));
		
			
		//创建菜单
		JMenu menu_file = new JMenu("文件(F)");
		JMenu menu_edit = new JMenu("编辑(E)");
		JMenu menu_look = new JMenu("查看(V)");
		JMenu menu_image = new JMenu("图像(I)");
		JMenu menu_color = new JMenu("颜色(C)");
		JMenu menu_help = new JMenu("帮助(H)");
		//创建菜单项
		//文件menu_file
		JMenuItem item_new = new JMenuItem("新建(N)         Ctrl+N");
		JMenuItem itm_open = new JMenuItem("打开(O)...      Ctrl+O");
		JMenuItem itm_save = new JMenuItem("保存(S)         Ctrl+S");
		JMenuItem itm_save_as = new JMenuItem("另存为(A)...");
		JMenuItem itm_form_camera = new JMenuItem("从扫描仪或照相机(C)...");
		JMenuItem itm_print_preview = new JMenuItem("打印预览(V)");
		JMenuItem itm_page_set = new JMenuItem("页面设置(U)...");
		JMenuItem itm_print = new JMenuItem("打印(P)...         Ctrl+P");
		JMenuItem itm_send = new JMenuItem("发送(E)...");
		JMenuItem itm_set_wallpaper_tile = new JMenuItem("设置为墙纸(平铺)(B)");
		JMenuItem itm_wallpaper_center = new JMenuItem("设置为墙纸(居中)(K)");
		JMenuItem itm_nearest_used = new JMenuItem("最近使用过的文件");
		JMenuItem itm_exit = new JMenuItem("退出(x)         Alt+F4");				
		//编辑menu_edit
		JMenuItem itm_undo = new JMenuItem("撤销");
		JMenuItem itm_repeat = new JMenuItem("重复");
		JMenuItem itm_cut = new JMenuItem("剪切");
		JMenuItem itm_copy = new JMenuItem("复制");
		JMenuItem itm_paste = new JMenuItem("粘贴");			
		//查看menu_look
		JMenuItem itm_tool_box = new JMenuItem("工具箱");
		JMenuItem itm_color_box = new JMenuItem("颜料盒");
		JMenuItem itm_status_bar = new JMenuItem("状态栏");				
		//图像menu_image
		JMenuItem itm_rotate = new JMenuItem("翻转/旋转");
		JMenuItem itm_stretch = new JMenuItem("拉伸/扭曲");
		JMenuItem itm_inverse = new JMenuItem("反色");
		JMenuItem itm_attribute = new JMenuItem("属性");			
		//颜色menu_color
		JMenuItem itm_edit_color = new JMenuItem("编辑颜色(E)...   ");
		//帮助menu_help
		JMenuItem itm_help_theme = new JMenuItem("帮助主题(H)");
		JMenuItem itm_about_drawing = new JMenuItem("关于画图(A)");

		
		//添加菜单
		this.add(menu_file);
		this.add(menu_edit);
		this.add(menu_look);
		this.add(menu_image);
		this.add(menu_color);
		this.add(menu_help);	
		
		//添加菜单项	
		//文件menu_file
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
		//编辑menu_edit
		menu_edit.add(itm_undo);
		menu_edit.add(itm_repeat);
		menu_edit.add(itm_cut);
		menu_edit.add(itm_copy);
		menu_edit.add(itm_paste);
		//查看menu_look
		menu_look.add(itm_tool_box);
		menu_look.add(itm_color_box);
		menu_look.add(itm_status_bar);
		//图像menu_image
		menu_image.add(itm_rotate);
		menu_image.add(itm_stretch);
		menu_image.add(itm_inverse);
		menu_image.add(itm_attribute);
		//颜色menu_color
		menu_color.add(itm_edit_color);
		//帮助menu_help
		menu_help.add(itm_help_theme);
		menu_help.add(itm_about_drawing);

	}	
		
}

