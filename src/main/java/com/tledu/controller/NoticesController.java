package com.tledu.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tledu.auth.Admin;
import com.tledu.auth.RoleType;
import com.tledu.model.Notices;
import com.tledu.service.INoticesService;
import com.tledu.util.Pager;

/**
 * 登陆就可以操作
 * 
 */
@Controller
@RequestMapping(value = "/MyNotices")
public class NoticesController extends IsRoleController {

	private INoticesService noticesService;

	public INoticesService getNoticesService() {
		return noticesService;
	}

	Notices notices;

	@Autowired
	public void setNoticesService(INoticesService noticesService) {
		this.noticesService = noticesService;
	}

	@RequestMapping("/list")
	@Admin(RoleType.Login)
	public String list(Model model) {
		System.out.println("找到了");
		model.addAttribute("list", notices);
		return "MyNotices/list";
	}

	@RequestMapping("/pager")
	@ResponseBody
	@Admin(RoleType.Login)
	public Pager<Notices> pager(String sreach, int page, int limit)
			throws UnsupportedEncodingException {
		// 如果不需要模糊查询,设置为空字符串,这样不会影响SQL中的like模糊查询
		if (sreach == null || sreach.trim().equals("")) {
			sreach = "";
		} else {
			// GET请求,汉字会乱码,需要转码
			sreach = sreach.trim();
			sreach = new String(sreach.getBytes("ISO-8859-1"), "UTF-8");
			log("搜索公告 : { " + sreach + " }");
		}
		Pager<Notices> pager = noticesService.find(sreach, page, limit);
		return pager;

	}

}