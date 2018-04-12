package com.zzb.service;


import java.util.List;

import com.zzb.entity.Borrow;
import com.zzb.entity.Student;
import com.zzb.vo.BorrowVo;

public interface BorrowBookService {

	//查询用户
	Student selectStudent(String username);
	
	//增加
	void insertBorrowBook(Borrow borrow);
	
	//查询图书
	BorrowVo selectByBorrowVo(Integer sid);
	
	//删除借书
	void deleteBorrowById(Integer bid);
	
	//查询
	List<Borrow> selectByBid(Integer bid);
}
