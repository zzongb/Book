package com.zzb.service;

import java.util.List;

import com.zzb.entity.Student;
import com.zzb.vo.StudentVo;

public interface UserService {

	//登录
	String login(String username,String passwrod);
	
	//所有的用户
	List<Student> selectStudent();
	
	//添加用户
	String save(Student student);
	
	//根据用户id查询
	Student selectById(Integer id);
	
	//根据用户id删除
	void deleteById(Integer id);
	
	//根据用户名模糊查询
	List<Student> selectBySuser(StudentVo studentVo);
}
