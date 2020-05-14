package com.tledu.dto;

import com.tledu.model.MyNote;

public class myNoteDto {
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

	public MyNote getMyNote() {
		MyNote myNote = new MyNote();
		myNote.setId(id);
		myNote.setTitle(title);
		myNote.setContent(content);
		return myNote;
	}
}
