package com.zzez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzez.model.BookType;

/**
 * @图书类型操作
 * @author Jing Wen
 *
 *         2019.6.5.
 */
public class BookTypeDao {
	
	/**
	 * delete bookType
	 */
	public int deleteBookType(Connection con, int id) throws Exception {
		
		String sql = "delete from t_booktype where id=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		int n = pstmt.executeUpdate();
		
		return n;
		
	}
	

	/**
	 * update bookType
	 */
	public int updateBookType(Connection con, BookType bookType) throws Exception {

		String sql = "update t_booktype set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());

		return pstmt.executeUpdate();
	}

	/**
	 * add bookType
	 */
	public int addBookType(Connection con, BookType bookType) throws Exception {

		String sql = "insert into t_booktype values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());

		int num = pstmt.executeUpdate();

		return num;
	}

	/**
	 * search bookType
	 */
	public ResultSet selectBookType(Connection con, String bookTypeName) throws Exception {

		String sql = "select * from t_booktype where bookTypeName like '%" + bookTypeName + "%'";
		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, bookTypeName);

		return pstmt.executeQuery();

	}

}
