package com.zzez.view;

/**
 * @manager login
 * @author Jing Wen
 * 2019.6.5.
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.zzez.dao.UserDao;
import com.zzez.model.User;
import com.zzez.util.FontOptimize;
import com.zzez.util.JdbcUtil;
import com.zzez.util.StringUtil;

public class ManagerLoginFrm extends JFrame {

	private JPanel contentPane;
	private JPasswordField passWordTxt;
	private JTextField userNameTxt;
	private JdbcUtil jdbcUtil = new JdbcUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLoginFrm frame = new ManagerLoginFrm();
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
	public ManagerLoginFrm() {
		FontOptimize.font();
		setAlwaysOnTop(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406\u5458login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerLoginFrm.class.getResource("/com/zzez/imgs/login1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ManagerLoginFrm.class.getResource("/com/zzez/imgs/manager1.png")));

		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458\u767B\u5F55");
		label_1.setFont(new Font("宋体", Font.PLAIN, 26));

		JLabel label_2 = new JLabel("\u7528 \u6237 \u540D\uFF1A");

		JLabel label_3 = new JLabel("\u5BC6 \u3000\u7801\uFF1A");

		passWordTxt = new JPasswordField();

		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);

		JButton button = new JButton("\u767B  \u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				loginActionPerformed();

			}
		});
		button.setIcon(new ImageIcon(ManagerLoginFrm.class.getResource("/com/zzez/imgs/login2.png")));

		JButton button_1 = new JButton("\u8FD4  \u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				returnLast();

			}
		});
		button_1.setIcon(new ImageIcon(ManagerLoginFrm.class.getResource("/com/zzez/imgs/exit.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(label)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(48).addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(label_3)
										.addComponent(label_2).addComponent(button, Alignment.TRAILING))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
										.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 163,
														Short.MAX_VALUE)
												.addComponent(passWordTxt, GroupLayout.DEFAULT_SIZE, 163,
														Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(31)
												.addComponent(button_1)))))
				.addGap(87)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(45).addComponent(label_1).addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
										.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(label)))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_3)
						.addComponent(passWordTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(35).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(button)
						.addComponent(button_1))
				.addContainerGap(38, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	private void loginActionPerformed() {
		
		String userName = userNameTxt.getText();
		String passWord = new String(passWordTxt.getPassword());

		if (StringUtil.isEmpty(userName)) {

			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;

		}

		if (StringUtil.isEmpty(passWord)) {

			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;

		}
		
		User user = new User(userName, passWord);
		Connection con = null;
		
		try {
			con = jdbcUtil.getCon();
			boolean b = userDao.login(con, user);
			if(b) {
				MainFrm mainFrm = new MainFrm();
				mainFrm.setVisible(true);
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "登录失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	protected void returnLast() {

		LoginFrm loginFrm = new LoginFrm();
		this.dispose();
		loginFrm.setVisible(true);
		loginFrm.setLocationRelativeTo(null);

	}
}
