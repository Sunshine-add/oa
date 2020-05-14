package com.tledu.dao;

import com.tledu.model.OperationLog;
import com.tledu.util.Pager;

public interface IOperationLogDao {
	public void add(OperationLog operationLog);
	
	public int find_count(String sreach);

	public Pager<OperationLog> find(String sreach, int page, int limit);
	
}
