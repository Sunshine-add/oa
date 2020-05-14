package com.tledu.dao;

import java.util.List;

import com.tledu.model.SidebarSup;

public interface ISidebarSupDao {
	public List<SidebarSup> list(int isAdmin);
}
