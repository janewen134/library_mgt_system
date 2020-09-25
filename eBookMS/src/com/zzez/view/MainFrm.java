package com.zzez.view;

/**
 * @manager operation face
 * @author Jing Wen
 * 2019.6.5.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.omg.SendingContext.RunTime;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.zzez.util.FontOptimize;

public class MainFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		FontOptimize.font();
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/com/zzez/imgs/mainFrmICON.png")));
		setTitle("\u8087\u5DDE\u4E8C\u4E2D\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u64CD\u4F5C");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/sysopretion.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitActionPerFormed();
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/exit.png")));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u9986\u85CF\u56FE\u4E66\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/manageicon.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6DFB\u52A0\u65B0\u4E66");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookFrm addBookFrm = new AddBookFrm();
				addBookFrm.setVisible(true);
				addBookFrm.setLocationRelativeTo(null);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/add.png")));
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u7BA1\u7406\u56FE\u4E66");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageBookFrm manageBookFrm = new ManageBookFrm();
				manageBookFrm.setVisible(true);
				manageBookFrm.setLocationRelativeTo(null);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/managebook.png")));
		menu_1.add(menuItem_3);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/sort.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("\u7C7B\u522B\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookTypeFrm addBookTypeFrm = new AddBookTypeFrm();
				addBookTypeFrm.setVisible(true);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/addsort.png")));
		menu_2.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u7C7B\u522B\u4FEE\u6539");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageBookTypeFrm manageBookTypeFrm = new ManageBookTypeFrm();
				manageBookTypeFrm.setVisible(true);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/deleteandchange.png")));
		menu_2.add(menuItem_5);
		
		JMenu menu_3 = new JMenu("\u5E2E\u52A9\u4E0E\u652F\u6301");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/tecnologyhelp.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("\u5E2E\u52A9\u6587\u6863");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openHelperDocumentActionPerform();
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/addnewbook.png")));
		menu_3.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u6280\u672F\u652F\u6301");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				technicalSupportActionPerformed();
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/telephone.png")));
		menu_3.add(menuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = DefaultComponentFactory.getInstance().createLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(MainFrm.class.getResource("/com/zzez/imgs/bgpng3.png")));
		panel.add(label);
		setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
	}

	private void technicalSupportActionPerformed() {
		
		TechnologySupport technologySupport = new TechnologySupport();
		
		technologySupport.setVisible(true);
		technologySupport.setLocationRelativeTo(null);
	}

	protected void openHelperDocumentActionPerform() {
		try {
			Runtime.getRuntime().exec("hh.exe managerHelper.chm",null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exitActionPerFormed() {
		
		System.exit(0);
		
	}

}
