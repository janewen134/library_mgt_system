package com.zzez.view;

import java.awt.Color;
/**
 * @manage bookType 
 * @author Jing Wen
 * 2019.6.5.
 */
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import com.zzez.dao.BookTypeDao;
import com.zzez.model.Book;
import com.zzez.model.BookType;
import com.zzez.util.FontOptimize;
import com.zzez.util.JdbcUtil;
import com.zzez.util.StringUtil;

public class ManageBookTypeFrm extends JFrame {

	private JPanel contentPane;
	private JTextField bookTypeNameTxt;
	private JTable t_bookType;
	
	private JdbcUtil jdbcUtil = new JdbcUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JTextField idTxt;
	private JTextField bookTypeNameTxt_r;
	private JTextArea bookTypeDescTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageBookTypeFrm frame = new ManageBookTypeFrm();
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
	public ManageBookTypeFrm() {
		FontOptimize.font();
		setResizable(false);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u4FEE\u6539");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManageBookTypeFrm.class.getResource("/com/zzez/imgs/deleteandchange.png")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u5173\u952E\u5B57\uFF1A");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5  \u627E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTable();
			}
		});
		button.setIcon(new ImageIcon(ManageBookTypeFrm.class.getResource("/com/zzez/imgs/search.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u7C7B\u522B\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u7C7B\u522B\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		bookTypeNameTxt_r = new JTextField();
		bookTypeNameTxt_r.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		bookTypeDescTxt = new JTextArea();
		bookTypeDescTxt.setLineWrap(true);
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(160, 160, 160), 1, false));
		
		JButton button_1 = new JButton("\u63D0\u4EA4\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateBookTypeActionPerformed();
				clear();
			}
		});
		button_1.setIcon(new ImageIcon(ManageBookTypeFrm.class.getResource("/com/zzez/imgs/repair.png")));
		
		JButton button_2 = new JButton("\u5220\u9664\u7C7B\u522B");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBookTypeActionPerformed();
			}
		});
		
		button_2.setIcon(new ImageIcon(ManageBookTypeFrm.class.getResource("/com/zzez/imgs/delet.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeNameTxt_r))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button_1)
									.addGap(18)
									.addComponent(button_2))
								.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))))
					.addGap(23))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeNameTxt_r, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(22))
		);
		panel.setLayout(gl_panel);
		
		t_bookType = new JTable();
		t_bookType.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				selectedItemMousePressed();
				
			}
		});
		t_bookType.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7C7B\u522B\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		t_bookType.getColumnModel().getColumn(0).setPreferredWidth(58);
		t_bookType.getColumnModel().getColumn(1).setPreferredWidth(122);
		t_bookType.getColumnModel().getColumn(2).setPreferredWidth(290);
		scrollPane.setViewportView(t_bookType);
		contentPane.setLayout(gl_contentPane);
		fillTable();
	}
	
	private void deleteBookTypeActionPerformed() {
		
		String ids = idTxt.getText();
		int id = Integer.parseInt(ids);
		Book book = new Book(null, null, null, null, id, null, null);
		Connection con = null;
		try {
			con = jdbcUtil.getCon();
			ResultSet rs = bookDao.listBook(con, book);
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(this, "该类别下有图书，不能删除！");
				return;
			}
			
			int n = bookTypeDao.deleteBookType(con, id);
			if(n == 1) {
				
				JOptionPane.showMessageDialog(this, "删除成功！");
				
			}
			
			fillTable();
			
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

	private void updateBookTypeActionPerformed() {
		
		String id_str = idTxt.getText();
		if(StringUtil.isEmpty(id_str)) {
			JOptionPane.showMessageDialog(this, "请从上表选择要修改的条目");
			return;
		}
		
		String bookTypeName = bookTypeNameTxt_r.getText();
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(this, "类别名称不能为空！");
			return;
		}
		
		String bookTypeDesc = bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypeDesc)) {
			JOptionPane.showMessageDialog(this, "类别描述不能为空！");
		}
		
		int id = Integer.parseInt(id_str);
		
		BookType bookType = new BookType(id, bookTypeName, bookTypeDesc);
		Connection con = null;
		try {
			con = jdbcUtil.getCon();
			int num = bookTypeDao.updateBookType(con, bookType);
			if(num == 1) {
				JOptionPane.showMessageDialog(this, "修改操作成功！");
			}
			clear();
			fillTable();
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

	private void clear() {
		idTxt.setText("");
		bookTypeNameTxt_r.setText("");
		bookTypeDescTxt.setText("");
	}

	/**
	 * repair message display
	 */
	private void selectedItemMousePressed() {
		
		int rowNum = t_bookType.getSelectedRow();
		
		idTxt.setText(t_bookType.getValueAt(rowNum, 0) + "");
		bookTypeNameTxt_r.setText((String)t_bookType.getValueAt(rowNum, 1));
		bookTypeDescTxt.setText((String)t_bookType.getValueAt(rowNum, 2));
		
	}

	/**
	 * fill table
	 */
	private void fillTable() {
		
		String bookTypeName = bookTypeNameTxt.getText();
		if(StringUtil.isEmpty(bookTypeName)) {
			bookTypeName = "";
		}
		Connection con = null;
		try {
			con = jdbcUtil.getCon();
			ResultSet rs = bookTypeDao.selectBookType(con, bookTypeName);
			
			DefaultTableModel dtm = (DefaultTableModel)t_bookType.getModel();
			dtm.setRowCount(0);
			while(rs.next()) {
				Vector v = new Vector();
				
				v.add(rs.getInt("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dtm.addRow(v);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
