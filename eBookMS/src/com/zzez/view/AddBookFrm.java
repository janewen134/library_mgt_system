package com.zzez.view;
/**
 * @add book operation
 * @author Jing Wen
 */

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.zzez.dao.BookDao;
import com.zzez.model.Book;
import com.zzez.model.BookType;
import com.zzez.util.FontOptimize;
import com.zzez.util.JdbcUtil;
import com.zzez.util.StringUtil;

public class AddBookFrm extends JFrame {

	private JPanel contentPane;
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField publisherTxt;
	private JTextField positionCodeTxt;
	private JTextArea bookDescTxt;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JComboBox bookTypeCb;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JdbcUtil jdbcUtil = new JdbcUtil();
	private BookDao bookDao = new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookFrm frame = new AddBookFrm();
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
	public AddBookFrm() {
		FontOptimize.font();
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("\u6DFB\u52A0\u65B0\u4E66");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddBookFrm.class.getResource("/com/zzez/imgs/add.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JLabel label = new JLabel("\u65B0\u4E66\u540D\u79F0\uFF1A");

		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);

		JLabel label_1 = new JLabel("\u4F5C\u8005\uFF1A");

		authorTxt = new JTextField();
		authorTxt.setColumns(10);

		JLabel label_2 = new JLabel("\u51FA\u7248\u673A\u6784\uFF1A");

		publisherTxt = new JTextField();
		publisherTxt.setColumns(10);

		JLabel label_3 = new JLabel("\u4F4D\u7F6E\u7F16\u7801\uFF1A");

		positionCodeTxt = new JTextField();
		positionCodeTxt.setColumns(10);

		JLabel label_4 = new JLabel("\u4ECB\u8D28\uFF1A");

		rb1 = new JRadioButton("\u7EB8\u8D28");
		buttonGroup.add(rb1);
		rb1.setSelected(true);

		rb2 = new JRadioButton("\u5F71\u97F3");
		buttonGroup.add(rb2);

		JLabel label_5 = new JLabel("\u56FE\u4E66\u7C7B\u578B\uFF1A");

		bookTypeCb = new JComboBox();

		JLabel label_6 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");

		bookDescTxt = new JTextArea();
		bookDescTxt.setLineWrap(true);
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(160, 160, 160), 1, false));

		JButton btnNewButton = new JButton("\u63D0  \u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookActionPerformed();
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddBookFrm.class.getResource("/com/zzez/imgs/addnewbook.png")));

		JButton button = new JButton("\u6E05  \u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clear();

			}
		});
		button.setIcon(new ImageIcon(AddBookFrm.class.getResource("/com/zzez/imgs/reset.png")));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_5)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bookTypeCb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rb1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rb2))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(label_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(positionCodeTxt))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(authorTxt)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(18)
									.addComponent(button))
								.addComponent(bookDescTxt, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(positionCodeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookTypeCb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(label_4)
						.addComponent(rb1)
						.addComponent(rb2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		fillBookType();
	}

	/**
	 * add new book to SQL
	 */

	private void addBookActionPerformed() {

		String bookName = bookNameTxt.getText();
		if (StringUtil.isEmpty(bookName)) {

			JOptionPane.showMessageDialog(this, "新书名称不能为空");
			return;

		}

		String author = authorTxt.getText();
		if (StringUtil.isEmpty(author)) {

			JOptionPane.showMessageDialog(this, "图书作者不能为空");
			return;

		}

		String publisher = publisherTxt.getText();
		if (StringUtil.isEmpty(publisher)) {

			JOptionPane.showMessageDialog(this, "出版机构不能为空");
			return;

		}

		String positionCode = positionCodeTxt.getText();
		if (StringUtil.isEmpty(positionCode)) {

			JOptionPane.showMessageDialog(this, "位置编码不能为 空");
			return;
		}


		BookType bookType = (BookType) bookTypeCb.getSelectedItem();
		int bookTypeId = bookType.getId();
		if (bookTypeId == -1) {
			JOptionPane.showMessageDialog(this, "请选择图书类型");
			return;
		}

		String material = null;
		if (rb1.isSelected()) {
			material = rb1.getText();
		} else {
			material = rb2.getText();
		}

		String bookDesc = bookDescTxt.getText();
		if (StringUtil.isEmpty(bookDesc)) {
			JOptionPane.showMessageDialog(this, "图书描述不能为空");
			return;
		}

		Book book = new Book(bookName, author, publisher, material, bookTypeId, bookDesc, positionCode);
		Connection con = null;
		try {
			con = jdbcUtil.getCon();
			int num = bookDao.addBook(con, book);
			if (num == 1) {
				JOptionPane.showMessageDialog(this, "添加成功");
			}
			clear();
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
	 * clear content
	 */
	private void clear() {

		bookNameTxt.setText("");
		authorTxt.setText("");
		publisherTxt.setText("");
		positionCodeTxt.setText("");
		bookTypeCb.setSelectedIndex(0);
		rb1.setSelected(true);
		bookDescTxt.setText("");

	}

	/**
	 * fill bookType
	 */
	private void fillBookType() {

		Connection con = null;
		try {
			con = jdbcUtil.getCon();
			ResultSet rs = bookDao.listBookType(con);
			BookType bookType_s = new BookType();
			bookType_s.setId(-1);
			bookType_s.setBookTypeName("--请选择图书类型--");
			bookTypeCb.addItem(bookType_s);
			while (rs.next()) {

				BookType bookType = new BookType(rs.getInt("id"), rs.getString("bookTypeName"),
						rs.getString("bookTypeDesc"));
				bookTypeCb.addItem(bookType);

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

}
