package com.zzb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzb.entity.Student;
import com.zzb.service.UserService;
import com.zzb.vo.StudentVo;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(String username,String password,HttpSession session) throws Exception{
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		return userService.login(username, password);
	}
	
	@RequestMapping("/admin")
	public String admin(Model model,StudentVo studentVo) throws Exception{
		//先将用户列表打印出来
		/*List<Student> list = userService.selectStudent();*/
		List<Student> list = userService.selectBySuser(studentVo);
		model.addAttribute("studentList",list);
		return "admin";
	}
	/**
	 * 添加用户
	 */
	@RequestMapping("/addpage")
	public String addStudent(Model model) throws Exception {
		return "addStudent";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Student student) throws Exception {
		System.out.println(student);
		return userService.save(student);
	}
	
	@RequestMapping("/updatepage")
	public String updatepage(Model model ,Integer id) throws Exception {
		Student student = userService.selectById(id);
		
		model.addAttribute("student",student);
		//跳转到添加页面
		return "addStudent";
	}
	
	@RequestMapping("/deletepage")
	@ResponseBody
	public String deletepage(Model model,Integer id) throws Exception {
		userService.deleteById(id);
		return "OK";
	}
	
	
	

}
