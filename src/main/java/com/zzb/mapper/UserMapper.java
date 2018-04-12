package com.zzb.mapper;

import java.util.List;

import com.zzb.entity.Student;
import com.zzb.entity.User;
import com.zzb.vo.StudentVo;

/**
 * 管理员模块(增加用户，删除用户，修改用户，查询用户（1.查询多个用户,2.）)
 * @author Z
 * @version 1.8
 * @CreateDate 2018年3月19日 下午12:12:14
 */
public interface UserMapper {
	
	/**
	 * 增加用户
	 */
	Integer insertUser(Student student);
	
	/**
	 * 删除用户
	 * 根据id来进行删除
	 */
	void deleteStudentById(Integer id);
	
	/**
	 * 修改用户
	 * 
	 */
	void updateStudent(Student student);
	
	/**
	 * 查询用户
	 */
	List<Student> select();
	
	/**
	 * 根据管理员用户名来进行查找
	 */
	User selectUser(String username);
	
	/**
	 * 根据用户名来进行查找
	 */
	Student selectStudent(String suser);
	
	/**
	 * 通过用户id来进行查找
	 */
	Student selectById(Integer id);
	
	/**
	 * 通过用户id来进行删除
	 */
	void deleteById(Integer id);
	
	/**
	 * 根据用户名进行查询
	 */
	List<Student> selectBySuser(StudentVo studentVo);

}
