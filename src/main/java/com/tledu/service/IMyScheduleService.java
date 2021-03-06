package com.tledu.service;

import java.util.List;

import com.tledu.model.Meeting;
import com.tledu.model.MySchedule;
import com.tledu.util.Pager;

public interface IMyScheduleService {

	public MySchedule load(int id);

	public Pager<MySchedule> find(String sreach, int page, int limit);

	public List<MySchedule> list();

	public void add(MySchedule mySchedule);

	public void delete(int id);

	/**
	 * 创建时间和创建者 不可以更改
	 * 
	 * @param mySchedule
	 */
	public void update(MySchedule mySchedule);

	/**
	 * 不更新关联对象列,时间相关的也不更改
	 * 
	 * @param user
	 */
	public void edit(MySchedule mySchedule);

	/**
	 * 查询所有的会议类型,添加和更新 会用到
	 * 
	 * @return
	 */
	public List<Meeting> listMeeting();

}
