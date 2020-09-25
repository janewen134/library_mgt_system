package com.zzez.view;

/**
 * @user operation face
 * @author Jing Wen
 * 2019.6.6.
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.zzez.dao.BookDao;
import com.zzez.model.Book;
import com.zzez.model.BookType;
import com.zzez.util.FontOptimize;
import com.zzez.util.JdbcUtil;

public class UserSelectBookFrm extends JFrame {

	private JPanel contentPane;
	private JTextField bookNameTxt;
	private JTextField publisherTxt;
	private JTextField authorTxt;
	private JTable table;
	private JdbcUtil jdbcUtil = new JdbcUtil();
	private BookDao bookDao = new BookDao();
	private JComboBox bookTypeCb_s;
	private JRadioButton rb1, rb2;
	private JTextArea searchResultDisplay;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSelectBookFrm frame = new UserSelectBookFrm();
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
	public UserSelectBookFrm() {
		setResizable(false);
		FontOptimize.font();
		setTitle("\u9986\u85CF\u56FE\u4E66\u67E5\u8BE2");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(UserSelectBookFrm.class.getResource("/com/zzez/imgs/userselect.png")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u67E5\u8BE2\u5173\u952E\u5B57", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u7ED3\u679C\u663E\u793A(\u9009\u4E2D\u5E76\u6309ctrl+c\u590D\u5236)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		searchResultDisplay = new JTextArea();
		searchResultDisplay.setEditable(false);
		searchResultDisplay.setLineWrap(true);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(searchResultDisplay, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(searchResultDisplay, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);

		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);

		JLabel label_1 = new JLabel("\u51FA\u7248\u673A\u6784\uFF1A");

		publisherTxt = new JTextField();
		publisherTxt.setColumns(10);

		JLabel label_2 = new JLabel("\u4ECB\u8D28\u7C7B\u578B\uFF1A");

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
		btnNewButton.setIcon(new ImageIcon(UserSelectBookFrm.class.getResource("/com/zzez/imgs/search.png")));

		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u578B\uFF1A");

		bookTypeCb_s = new JComboBox();

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
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
									.addComponent(rb2)))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
					.addContainerGap())
		);

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
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
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
		table.getColumnModel().getColumn(6).setPreferredWidth(132);
		table.getColumnModel().getColumn(7).setPreferredWidth(52);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		fillBookType();
		selectBookActionPerformed();
		
	}
	
	/**
	 * get value of table
	 */
	private void pressTableMouseAction() {

		int row = table.getSelectedRow();
		String id = "" + table.getValueAt(row, 0);
		String bookName = (String)table.getValueAt(row, 1);
		String publisher = (String)table.getValueAt(row, 2);
		String author = (String)table.getValueAt(row, 3);
		String bookTypeName = (String) table.getValueAt(row, 4);
		String material = (String) table.getValueAt(row, 5);
		String bookDesc = (String) table.getValueAt(row, 6);
		String positionCodeTxt = (String)table.getValueAt(row, 7);
		
		searchResultDisplay.setText("编号：" + id + "\n图书名称：《" + bookName + 
				"》\n图书作者：" + author + "\n出版机构：" + publisher + "\n图书类型：" + 
				bookTypeName + "\n图书介质：" + material + "\n位置编码：" + 
				positionCodeTxt + "\n图书描述：" + bookDesc);
	}
	
	
	
	/**
	 * fill table in book select
	 */
	private void selectBookActionPerformed() {
		
		String bookName = bookNameTxt.getText();
		String publisher = publisherTxt.getText();
		
		String material = null;
		if(rb1.isSelected() && !rb2.isSelected()) {
			material = "纸质";
		}
		if(!rb1.isSelected() && rb2.isSelected()) {
			material = "影音";
		}
		
		String author = authorTxt.getText();
		
		BookType bookType = (BookType)bookTypeCb_s.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book(bookName, author, publisher, material, bookTypeId, null, null);
		
		Connection con = null;
		try {
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			dtm.setRowCount(0);
			con = jdbcUtil.getCon();
			ResultSet rs = bookDao.listBook(con, book);
			while(rs.next()) {
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
			while(rs.next()) {
				BookType bookType = new BookType(Integer.parseInt(rs.getString("id")), rs.getString("bookTypeName"), rs.getString(("bookTypeDesc")));
				bookTypeCb_s.addItem(bookType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
