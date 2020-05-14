package com.tledu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.dao.IMyNoteDao;
import com.tledu.model.Meeting;
import com.tledu.model.MyNote;
import com.tledu.service.IMyNoteService;
import com.tledu.util.Pager;

@Service("myNoteService")
public class MyNoteService implements IMyNoteService {
	IMyNoteDao MyNoteDao;

	public IMyNoteDao getMyNoteDao() {
		return MyNoteDao;
	}

	@Autowired
	public void setMyNoteDao(IMyNoteDao myNoteDao) {
		MyNoteDao = myNoteDao;
	}

	@Override
	public MyNote load(int id) {

		return MyNoteDao.load(id);
	}

	@Override
	public int find_count(String sreach) {

		return MyNoteDao.find_count(sreach);
	}

	@Override
	public Pager<MyNote> find(String sreach, int page, int limit) {

		sreach = "%" + sreach + "%";
		return MyNoteDao.find(sreach, page, limit);
	}

	@Override
	public List<MyNote> list() {

		return MyNoteDao.list();
	}

	@Override
	public void add(MyNote myNote) {
		MyNoteDao.add(myNote);
	}

	@Override
	public void delete(int id) {
		MyNoteDao.delete(id);
	}

	@Override
	public void update(MyNote myNote) {
		MyNoteDao.update(myNote);

	}

	@Override
	public void edit(MyNote myNote) {
		MyNoteDao.edit(myNote);
	}

	@Override
	public List<Meeting> listMeeting() {

		return MyNoteDao.listMeeting();
	}

}
