package com.tledu.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tledu.dao.IRoleDao;
import com.tledu.model.Role;

@Repository("roleDao")
public class RoleDao extends SqlSessionDaoSupport implements IRoleDao {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<Role> list() {
		return getSqlSession().getMapper(IRoleDao.class).list();
	}

}
