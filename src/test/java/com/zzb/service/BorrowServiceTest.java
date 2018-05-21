package com.zzb.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzb.entity.Book;
import com.zzb.entity.Borrow;
import com.zzb.vo.BorrowVo;

public class BorrowServiceTest {
	ApplicationContext context ;
	BorrowBookService borrowBookService;

	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		borrowBookService =  (BorrowBookService) context.getBean("borrowBookImpl");
	}
	
	@Test
	public void testselectByBorrowVo(){
		BorrowVo borrowVo = borrowBookService.selectByBorrowVo(81);
		List<Book> list = borrowVo.getBooks();
		List<Borrow> list2 = borrowVo.getBorrows();
		System.out.println(list);
		System.out.println(list2);
	}

}
