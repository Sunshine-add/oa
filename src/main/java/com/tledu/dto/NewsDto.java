package com.tledu.dto;

import com.tledu.model.News;

public class NewsDto {
	private int id;
	private String title;

	private String content;

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

	public News getNews() {
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setContent(content);
		return news;
	}
}
