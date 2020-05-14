package com.tledu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 我的便签
 * 
 * @author 天亮教育
 * @Date 2020年5月7日
 */
public class Notices {

	private String type;

	private String content;
	/**
	 * 创建者
	 */
	private News news;
	/**
	 * 创建时间,自动设置
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creat_time;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}

}
