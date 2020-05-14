package com.tledu.dao;

import java.util.List;

import com.tledu.model.Meeting;
import com.tledu.model.News;
import com.tledu.util.Pager;

public interface INewsDao {

	public News load(int id);

	public int find_count(String sreach);

	public Pager<News> find(String sreach, int page, int limit);

	public List<News> list();

	public void add(News news);

	public void delete(int id);

	public void update(News news);

	public void edit(News news);

	public List<Meeting> listMeeting();

}
