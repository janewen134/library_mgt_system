package com.zzez.model;

/**
 * @user model
 * @author Jing Wen
 *
 *         2019.6.5.
 */
public class User {

	public User() {
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	private int id;
	private String name;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
