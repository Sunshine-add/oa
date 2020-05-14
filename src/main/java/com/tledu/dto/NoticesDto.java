package com.tledu.dto;

import java.util.Date;

import com.tledu.model.Notices;

public class NoticesDto {

	private String type;

	private String content;

	private Date creat_time;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Notices getNotices() {
		Notices notices = new Notices();
		notices.setContent(content);
		notices.setCreat_time(creat_time);
		notices.setType(type);
		return notices;
	}
}
