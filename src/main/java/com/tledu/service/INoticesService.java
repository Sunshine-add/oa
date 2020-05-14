package com.tledu.service;

import java.util.List;

import com.tledu.model.Notices;
import com.tledu.util.Pager;

public interface INoticesService {

	public Notices load(int id);

	public int find_count(String sreach);

	public Pager<Notices> find(String sreach, int page, int limit);

	public List<Notices> list();

}
