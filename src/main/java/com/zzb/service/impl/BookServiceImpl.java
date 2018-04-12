package com.zzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.entity.Book;
import com.zzb.mapper.BookMapper;
import com.zzb.service.BookService;
import com.zzb.vo.BookVo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;
	
	

	@Override
	public String insertBook(Book book) {
		if(book.getId() == null){
			bookMapper.insertBook(book);
		} else {
			bookMapper.updateBook(book);
		}
		return "success";
	}



	@Override
	public List<Book> selectBook(BookVo bookVo) {
		
		return bookMapper.selectBook(bookVo);
	}



	@Override
	public Book selectBookId(Integer id) {
		
		return bookMapper.updateBookById(id);
	}



	@Override
	public void deleteBookById(Integer id) {
		bookMapper.deleteBookById(id);
	}

}
