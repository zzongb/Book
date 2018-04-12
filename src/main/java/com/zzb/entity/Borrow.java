package com.zzb.entity;

/**
 * 借书类
 * @author Z
 * @version 1.8
 * @CreateDate 2018年3月19日 上午10:38:18
 */
public class Borrow {

	private Integer id;
	
	private String borrowDate;//借书的日期
	
	private String  returnBook;//还书日期
	
	private Integer sid;//是谁借的书
	
	private Integer bid;//借的是哪本图书
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String  getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String  borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnBook() {
		return returnBook;
	}

	public void setReturnBook(String  returnBook) {
		this.returnBook = returnBook;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Borrow(Integer id, String borrowDate, String returnBook, Integer sid, Integer bid) {
		super();
		this.id = id;
		this.borrowDate = borrowDate;
		this.returnBook = returnBook;
		this.sid = sid;
		this.bid = bid;
	}

	
	
	
}
