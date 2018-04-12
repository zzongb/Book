package com.zzb.controller;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzb.entity.Book;
import com.zzb.service.BookService;
import com.zzb.util.DateUtil;
import com.zzb.vo.BookVo;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/selectList")
	public String bookList(Model model,BookVo bookVo) throws Exception {
		List<Book> list = bookService.selectBook(bookVo);
		model.addAttribute("bookList",list);
		return "bookList";
	}
	
	@RequestMapping("/insertBookpage")
	public String insertBookpage() throws Exception {
		return "insertpage";
	}
	
	
	@RequestMapping("/saveBook")
	@ResponseBody
	public String saveBook(HttpServletRequest request) throws Exception {
		//使用Book book无法进行封装
		String isbn = request.getParameter("isbn");
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		Double price = Double.parseDouble(request.getParameter("price"));
		String info = request.getParameter("info");
		String type = request.getParameter("type");
		Integer num = Integer.parseInt(request.getParameter("num"));
		Integer balante = Integer.parseInt(request.getParameter("balante"));
		String publishhouse = request.getParameter("publishhouse");
		Date publishDate = DateUtil.parse(request.getParameter("publishDate"), "yyyy-MM-dd HH:mm:ss");
		Book book = new Book();
		String stringid = request.getParameter("id");
		if(stringid != null && stringid != ""){
			Integer id = Integer.parseInt(stringid);
			book.setId(id);
		}
		book.setAuthor(author);
		book.setBalante(balante);
		book.setBname(bname);
		book.setInfo(info);
		book.setIsbn(isbn);
		book.setPrice(price);
		book.setNum(num);
		book.setPublishDate(publishDate);
		book.setPublishhouse(publishhouse);
		book.setType(type);
		
		return bookService.insertBook(book);
		
	}
	
	@RequestMapping("/updatePage")
	public String updatePage(Model model ,Integer id) throws Exception {
		//根据id来进行查询
		Book book = bookService.selectBookId(id);
		model.addAttribute("book",book);
		return "insertpage";
	}
	
	
	@RequestMapping("/deletePage")
	public String deletePage(Integer id) throws Exception {
		
		bookService.deleteBookById(id);
		return "redirect:selectList";
		
	}

}
