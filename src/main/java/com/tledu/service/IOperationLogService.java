package com.tledu.service;

import com.tledu.model.OperationLog;
import com.tledu.util.Pager;

public interface IOperationLogService {

	public void add(OperationLog operationLog);

	public Pager<OperationLog> find(String sreach, int page, int limit);

}
