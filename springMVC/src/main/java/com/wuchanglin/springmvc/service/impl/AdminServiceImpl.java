package com.wuchanglin.springmvc.service.impl;

import org.springframework.stereotype.Service;

import com.wuchanglin.springmvc.entity.Admin;
import com.wuchanglin.springmvc.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public Admin loginCheck(String loginId, String loginPsw) {
		
		if("admin".equals(loginId)&& "000000".equals(loginPsw)){
			Admin ad = new Admin();
			ad.setId(1);
			ad.setLoginId("admin");
			ad.setLoginPsw("000000");
			ad.setName("管理员");
			
			return ad; 
		}
		return null;
	}

}
