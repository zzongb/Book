package com.zzb.entity;
/**
 * 用户类
 * @author Z
 * @version 1.8
 * @CreateDate 2018年3月16日 下午10:40:30
 */
public class Student {

	private Integer id;
	private String suser;
	private String spassword;
	private Grade grade; //年级
	private String major;//专业//使用下拉框进行选择
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSuser() {
		return suser;
	}
	public void setSuser(String suser) {
		this.suser = suser;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Student(Integer id, String suser, String spassword, Grade grade, String major, Integer status) {
		super();
		this.id = id;
		this.suser = suser;
		this.spassword = spassword;
		this.grade = grade;
		this.major = major;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", suser=");
		builder.append(suser);
		builder.append(", spassword=");
		builder.append(spassword);
		builder.append(", grade=");
		builder.append(grade);
		builder.append(", major=");
		builder.append(major);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
