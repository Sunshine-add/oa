package com.tledu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.dao.impl.NewsDao;
import com.tledu.model.Meeting;
import com.tledu.model.News;
import com.tledu.service.INewsService;
import com.tledu.util.Pager;

@Service("newsService")
public class NewsService implements INewsService {
	NewsDao newsDao;

	public NewsDao getNewsDao() {
		return newsDao;
	}

	@Autowired
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public News load(int id) {

		return newsDao.load(id);
	}

	public int find_count(String sreach) {

		return newsDao.find_count(sreach);
	}

	public Pager<News> find(String sreach, int page, int limit) {

		sreach = "%" + sreach + "%";
		return newsDao.find(sreach, page, limit);
	}

	public List<News> list() {

		return newsDao.list();
	}

	public void add(News news) {
		newsDao.add(news);
	}

	public void delete(int id) {
		newsDao.delete(id);
	}

	public void update(News news) {
		newsDao.update(news);

	}

	public void edit(News news) {
		newsDao.edit(news);
	}

	public List<Meeting> listMeeting() {

		return newsDao.listMeeting();
	}

}
