package com.zzez.util;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @MYSQL operation
 * @author Jing Wen 
 * @2019.6.4.
 */

public class JdbcUtil {

	private String url;
	private String user;
	private String password;
	private String[] s;
	private String sqlName = "com.mysql.jdbc.Driver";
	
	
	/**
	 * get info
	 */
	private String[] getInfo() {
		
		String str = "";
		
		try {
			Reader fr = new FileReader("info.txt");
			char[] chars = new char[1024];
			int len = -1;
			while((len = fr.read(chars)) != -1) {
				str = str + new String(chars, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] s = str.split(","); 
		return s;
	}
	/**
	 * Creat connection whith MYSQL
	 */
	public Connection getCon() throws Exception {
		
		s = getInfo();
		url = "jdbc:mysql://" + s[0] + ":" + s[1] +"/" +s[2];
		user = s[3];
		password = s[4];

		Class.forName(sqlName);
		Connection con = DriverManager.getConnection(url, user, password);

		return con;

	}

	public static void main(String[] args) {

		JdbcUtil jdbcUtil = new JdbcUtil();
		try {
			Connection con = jdbcUtil.getCon();
			System.out.println("connction success.");
			jdbcUtil.closeCon(con);
			System.out.println("connction close.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * interrupt connection
	 * 
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception {

		if (con != null) {

			con.close();

		}

	}

}
