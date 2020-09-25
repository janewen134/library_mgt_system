package com.zzez.view;

/**
 * @user operation face
 * @author Jing Wen
 * 2019.6.6.
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.zzez.util.FontOptimize;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UserMainFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainFrm frame = new UserMainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserMainFrm() {
		FontOptimize.font();
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserMainFrm.class.getResource("/com/zzez/imgs/mainFrmICON.png")));
		setTitle("\u8087\u5DDE\u4E8C\u4E2D\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u64CD\u4F5C");
		menu.setIcon(new ImageIcon(UserMainFrm.class.getResource("/com/zzez/imgs/sysopretion.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitActionPerFormed();
			}
		});
		menuItem_1.setIcon(new ImageIcon(UserMainFrm.class.getResource("/com/zzez/imgs/exit.png")));
		menu.add(menuItem_1);
		
		JMenu mnNewMenu = new JMenu("\u9986\u85CF\u56FE\u4E66\u67E5\u8BE2");
		mnNewMenu.setIcon(new ImageIcon(UserMainFrm.class.getResource("/com/zzez/imgs/userselect.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5F00\u59CB\u67E5\u8BE2");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSelectBookFrm userSelectBookFrm = new UserSelectBookFrm();
				userSelectBookFrm.setVisible(true);
				userSelectBookFrm.setLocationRelativeTo(null);
			}
		});
		menuItem_2.setIcon(new ImageIcon(UserMainFrm.class.getResource("/com/zzez/imgs/search.png")));
		mnNewMenu.add(menuItem_2);
		
		JMenu menu_3 = new JMenu("\u67E5\u8BE2\u5E2E\u52A9");
		menu_3.setIcon(new ImageIcon(UserMainFrm.class.getResource("/com/zzez/imgs/tecnologyhelp.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("\u5E2E\u52A9\u6587\u6863");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("hh.exe userHelper.chm", null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuItem_6.setIcon(new ImageIcon(UserMainFrm.class.getResource("/com/zzez/imgs/addnewbook.png")));
		menu_3.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = DefaultComponentFactory.getInstance().createLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(UserMainFrm.class.getResource("/com/zzez/imgs/bgpng3.png")));
		panel.add(label);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
	}

	private void exitActionPerFormed() {
		
		System.exit(0);
		
	}

}
