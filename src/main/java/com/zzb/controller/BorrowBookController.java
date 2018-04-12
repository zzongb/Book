package com.zzb.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzb.entity.Book;
import com.zzb.entity.Borrow;
import com.zzb.entity.Student;
import com.zzb.service.BookService;
import com.zzb.service.BorrowBookService;
import com.zzb.util.DateUtil;
import com.zzb.vo.BookVo;
import com.zzb.vo.BorrowVo;


@Controller
public class BorrowBookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BorrowBookService borrowBookService;
	
	
	@RequestMapping("/user")
	public String bookList(Model model ,HttpSession session,BookVo bookVo) throws Exception {
		String username = (String) session.getAttribute("username");
		Student student = borrowBookService.selectStudent(username);
		session.setAttribute("student", student);
		
		List<Book> list = bookService.selectBook(bookVo);
		model.addAttribute("list",list);
		
		return "borrowBookList";
	}
	
	
	@RequestMapping("/borrowPage")
	public String borrowPage(Integer id,HttpSession session) throws Exception {
		Book book = bookService.selectBookId(id);
		System.out.println(book);
		Integer balante = book.getBalante() - 1;
		book.setBalante(balante);
		bookService.insertBook(book);
		
		Student student = (Student) session.getAttribute("student");
		Borrow borrow = new Borrow();
		borrow.setBid(id);
		borrow.setBorrowDate(DateUtil.formatDate(new Date(),"yyyy-MM-dd"));
		borrow.setSid(student.getId());
		//时间上相加，报出异常第二个日期有问题
		borrow.setReturnBook(DateUtil.add(new Date()));
		borrowBookService.insertBorrowBook(borrow);
		
		return "redirect:user";
		
	}
	
	@RequestMapping("/returnBook")
	public String returnBook(Model model ,HttpSession session) throws Exception {
		
		Student student = (Student) session.getAttribute("student");
		System.out.println(student);
		BorrowVo borrowVo = borrowBookService.selectByBorrowVo(student.getId());
		model.addAttribute("borrowVo",borrowVo);
		return "list";
		
	}
	
	@RequestMapping("/borrowBookXingqing")
	public String borrowBookXingqing(Model model ,Integer id) throws Exception{
		System.out.println(id);
		Book book = bookService.selectBookId(id);
		System.out.println(book);
		model.addAttribute("book",book);
		return "xiangqingPage";
		
	}
	
	@RequestMapping("/returnBookPage")
	public String deleteBorrow(Integer id) throws Exception {
		borrowBookService.deleteBorrowById(id);
		//根据bid查找Borrow
		List<Borrow> list = borrowBookService.selectByBid(id);
		
		Book book = bookService.selectBookId(id);
		Integer balante = book.getBalante();
		book.setBalante(balante+list.size());
		System.out.println(book.getBalante());
		bookService.insertBook(book);
		return "forward:returnBook";
	}
	

}
