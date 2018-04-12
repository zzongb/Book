package com.zzb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.entity.Book;
import com.zzb.vo.BookVo;

public interface BookMapper {
	
	//查询所有书籍和通过书名来进行查询
	List<Book> selectBook(BookVo bookVo);
	
	//添加书籍
	void insertBook(Book book);
	
	//修改图书
	void updateBook(Book book);
	
	//根据id来进行查询
	Book updateBookById(Integer id);
	
	//删除图书
	void deleteBookById(Integer id);
	
	//根据图书id进行查找
	Book selectById(Integer id);
	
	//
	List<Book> selectByArray(@Param("bid")List<Integer> integers);
	
}
