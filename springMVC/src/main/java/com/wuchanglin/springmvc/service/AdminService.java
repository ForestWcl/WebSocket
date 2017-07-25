package com.wuchanglin.springmvc.service;

import com.wuchanglin.springmvc.entity.Admin;

public interface AdminService {

	Admin loginCheck(String loginId, String loginPsw);

}
