package com.zzez.view;

/**
 * @bookType operation
 * 
 * @author Jing Wen
 * 
 * 2019.6.5.
 */
import java.awt.EventQueue;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.zzez.dao.BookTypeDao;
import com.zzez.model.BookType;
import com.zzez.util.FontOptimize;
import com.zzez.util.JdbcUtil;
import com.zzez.util.StringUtil;

public class AddBookTypeFrm extends JFrame {

	private JPanel contentPane;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	private JdbcUtil jdbcUtil = new JdbcUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookTypeFrm frame = new AddBookTypeFrm();
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
	public AddBookTypeFrm() {
		FontOptimize.font();
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(AddBookTypeFrm.class.getResource("/com/zzez/imgs/addsort.png")));
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);

		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");

		bookTypeDescTxt = new JTextArea();
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(120, 120, 120), 1, false));

		bookTypeDescTxt.setLineWrap(true);

		JButton btnNewButton = new JButton("\u6DFB  \u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookTypeActionPerformed();
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddBookTypeFrm.class.getResource("/com/zzez/imgs/add.png")));

		JButton btnNewButton_1 = new JButton("\u6E05  \u7A7A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddBookTypeFrm.class.getResource("/com/zzez/imgs/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(28)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton).addGap(39)
										.addComponent(btnNewButton_1))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(bookTypeDescTxt,
												GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(bookTypeNameTxt)))
						.addContainerGap(51, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(30)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(bookTypeNameTxt,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addGap(29)));
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * add bookType
	 */
	private void addBookTypeActionPerformed() {

		String bookTypeName = bookTypeNameTxt.getText();
		String bookTypeDesc = bookTypeDescTxt.getText();

		if (StringUtil.isEmpty(bookTypeName)) {

			JOptionPane.showMessageDialog(this, "图书类别名称不能为空！");
			return;

		}

		if (StringUtil.isEmpty(bookTypeDesc)) {

			JOptionPane.showMessageDialog(this, "图书类别描述不能为空！");
			return;

		}

		BookType bookType = new BookType(bookTypeName, bookTypeDesc);
		Connection con = null;

		try {

			con = jdbcUtil.getCon();
			int num = bookTypeDao.addBookType(con, bookType);
			if (num == 1) {
				JOptionPane.showMessageDialog(this, "添加成功！");
				clear();
			} else {
				JOptionPane.showMessageDialog(this, "添加失败！");
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

	/**
	 * clear the content
	 */
	private void clear() {
		bookTypeNameTxt.setText("");
		bookTypeDescTxt.setText("");
	}

}
