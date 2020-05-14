package com.tledu.service;

import java.util.List;

import com.tledu.model.Dept;
import com.tledu.util.OAException;
import com.tledu.util.Pager;

public interface IDeptService {
	public Dept load(int id);

	public List<Dept> list();

	public void add(Dept dept);

	/**
	 * 部门下有员工,不能删除该部门
	 * 
	 * @param id
	 */
	public void delete(int id) throws OAException;

	public void update(Dept dept);

	/**
	 * 不更新关联列表的列(外键列)
	 * 
	 * @param dept
	 */
	public void edit(Dept dept);

	public Pager<Dept> find(String sreach, int page, int limit);
	
}
