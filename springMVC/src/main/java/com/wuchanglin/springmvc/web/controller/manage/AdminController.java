package com.wuchanglin.springmvc.web.controller.manage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sun.tracing.dtrace.Attributes;
import com.sun.tracing.dtrace.ModuleAttributes;
import com.wuchanglin.springmvc.entity.Admin;
import com.wuchanglin.springmvc.service.AdminService;

@Controller
@RequestMapping("/manage/admin")
@SessionAttributes("currAdmin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/loginForm")
	public String loginForm(){
		return "manage/adminlogin";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(String loginId,String loginPsw,Map<String,Object> model){
		System.out.println("login:"+ loginId + "\n loginPsw:"+ loginPsw);
		Admin admin = adminService.loginCheck(loginId,loginPsw);
		if(admin==null){
			model.put("tip", "登录失败，账号或密码错误！");
			return "manage/adminlogin";
		}
		model.put("currAdmin", admin);
		return "redirect:/manage/admin/adminHome";
	}
	
	@RequestMapping("/adminHome")
	public String adminHome(){
		return "manage/adminhome";
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
}
