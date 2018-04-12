package com.zzb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.entity.Book;
import com.zzb.entity.Borrow;
import com.zzb.entity.Student;
import com.zzb.mapper.BookMapper;
import com.zzb.mapper.BorrowMapper;
import com.zzb.mapper.UserMapper;
import com.zzb.service.BorrowBookService;
import com.zzb.vo.BorrowVo;

@Service
public class BorrowBookImpl implements BorrowBookService{

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	BorrowMapper borrowMapper;
	
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public Student selectStudent(String username) {
		Student student = userMapper.selectStudent(username);
		return student;
	}

	@Override
	public void insertBorrowBook(Borrow borrow) {
		borrowMapper.insertBorrowBook(borrow);
		
	}

	@Override
	public BorrowVo selectByBorrowVo(Integer sid) {
		List<Book> list2 = null;
		List<Integer> list1 = new ArrayList<>();
		BorrowVo borrowVo = new BorrowVo();
		List<Borrow> list = borrowMapper.selectBySid(sid);
		
		for(Borrow borrow : list){
			list1.add(borrow.getBid());
		}
		
		if(list1 != null){
			 list2 = bookMapper.selectByArray(list1);
		}
		
		borrowVo.setBooks(list2);
		borrowVo.setBorrows(list);
		return borrowVo;
	}

	@Override
	public void deleteBorrowById(Integer bid) {
		borrowMapper.deleteBorrowByBid(bid);
	}

	@Override
	public List<Borrow> selectByBid(Integer bid) {
		
		List<Borrow> list = borrowMapper.selectById(bid);
		
		return list;
	}

	
	
	

}
