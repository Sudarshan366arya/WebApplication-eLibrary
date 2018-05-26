package com.library.view;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.library.controller.LibraryManager;
import com.library.model.AdminData;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private LibraryManager librarymanager;
	private AdminData admindata;
	private List<AdminData> adminList;
	private String message;
	private SessionMap<String, Object> session;
	
	public String execute(){
		librarymanager=new LibraryManager();
		String encryptedText = "";    
		try {  
	            MessageDigest md = MessageDigest.getInstance("MD5");  
	            byte encryptedData[] = md.digest(getAdmindata().getAdmin_password().getBytes());  
	            StringBuffer hexString = new StringBuffer();  
	            for (int i = 0; i < encryptedData.length; i++) {  
	                String hex = Integer.toHexString(0xFF & encryptedData[i]);  
	                if (hex.length() == 1) {  
	                    hexString.append('0');  
	                }  
	                hexString.append(hex);  
	            }  
	            encryptedText = hexString.toString();  
	         } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	        }
		adminList=librarymanager.authenticateAdmin(getAdmindata().getAdmin_user_name(),encryptedText);
		if(adminList.size()!=1){
		  setMessage("Invalid Login details");
		  return LOGIN;
		}else{
		session.put("admin_user",admindata.getAdmin_user_name());
		admindata.setAdmin_name(adminList.get(0).getAdmin_name());
		admindata.setAdmin_id(adminList.get(0).getAdmin_id());
		return SUCCESS;
	 }
	}
	public AdminData getAdmindata() {
		return admindata;
	}
	public void setAdmindata(AdminData admindata) {
		this.admindata = admindata;
	}
	public SessionMap<String, Object> getSession() {
		return session;
	}
	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}
	@Override
	public void setSession(Map<String, Object> map) {
		session=(SessionMap<String, Object>) map;
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<AdminData> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<AdminData> adminList) {
		this.adminList = adminList;
	}
}
