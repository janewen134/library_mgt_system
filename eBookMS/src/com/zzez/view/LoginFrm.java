package com.zzez.view;

/**
 * @entrance
 * @author Jing Wen
 * 2019.6.5.
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.zzez.util.FontOptimize;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton searchRb;
	private JRadioButton loginRb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		FontOptimize.font();
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrm.class.getResource("/com/zzez/imgs/login.png")));
		setTitle("\u7CFB\u7EDF\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/com/zzez/imgs/login3.png")));

		JLabel lblNewLabel_1 = new JLabel("\u6B22 * \u8FCE * \u4F7F * \u7528");
		lblNewLabel_1.setForeground(new Color(128, 128, 0));
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 20));

		JLabel label = new JLabel("\u8087\u5DDE\u53BF\u7B2C\u4E8C\u4E2D\u5B66\u56FE\u4E66\u9986");
		label.setForeground(SystemColor.desktop);
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 26));

		searchRb = new JRadioButton("\u7528\u6237\u56FE\u4E66\u67E5\u8BE2");
		buttonGroup.add(searchRb);
		searchRb.setSelected(true);

		loginRb = new JRadioButton("\u7CFB\u7EDF\u7BA1\u7406\u5458\u767B\u5F55");
		buttonGroup.add(loginRb);

		JButton button = new JButton("\u786E  \u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				loginOrSearchActionPerformed();

			}
		});
		button.setIcon(new ImageIcon(LoginFrm.class.getResource("/com/zzez/imgs/login.png")));
		button.setSelectedIcon(null);

		JButton button_1 = new JButton("\u9000  \u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				exit();

			}
		});
		button_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/com/zzez/imgs/exit.png")));
		
		JLabel lblV = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF V1.0");
		lblV.setForeground(new Color(210, 105, 30));
		lblV.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(searchRb)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(button)
											.addGap(22)
											.addComponent(button_1))
										.addComponent(loginRb))
									.addGap(18)
									.addComponent(lblNewLabel))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblV)
									.addComponent(label)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(161))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblV)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(searchRb)
							.addGap(14)
							.addComponent(loginRb)
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_1))
							.addGap(30))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(15))))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void exit() {

		this.dispose();

	}

	private void loginOrSearchActionPerformed() {

		if (searchRb.isSelected()) {

			exit();
			UserMainFrm userMainFrm = new UserMainFrm();
			userMainFrm.setVisible(true);
			userMainFrm.setLocationRelativeTo(null);

		}

		if (loginRb.isSelected()) {

			exit();
			ManagerLoginFrm managerLoginFrm = new ManagerLoginFrm();
			managerLoginFrm.setVisible(true);
			managerLoginFrm.setLocationRelativeTo(null);

		}

	}
}
