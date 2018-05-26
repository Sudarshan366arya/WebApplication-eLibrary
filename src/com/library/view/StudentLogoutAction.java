package com.library.view;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class StudentLogoutAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private SessionMap<String,Object> session;
	public SessionMap<String, Object> getSession() {
		return session;
	}
	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}
	@Override
	public String execute(){
		session.invalidate();
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String,Object> map){
		session=(SessionMap<String,Object>)map;
	}
}
