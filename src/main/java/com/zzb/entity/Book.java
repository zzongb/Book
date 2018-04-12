package com.zzb.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 图书类
 * @author Z
 * @version 1.8
 * @CreateDate 2018年3月19日 上午9:30:43
 */
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5990851888517712506L;
	private Integer id;
	private String isbn;//图书编号
	private String bname;//书名
	private String author;//作者
	private double price;//价格
	private String publishhouse;//出版社
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date publishDate;
	
	private String info;//图书信息
	private Integer num;//图书总数
	private Integer balante;//图书剩余数量
	private String type;//图书类别
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublishhouse() {
		return publishhouse;
	}
	public void setPublishhouse(String publishhouse) {
		this.publishhouse = publishhouse;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getBalante() {
		return balante;
	}
	public void setBalante(Integer balante) {
		this.balante = balante;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Book() {
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", isbn=");
		builder.append(isbn);
		builder.append(", bname=");
		builder.append(bname);
		builder.append(", author=");
		builder.append(author);
		builder.append(", price=");
		builder.append(price);
		builder.append(", publishhouse=");
		builder.append(publishhouse);
		builder.append(", publishDate=");
		builder.append(publishDate);
		builder.append(", info=");
		builder.append(info);
		builder.append(", num=");
		builder.append(num);
		builder.append(", balante=");
		builder.append(balante);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
