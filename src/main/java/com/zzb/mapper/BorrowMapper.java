package com.zzb.mapper;

import java.util.List;

import com.zzb.entity.Book;
import com.zzb.entity.Borrow;

public interface BorrowMapper {
	
	//添加数据
	void insertBorrowBook(Borrow borrow);
	
	//查询当前用户下的所有图书
	List<Book> selectBook(Borrow borrow);
	
	//根据用户的id来查找借书表
	List<Borrow> selectBySid(Integer sid);
	
	//删除数据
	void deleteBorrowByBid(Integer bid);
	
	//根据bid查找
	List<Borrow> selectById(Integer bid);

}
