package com.zzb.entity;
/**
 * 管理员
 * @author Z
 * @version 1.8
 * @CreateDate 2018年3月16日 下午10:38:37
 */
public class User {
	
	private Integer id;
	private String username;
	private String password;
	private Integer status;//管理员的状态为0
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public User(Integer id, String username, String password, Integer status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
