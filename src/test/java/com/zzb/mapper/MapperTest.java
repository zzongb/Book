package com.zzb.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzb.entity.Grade;
import com.zzb.entity.Student;
import com.zzb.entity.User;

public class MapperTest {
	ApplicationContext context ;
	UserMapper userMapper;
	

	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		userMapper = (UserMapper) context.getBean("userMapper");
	}
	
	@Test
	public void testinsert(){
		Student student = new Student();
		student.setSuser("李四");
		student.setSpassword("123456");
		student.setGrade(Grade.大一);
		student.setMajor("网络工程学院");
		userMapper.insertUser(student);
	}
	
	@Test
	public void testupdate(){
		Student student = new Student();
		student.setId(1);
		student.setSuser("张三");
		student.setSpassword("123456");
		student.setGrade(Grade.大三);
		student.setMajor("网络工程学院");
		userMapper.updateStudent(student);
	}
	
	@Test
	public void testSelect(){
		List<Student> list = userMapper.select();
		list.forEach(System.out::println);
	}
	
	@Test
	public void testDeleteById(){
		userMapper.deleteStudentById(3);
	}
	
	@Test
	public void testUserName(){
		User user = userMapper.selectUser("admin");
		System.out.println(user);
	}
	
	@Test
	public void testStudentName(){
		Student student = userMapper.selectStudent("张三");
		System.out.println(student);
	}
}
