package com.tledu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 我的便签
 * 
 * @author 天亮教育
 * @Date 2020年5月7日
 */
public class News {
	private int id;
	private String title;

	private String content;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 创建者
	 */
	private User user;
	/**
	 * 创建时间,自动设置
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creat_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}

}
