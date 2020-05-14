package com.tledu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.dao.INoticesDao;
import com.tledu.model.Notices;
import com.tledu.service.INoticesService;
import com.tledu.util.Pager;

@Service("noticesService")
public class NoticesService implements INoticesService {

	INoticesDao noticesDao;

	public INoticesDao getNoticesDao() {
		return noticesDao;
	}

	@Autowired
	public void setNoticesDao(INoticesDao noticesDao) {
		this.noticesDao = noticesDao;
	}

	@Override
	public Notices load(int id) {

		return noticesDao.load(id);
	}

	@Override
	public int find_count(String sreach) {

		return noticesDao.find_count(sreach);
	}

	@Override
	public Pager<Notices> find(String sreach, int page, int limit) {

		sreach = "%" + sreach + "%";
		return noticesDao.find(sreach, page, limit);
	}

	@Override
	public List<Notices> list() {

		return noticesDao.list();
	}

}
