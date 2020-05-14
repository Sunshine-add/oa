package com.tledu.dao;

import java.util.List;

import com.tledu.model.Notices;
import com.tledu.util.Pager;

public interface INoticesDao {

	public Notices load(int id);

	public int find_count(String sreach);

	public Pager<Notices> find(String sreach, int page, int limit);

	public List<Notices> list();

}
