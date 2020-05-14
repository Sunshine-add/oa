package com.tledu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tledu.dao.INewsDao;
import com.tledu.model.Meeting;
import com.tledu.model.News;
import com.tledu.util.Pager;

@Repository("newsDao")
public class NewsDao extends SqlSessionDaoSupport implements INewsDao {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public News load(int id) {
		return getSqlSession().getMapper(INewsDao.class).load(id);
	}

	@Override
	public int find_count(String sreach) {
		return getSqlSession().getMapper(INewsDao.class).find_count(sreach);
	}

	@Override
	public Pager<News> find(String sreach, int page, int limit) {
		Pager<News> pager = new Pager<News>();
		// 查询总条数
		int count = find_count(sreach);
		pager.setCount(count);

		// 准备参数
		Map<String, Object> map = new HashMap<String, Object>();
		// 起始值
		// limit 起始值 , 条数 , 并且 起始值 0开始
		// 起始值是 页数 -1 乘 每页的条数
		map.put("pageOffset", (page - 1) * limit);
		map.put("limit", limit);
		map.put("sreach", sreach);
		// 查询
		List<News> users = getSqlSession().selectList(
				"com.tledu.dao.INewsDao.find", map);
		pager.setData(users);
		return pager;
	}

	@Override
	public List<News> list() {
		return getSqlSession().getMapper(INewsDao.class).list();
	}

	@Override
	public void add(News news) {
		getSqlSession().getMapper(INewsDao.class).add(news);
	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(INewsDao.class).delete(id);
	}

	@Override
	public void update(News news) {
		getSqlSession().getMapper(INewsDao.class).update(news);
	}

	@Override
	public void edit(News news) {
		getSqlSession().getMapper(INewsDao.class).edit(news);
	}

	@Override
	public List<Meeting> listMeeting() {
		return getSqlSession().getMapper(INewsDao.class).listMeeting();
	}

}
