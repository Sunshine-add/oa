package com.tledu.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tledu.auth.Admin;
import com.tledu.auth.RoleType;
import com.tledu.dto.myNoteDto;
import com.tledu.model.MyNote;
import com.tledu.model.User;
import com.tledu.service.IMyNoteService;
import com.tledu.util.AjaxObj;
import com.tledu.util.Pager;

/**
 * 登陆就可以操作
 * 
 */
@Controller
@RequestMapping("/MyNote")
public class MyNoteController extends IsRoleController {

	private IMyNoteService myNoteService;

	public IMyNoteService getMyNoteService() {
		return myNoteService;
	}

	@Autowired
	public void setMyNoteService(IMyNoteService myNoteService) {
		this.myNoteService = myNoteService;
	}

	@RequestMapping("/list")
	@Admin(RoleType.Login)
	public String list() {
		return "MyNote/list";
	}

	@RequestMapping("/pager")
	@ResponseBody
	@Admin(RoleType.Login)
	public Pager<MyNote> pager(String sreach, int page, int limit)
			throws UnsupportedEncodingException {
		// 如果不需要模糊查询,设置为空字符串,这样不会影响SQL中的like模糊查询
		if (sreach == null || sreach.trim().equals("")) {
			sreach = "";
		} else {
			// GET请求,汉字会乱码,需要转码
			sreach = sreach.trim();
			sreach = new String(sreach.getBytes("ISO-8859-1"), "UTF-8");
			log("搜索日程 : { " + sreach + " }");
		}
		Pager<MyNote> pager = myNoteService.find(sreach, page, limit);
		return pager;

	}

	@RequestMapping("/add")
	public String add(Model model, HttpSession session) {
		// 需要把登陆的用户传递到页面

		User user = (User) session.getAttribute("loginUser");
		model.addAttribute("user", user);
		return "MyNote/add";
	}

	// 传到后台post
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObj add(MyNote myNote) {

		try {
			// 设置创建时间
			myNote.setCreat_time(new Date());
			myNoteService.add(myNote);
			log("添加便签 : "
					+ JSON.toJSONString(myNote,
							SerializerFeature.WriteMapNullValue));
			return new AjaxObj(1, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxObj(0, "添加失败");
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObj delete(int id) {
		try {
			myNoteService.delete(id);
			log("删除便签 : { ID : " + id + "}");
			return new AjaxObj(1, "删除成功");
		} catch (Exception e) {
			return new AjaxObj(0, e.getMessage());
		}
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
	@ResponseBody
	// 如果是数组传递,会在name后面添加一个[]
	// ids[] 来进行映射
	public AjaxObj delete(@RequestParam("ids[]") int[] ids) {
		try {
			String idsString = "";
			for (int id : ids) {
				myNoteService.delete(id);
				idsString += "," + id;
			}
			log("删除便签 : { Ids : " + idsString.substring(1) + "}");
			return new AjaxObj(1, "删除成功");
		} catch (Exception e) {
			return new AjaxObj(0, e.getMessage());
		}
	}

	@RequestMapping("/update")
	public String update(Integer id, Model model) {
		MyNote myNote = myNoteService.load(id);
		model.addAttribute("myNote", myNote);

		return "MyNote/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObj update(MyNote myNote) {

		try {

			// JSON.toJSONString : 把对象转换为JSON {id:1,name:xxx}
			// SerializerFeature.WriteMapNullValue 如果值为null 就不显示该字段
			myNoteService.update(myNote);
			log("更新日程 : "
					+ JSON.toJSONString(myNote,
							SerializerFeature.WriteMapNullValue));
			System.out.println(myNote.getTitle());
			return new AjaxObj(1, "更新成功");
		} catch (Exception e) {

			return new AjaxObj(0, "更新失败");
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObj edit(myNoteDto myNoteDto) {

		try {
			// JSON.toJSONString : 把对象转换为JSON {id:1,name:xxx}
			// SerializerFeature.WriteMapNullValue 如果值为null 就不显示该字段
			MyNote myNote = myNoteDto.getMyNote();
			myNoteService.edit(myNote);
			log("edit更新便签 : "
					+ JSON.toJSONString(myNote,
							SerializerFeature.WriteMapNullValue));
			return new AjaxObj(1, "更新成功");
		} catch (Exception e) {
			return new AjaxObj(0, "更新失败");
		}
	}
}