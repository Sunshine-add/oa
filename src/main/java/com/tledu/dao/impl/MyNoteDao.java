package com.tledu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tledu.dao.IMyNoteDao;
import com.tledu.model.Meeting;
import com.tledu.model.MyNote;
import com.tledu.util.Pager;

@Repository("myNoteDao")
public class MyNoteDao extends SqlSessionDaoSupport implements IMyNoteDao {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public MyNote load(int id) {
		return getSqlSession().getMapper(IMyNoteDao.class).load(id);
	}

	@Override
	public int find_count(String sreach) {
		return getSqlSession().getMapper(IMyNoteDao.class).find_count(sreach);
	}

	@Override
	public Pager<MyNote> find(String sreach, int page, int limit) {
		Pager<MyNote> pager = new Pager<MyNote>();
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
		List<MyNote> users = getSqlSession().selectList(
				"com.tledu.dao.IMyNoteDao.find", map);
		pager.setData(users);
		return pager;
	}

	@Override
	public List<MyNote> list() {
		return getSqlSession().getMapper(IMyNoteDao.class).list();
	}

	@Override
	public void add(MyNote myNote) {
		getSqlSession().getMapper(IMyNoteDao.class).add(myNote);
	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IMyNoteDao.class).delete(id);
	}

	@Override
	public void update(MyNote myNote) {
		System.out.println(myNote.getTitle());
		getSqlSession().getMapper(IMyNoteDao.class).update(myNote);
	}

	@Override
	public void edit(MyNote myNote) {
		getSqlSession().getMapper(IMyNoteDao.class).edit(myNote);
	}

	@Override
	public List<Meeting> listMeeting() {
		return getSqlSession().getMapper(IMyNoteDao.class).listMeeting();
	}

}
