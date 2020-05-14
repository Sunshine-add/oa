package com.tledu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tledu.dao.INoticesDao;
import com.tledu.model.Notices;
import com.tledu.util.Pager;

@Repository("noticesDao")
public class NoticesDao extends SqlSessionDaoSupport implements INoticesDao {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public Notices load(int id) {
		return getSqlSession().getMapper(INoticesDao.class).load(id);
	}

	@Override
	public int find_count(String sreach) {
		return getSqlSession().getMapper(INoticesDao.class).find_count(sreach);
	}

	@Override
	public Pager<Notices> find(String sreach, int page, int limit) {
		Pager<Notices> pager = new Pager<Notices>();
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
		List<Notices> users = getSqlSession().selectList(
				"com.tledu.dao.INoticesDao.find", map);
		pager.setData(users);
		return pager;
	}

	@Override
	public List<Notices> list() {
		return getSqlSession().getMapper(INoticesDao.class).list();
	}

}
