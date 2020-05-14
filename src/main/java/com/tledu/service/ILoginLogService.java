package com.tledu.service;

import com.tledu.model.LoginLog;
import com.tledu.model.User;
import com.tledu.util.OAException;
import com.tledu.util.Pager;

public interface ILoginLogService {

	public User login(User user)  throws OAException;
	
	public void add(LoginLog loginLog);
	
	public Pager<LoginLog> find(String sreach, int page, int limit);
}
