package com.tledu.service;

import java.util.List;

import com.tledu.model.Meeting;
import com.tledu.model.MyNote;
import com.tledu.util.Pager;

public interface IMyNoteService {

	public MyNote load(int id);

	public int find_count(String sreach);

	public Pager<MyNote> find(String sreach, int page, int limit);

	public List<MyNote> list();

	public void add(MyNote myNote);

	public void delete(int id);

	/**
	 * 创建时间和创建者 不可以更改
	 * 
	 * @param mySchedule
	 */
	public void update(MyNote myNote);

	/**
	 * 不更新关联对象列,时间相关的也不更改
	 * 
	 * @param user
	 */
	public void edit(MyNote myNote);

	/**
	 * 查询所有的会议类型,添加和更新 会用到
	 * 
	 * @return
	 */
	public List<Meeting> listMeeting();
}
