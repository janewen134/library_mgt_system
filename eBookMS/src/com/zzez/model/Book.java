package com.zzez.model;

/**
 * @book Model
 * 
 * @author Jing Wen
 *
 *         2019.6.6.
 */
public class Book {

	public Book() {
	}

	public Book(String bookName, String author, String publisher, String material, int bookTypeId, String bookDesc,
			String positionCode) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.material = material;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
		this.positionCode = positionCode;
	}

	public Book(int id, String bookName, String author, String publisher, String material, int bookTypeId,
			String bookDesc, String positionCode) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.material = material;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
		this.positionCode = positionCode;
	}

	private int id;
	private String bookName;
	private String author;
	private String publisher;
	private String material;
	private int bookTypeId;
	private String bookDesc;
	private String positionCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	

}
