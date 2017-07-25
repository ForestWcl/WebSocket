package com.wuchanglin.springmvc.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter{

	private String sign;
	private String dispatcherUrlOfFail;
	private String authorityFlag;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute(authorityFlag)==null){
			request.setAttribute("tip", sign);
			request.getRequestDispatcher(dispatcherUrlOfFail).forward(request, response);
			return false;
		}
		return true;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getDispatcherUrlOfFail() {
		return dispatcherUrlOfFail;
	}
	public void setDispatcherUrlOfFail(String dispatcherUrlOfFail) {
		this.dispatcherUrlOfFail = dispatcherUrlOfFail;
	}
	public String getAuthorityFlag() {
		return authorityFlag;
	}
	public void setAuthorityFlag(String authorityFlag) {
		this.authorityFlag = authorityFlag;
	}
	
	
}
