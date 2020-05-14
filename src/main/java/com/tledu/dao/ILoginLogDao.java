package com.tledu.dao;

import com.tledu.model.LoginLog;
import com.tledu.model.User;
import com.tledu.util.Pager;

public interface ILoginLogDao {
	public User login(String name);
	
	public void add(LoginLog loginLog);
	
	public int find_count(String sreach);

	public Pager<LoginLog> find(String sreach, int page, int limit);
}
