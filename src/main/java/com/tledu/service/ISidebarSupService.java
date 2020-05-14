package com.tledu.service;

import java.util.List;

import com.tledu.model.SidebarSup;
import com.tledu.model.User;

public interface ISidebarSupService {
	public List<SidebarSup> list(User user);
}
