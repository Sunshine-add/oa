package com.tledu.service;

import java.util.List;

import com.tledu.model.Branch;
import com.tledu.util.Pager;

public interface IBranchService {
	public Pager<Branch> find(String sreach, int page, int limit);
	public void add(Branch branch);
	
	public void update(Branch branch);

	public void delete(int id);

	public List<Branch> list();
	public Branch load(int id);
}
