package com.zzb.vo;

import java.util.List;

import com.zzb.entity.Book;
import com.zzb.entity.Borrow;

public class BorrowVo {
	
	private List<Borrow> borrows;
	
	private List<Book> books;

	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public BorrowVo() {
		super();
	}
	
	

}
