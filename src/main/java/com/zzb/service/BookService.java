package com.zzb.service;

import java.util.List;

import com.zzb.entity.Book;
import com.zzb.vo.BookVo;

public interface BookService {
	
	//获取全部的图书
	List<Book> selectBook(BookVo bookVo);
	
	//增加图书
	String insertBook(Book book);
	
	//根据id查询书籍
	Book selectBookId(Integer id);
	
	//删除图书
	void deleteBookById(Integer id);

}
