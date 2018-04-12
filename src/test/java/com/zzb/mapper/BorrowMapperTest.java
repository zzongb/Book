package com.zzb.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzb.entity.Borrow;
import com.zzb.util.DateUtil;

public class BorrowMapperTest {
	
	ApplicationContext context;
	BorrowMapper bookMapper;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		bookMapper = (BorrowMapper) context.getBean("borrowMapper");
	}
	
	@Test
	public void tesInsertBorrow(){
		Borrow borrow = new Borrow();
		borrow.setBorrowDate(DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
		borrow.setBid(1);
		borrow.setReturnBook(DateUtil.formatDate(new Date(),"yyyy-MM-dd"));
		borrow.setSid(1);
		bookMapper.insertBorrowBook(borrow);
		
	}
	
	@Test
	public void testSelectBySid(){
		List<Borrow> list = bookMapper.selectBySid(1);
		System.out.println(list);
	}
	

}
