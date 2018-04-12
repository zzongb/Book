package com.zzb.service;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzb.entity.Book;
import com.zzb.vo.BookVo;


public class BookServiceTest {
	
	ApplicationContext context ;
	BookService bookService;

	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		bookService = (BookService) context.getBean("bookServiceImpl");
	}
	
	@Test
	public void selectBook(){
		BookVo bookVo = null;
		List<Book> list = bookService.selectBook(bookVo);
		System.out.println(list);
	}
	
	@Test
	public void testinsertBook(){
		Book book = new Book();
		book.setAuthor("鲁迅");
		book.setBalante(10);
		book.setBname("朝花夕拾");
		book.setInfo("这是鲁迅先生的第一部白话文小说");
		book.setIsbn("2018032002");
		book.setNum(10);
		book.setPrice(32.2);
		book.setPublishDate(new Date());
		book.setPublishhouse("机械出版社");
		book.setType("文学类");
		bookService.insertBook(book);
	}

}
