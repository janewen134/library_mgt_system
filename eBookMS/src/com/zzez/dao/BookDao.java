package com.zzez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zzez.model.Book;
import com.zzez.util.StringUtil;

/**
 * @Í¼Êé²Ù×÷
 * 
 * @author Jing Wen
 *
 *         2019.6.6
 */
public class BookDao {

	/**
	 * delete book item
	 */
	public int deleteBookItem(Connection con, int id) throws Exception {

		String sql = "delete from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);

		return pstmt.executeUpdate();

	}

	/**
	 * update book message
	 */
	public int updateBookMsg(Connection con, Book book) throws Exception {

		String sql = "update t_book set bookName=?,bookTypeId=?,author=?,publisher=?,material=?,bookDesc=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, book.getBookName());
		pstmt.setInt(2, book.getBookTypeId());
		pstmt.setString(3, book.getAuthor());
		pstmt.setString(4, book.getPublisher());
		pstmt.setString(5, book.getMaterial());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setInt(7, book.getId());

		return pstmt.executeUpdate();

	}

	/**
	 * get set of book
	 * 
	 * @throws Exception
	 */
	public ResultSet listBook(Connection con, Book book) throws Exception {

		String sql = "select * from t_book b, t_booktype t where b.bookTypeId=t.id";
		String bookName = book.getBookName();
		if (StringUtil.isNotEmpty(bookName)) {
			sql = sql + " and bookName like '%" + bookName + "%'";
		}

		String publisher = book.getPublisher();
		if (StringUtil.isNotEmpty(publisher)) {
			sql = sql + " and publisher like '%" + publisher + "%'";
		}

		String material = book.getMaterial();
		if (StringUtil.isNotEmpty(material)) {
			sql = sql + " and material like '%" + material + "%'";
		}

		String author = book.getAuthor();
		if (StringUtil.isNotEmpty(author)) {
			sql = sql + " and author like '%" + author + "%'";
		}

		int bookTypeId = book.getBookTypeId();
		if (bookTypeId != -1) {
			sql = sql + " and bookTypeId=" + bookTypeId;
		}

		PreparedStatement pstmt = con.prepareStatement(sql);

		return pstmt.executeQuery();

	}

	/**
	 * add new book into t_book(SQL table)
	 */
	public int addBook(Connection con, Book book) throws Exception {

		String sql = "insert into t_book values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPublisher());
		pstmt.setString(4, book.getMaterial());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setString(7, book.getPositionCode());

		return pstmt.executeUpdate();

	}

	/**
	 * get set of bookType
	 */
	public ResultSet listBookType(Connection con) throws Exception {

		String sql = "select * from t_booktype";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();

	}

}
