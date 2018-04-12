package com.zzb.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzb.entity.Book;
import com.zzb.vo.BookVo;

public class BookMapperTest {
	
	ApplicationContext context;
	BookMapper bookMapper;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		bookMapper = (BookMapper) context.getBean("bookMapper");
	}
	
	@Test
	public void testinsertBook(){
		Book book = new Book();
		book.setAuthor("鲁迅");
		book.setBalante(10);
		book.setBname("狂人日记");
		book.setInfo("这是鲁迅先生的第一部白话文小说");
		book.setIsbn("2018032001");
		book.setNum(10);
		book.setPrice(32.2);
		book.setPublishDate(new Date());
		book.setPublishhouse("机械出版社");
		book.setType("文学类");
		bookMapper.insertBook(book);
	}
	
	@Test
	public void testdeleteBookByIsbn(){
		bookMapper.deleteBookById(1);
	}
	
	
	@Test
	public void testUpdateById(){
		Book book = new Book();
		book.setId(1);
		book.setAuthor("鲁迅");
		book.setBalante(10);
		book.setBname("狂人日记");
		book.setInfo("这是鲁迅先生的第一部白话文小说");
		book.setIsbn("2018032001");
		book.setNum(10);
		book.setPrice(33.3);
		book.setPublishDate(new Date());
		book.setPublishhouse("机械出版社");
		book.setType("文学类");
		bookMapper.updateBook(book);
	}
	
	@Test
	public void testseleteAllBook(){
		BookVo bookVo = null;
		List<Book> list = bookMapper.selectBook(bookVo);
		System.out.println(list);
	}
	
	@Test
	public void testSelectBook(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(41);
		List<Book> list2 = bookMapper.selectByArray(list);
		System.out.println(list2);
	}
	
	@Test
	public void testSelectById(){
		Book book = bookMapper.updateBookById(1);
		System.out.println(book);
	}
	
	

}
