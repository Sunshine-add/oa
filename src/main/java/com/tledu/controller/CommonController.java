package com.tledu.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tledu.model.OperationLog;
import com.tledu.model.User;
import com.tledu.service.IOperationLogService;

/**
 * 公共模块 记录日志用
 * 
 * @author 天亮教育
 * @Date 2020年4月27日
 */
@Controller
public class CommonController {
	private IOperationLogService operationLogService;
	private HttpServletRequest request;

	public HttpServletRequest getRequest() {
		return request;
	}

	@Autowired
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public IOperationLogService getOperationLogService() {
		return operationLogService;
	}

	@Autowired
	public void setOperationLogService(IOperationLogService operationLogService) {
		this.operationLogService = operationLogService;
	}

	public void log(String desc){
		OperationLog operationLog = new OperationLog();
		operationLog.setCome_time(new Date());
		operationLog.setDesc(desc);
		User user = (User) request.getSession().getAttribute("loginUser");
		operationLog.setUser(user);
		
		operationLogService.add(operationLog);
	}
}
