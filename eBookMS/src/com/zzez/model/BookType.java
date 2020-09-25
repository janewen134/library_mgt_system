package com.zzez.model;

/**
 * @图书类型模型
 * @author Jing Wen
 *
 *         2019.6.5.
 */
public class BookType {

	public BookType() {
	}

	public BookType(String bookTypeName, String bookTypeDesc) {
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}

	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}

	private int id;
	private String bookTypeName;
	private String bookTypeDesc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public String getBookTypeDesc() {
		return bookTypeDesc;
	}

	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}

	@Override
	public String toString() {

		return bookTypeName;

	}

}
