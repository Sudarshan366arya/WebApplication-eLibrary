package com.library.interceptor;

import java.util.Map;

import com.library.model.AdminData;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init() { 
		// TODO Auto-generated method stub
	} 

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session=actionInvocation.getInvocationContext().getSession();
		AdminData admin_user=(AdminData)session.get("admin_user");
		if(admin_user==null){
			return ActionSupport.LOGIN;
		}
		return actionInvocation.invoke();
	}
}
