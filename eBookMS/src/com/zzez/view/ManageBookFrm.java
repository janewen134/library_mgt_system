package com.zzez.view;

/**
 * @manage book
 * @author Jing Wen
 * 2019.6.5.
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.zzez.dao.BookDao;
import com.zzez.model.Book;
import com.zzez.model.BookType;
import com.zzez.util.FontOptimize;
import com.zzez.util.JdbcUtil;
import com.zzez.util.StringUtil;

public class ManageBookFrm extends JFrame {

	private JPanel contentPane;
	private JTextField bookNameTxt;
	private JTextField publisherTxt;
	private JTextField authorTxt;
	private JTable table;
	private JdbcUtil jdbcUtil = new JdbcUtil();
	private BookDao bookDao = new BookDao();
	private JComboBox bookTypeCb_s;
	private JRadioButton rb1, rb2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_1;
	private JLabel label_5;
	private JTextField id_r;
	private JLabel label_6;
	private JTextField bookName_r;
	private JLabel lblNewLabel;
	private JTextField publisher_r;
	private JLabel label_7;
	private JTextField author_r;
	private JLabel label_8;
	private JComboBox bookType_r;
	private JLabel label_9;
	private JRadioButton rb1_r;
	private JRadioButton rb2_r;
	private JLabel label_10;
	private JTextArea bookDesc_r;
	private JButton button;
	private JButton button_1;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField positionCodeTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageBookFrm frame = new ManageBookFrm();
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
	public ManageBookFrm() {
		setResizable(false);
		FontOptimize.font();
		setTitle("\u7BA1\u7406\u56FE\u4E66");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ManageBookFrm.class.getResource("/com/zzez/imgs/managebook.png")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"\u67E5\u8BE2\u5173\u952E\u5B57", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pressTableMouseAction();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u51FA\u7248\u673A\u6784", "\u56FE\u4E66\u4F5C\u8005", "\u56FE\u4E66\u7C7B\u578B", "\u4ECB\u8D28", "\u56FE\u4E66\u63CF\u8FF0", "\u4F4D\u7F6E\u7F16\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(36);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		table.getColumnModel().getColumn(3).setPreferredWidth(86);
		table.getColumnModel().getColumn(4).setPreferredWidth(73);
		table.getColumnModel().getColumn(5).setPreferredWidth(36);
		table.getColumnModel().getColumn(6).setPreferredWidth(125);
		table.getColumnModel().getColumn(7).setPreferredWidth(59);
		scrollPane.setViewportView(table);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)),
				"\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)))
					.addGap(17))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 251, Short.MAX_VALUE)
					.addContainerGap())
		);

		label_5 = new JLabel("\u7F16\u53F7\uFF1A");

		id_r = new JTextField();
		id_r.setEditable(false);
		id_r.setColumns(10);

		label_6 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

		bookName_r = new JTextField();
		bookName_r.setColumns(10);

		lblNewLabel = new JLabel("\u51FA\u7248\u673A\u6784\uFF1A");

		publisher_r = new JTextField();
		publisher_r.setColumns(10);

		label_7 = new JLabel("\u4F5C\u8005\uFF1A");

		author_r = new JTextField();
		author_r.setColumns(10);

		label_8 = new JLabel("\u56FE\u4E66\u7C7B\u578B\uFF1A");

		bookType_r = new JComboBox();

		label_9 = new JLabel("\u4ECB\u8D28\uFF1A");

		rb1_r = new JRadioButton("\u7EB8\u8D28");
		buttonGroup_1.add(rb1_r);

		rb2_r = new JRadioButton("\u5F71\u97F3");
		buttonGroup_1.add(rb2_r);

		label_10 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");

		bookDesc_r = new JTextArea();
		bookDesc_r.setLineWrap(true);
		bookDesc_r.setBorder(new LineBorder(new java.awt.Color(160, 160, 160), 1, false));

		button = new JButton("\u4FEE  \u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBookActionPerFormed();
			}
		});
		button.setIcon(new ImageIcon(ManageBookFrm.class.getResource("/com/zzez/imgs/repair.png")));

		button_1 = new JButton("\u5220  \u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBookActionPerformed();
			}
		});
		button_1.setIcon(new ImageIcon(ManageBookFrm.class.getResource("/com/zzez/imgs/delet.png")));
		
		JLabel label_11 = new JLabel("\u4F4D\u7F6E\u7F16\u7801\uFF1A");
		
		positionCodeTxt = new JTextField();
		positionCodeTxt.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(id_r, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookName_r, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_10)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(button)
									.addGap(37)
									.addComponent(button_1))
								.addComponent(bookDesc_r, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(label_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(author_r, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addComponent(label_8)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookType_r, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(publisher_r, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_11)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(positionCodeTxt, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rb1_r)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rb2_r)))
					.addGap(42))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(id_r, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(bookName_r, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(author_r, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(bookType_r, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(publisher_r, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_11)
						.addComponent(positionCodeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rb2_r)
						.addComponent(rb1_r)
						.addComponent(label_9))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_10)
						.addComponent(bookDesc_r, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(29))
		);
		panel_1.setLayout(gl_panel_1);

		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);

		JLabel label_1 = new JLabel("\u51FA\u7248\u673A\u6784\uFF1A");

		publisherTxt = new JTextField();
		publisherTxt.setColumns(10);

		JLabel label_2 = new JLabel("\u4ECB\u8D28\uFF1A");

		rb1 = new JRadioButton("\u7EB8\u8D28");

		rb2 = new JRadioButton("\u5F71\u97F3");

		JLabel label_3 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

		authorTxt = new JTextField();
		authorTxt.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5  \u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBookActionPerformed();
			}
		});
		btnNewButton.setIcon(new ImageIcon(ManageBookFrm.class.getResource("/com/zzez/imgs/search.png")));

		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u578B\uFF1A");

		bookTypeCb_s = new JComboBox();
		bookTypeCb_s.setMaximumRowCount(6);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(authorTxt)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeCb_s, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rb1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rb2)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(rb1)
						.addComponent(rb2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(btnNewButton)
						.addComponent(bookTypeCb_s, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		fillBookType();
		selectBookActionPerformed();

	}

	/**
	 * update book message
	 */
	private void updateBookActionPerFormed() {

		String ids = id_r.getText();
		if (StringUtil.isEmpty(ids)) {
			JOptionPane.showMessageDialog(this, "请从上表选择要修改的书目");
			return;
		}
		int id = Integer.parseInt(ids);
		String bookName = bookName_r.getText();
		BookType bookType = (BookType) bookType_r.getSelectedItem();
		int bookTypeId = bookType.getId();
		String author = author_r.getText();
		String publisher = publisher_r.getText();
		String material = null;
		if (rb1_r.isSelected()) {
			material = "纸质";
		} else {
			material = "影音";
		}
		String bookDesc = bookDesc_r.getText();
		String positionCode = positionCodeTxt.getText();
		Book book = new Book(id, bookName, author, publisher, material, bookTypeId, bookDesc, positionCode);

		Connection con = null;
		try {
			con = jdbcUtil.getCon();
			int num = bookDao.updateBookMsg(con, book);

			if (num == 1) {
				selectBookActionPerformed();

				JOptionPane.showMessageDialog(this, "修改图书信息成功！");
			} else {
				JOptionPane.showMessageDialog(this, "修改图书信息失败！");
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
	 * delete book item
	 */
	private void deleteBookActionPerformed() {

		Connection con = null;
		try {
			con = jdbcUtil.getCon();
			String ids = id_r.getText();
			if (StringUtil.isEmpty(ids)) {

				JOptionPane.showMessageDialog(this, "请从上表选择要删除的图书");
				return;
			}

			int id = Integer.parseInt(ids);

			int num = bookDao.deleteBookItem(con, id);
			if (num == 1) {

				selectBookActionPerformed();
				clearContent();
				JOptionPane.showMessageDialog(this, "图书记录删除成功");
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
	 * clear book item
	 */
	private void clearContent() {
		id_r.setText("");
		bookName_r.setText("");
		bookType_r.setSelectedIndex(0);
		author_r.setText("");
		publisher_r.setText("");
		rb1_r.setSelected(true);
		bookDesc_r.setText("");
		positionCodeTxt.setText("");
	}

	/**
	 * get value of table
	 */
	private void pressTableMouseAction() {

		int row = table.getSelectedRow();
		id_r.setText("" + table.getValueAt(row, 0));
		bookName_r.setText((String) table.getValueAt(row, 1));
		publisher_r.setText((String) table.getValueAt(row, 2));
		author_r.setText((String) table.getValueAt(row, 3));

		String bookTypeName = (String) table.getValueAt(row, 4);
		int n = bookType_r.getMaximumRowCount();
		for (int i = 0; i < n; i++) {
			BookType bookTypei = (BookType) bookType_r.getItemAt(i);
			if (bookTypeName.equals(bookTypei.getBookTypeName())) {
				bookType_r.setSelectedIndex(i);
				break;
			}
		}

		String material = (String) table.getValueAt(row, 5);
		if (material.equals("纸质")) {

			rb1_r.setSelected(true);

		} else {

			rb2_r.setSelected(true);

		}

		bookDesc_r.setText((String) table.getValueAt(row, 6));
		positionCodeTxt.setText((String)table.getValueAt(row, 7));

	}

	/**
	 * fill table in book select
	 */
	private void selectBookActionPerformed() {

		String bookName = bookNameTxt.getText();
		String publisher = publisherTxt.getText();

		String material = null;
		if (rb1.isSelected() && !rb2.isSelected()) {
			material = "纸质";
		}
		if (!rb1.isSelected() && rb2.isSelected()) {
			material = "影音";
		}

		String author = authorTxt.getText();

		BookType bookType = (BookType) bookTypeCb_s.getSelectedItem();
		int bookTypeId = bookType.getId();

		Book book = new Book(bookName, author, publisher, material, bookTypeId, null, null);

		Connection con = null;
		try {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			con = jdbcUtil.getCon();
			ResultSet rs = bookDao.listBook(con, book);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("publisher"));
				v.add(rs.getString("author"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("material"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("positionCode"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * fill comboBox in book select
	 */
	private void fillBookType() {

		BookType bookType_t = new BookType(-1, "——请选择——", null);
		bookTypeCb_s.addItem(bookType_t);
		Connection con = null;
		try {
			con = jdbcUtil.getCon();
			ResultSet rs = bookDao.listBookType(con);
			while (rs.next()) {
				BookType bookType = new BookType(Integer.parseInt(rs.getString("id")), rs.getString("bookTypeName"),
						rs.getString(("bookTypeDesc")));
				bookTypeCb_s.addItem(bookType);
				bookType_r.addItem(bookType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
