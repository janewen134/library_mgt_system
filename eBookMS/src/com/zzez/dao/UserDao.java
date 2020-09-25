package com.zzez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zzez.model.User;

/**
 * @ÓÃ»§²Ù×÷
 * @author Jing Wen
 *
 * 2019.6.5.
 */
public class UserDao {
	
	public boolean login(Connection con, User user) throws Exception {
		
		String sql = "select * from t_user where userName=? and passWord=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getPassword());
		
		ResultSet rs = pstmt.executeQuery();
		
		return rs.next();
	}

}
