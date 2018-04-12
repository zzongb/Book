package com.zzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.entity.Student;
import com.zzb.entity.User;
import com.zzb.mapper.UserMapper;
import com.zzb.service.UserService;
import com.zzb.vo.StudentVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	/***
	 * 可能存在问题（用户名和管理员为同一账号和密码）
	 */
	@Override
	public String login(String username,String password) {
		//验证是否为管理员
		User user = userMapper.selectUser(username);
		Student student = userMapper.selectStudent(username);
		
		if(user != null){
			if(password.equals(user.getPassword())){
					return "101"; //管理员
				} 
		} else if(student != null) {
			if(password.equals(student.getSpassword())){
				return "102";//用户
			}
		} else {
			return "103";
		}
		return null;
	}

	@Override
	public List<Student> selectStudent() {
		
		return userMapper.select();
	}

	/**
	 * 添加用户
	 */
	@Override
	public String save(Student student) {
		if(student.getId() == null){
			//增加用户
			userMapper.insertUser(student);
		} else {
			userMapper.updateStudent(student);
		}
		
		return "success";
	}

	@Override
	public Student selectById(Integer id) {
		
		Student student = userMapper.selectById(id);
		return student;
	}

	@Override
	public void deleteById(Integer id) {
		userMapper.deleteById(id);
	}

	@Override
	public List<Student> selectBySuser(StudentVo studentVo) {
		return userMapper.selectBySuser(studentVo);
	}

}
