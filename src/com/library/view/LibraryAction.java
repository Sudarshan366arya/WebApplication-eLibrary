package com.library.view;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.library.controller.LibraryManager;
import com.library.model.AdminData;
import com.library.model.AvailableBooks;
import com.library.model.StudentData;
import com.library.model.StudentIssuedDataDto;
import com.library.model.StudentLibraryDto;
import com.library.model.StudentWishlist;
import com.opensymphony.xwork2.ActionSupport;

public class LibraryAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private AdminData admindata;
	private StudentData studentdata;
	private AvailableBooks availablebookedit,availablebooks;
	private LibraryManager librarymanager;
	private StudentWishlist studentWishlist;
	private List<AdminData> adminList;
	private List<StudentData>studentList;
	private List<StudentLibraryDto> issuingBookList,issuingDueList;
	private List<AvailableBooks> availList;
	private List<StudentWishlist> wishBookList;
	private long book_id,admin_id,student_id,booking_id,roll;
	private List<StudentIssuedDataDto> viewBookList,viewBookReturnList;
	public String execute() {
		System.out.println("execute called");
		return SUCCESS;
	}
	private SessionMap<String, Object> session;
	private String message;
	
	public String loginOfAdmin(){
		librarymanager=new LibraryManager();
		String encryptedText = "";    
		try {  
			  if(null!=getAdmindata().getAdmin_user_name()||null!=getAdmindata().getAdmin_password()){
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
	            }else{
	            	return LOGIN;
	            }  
	         } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	        }
		adminList=librarymanager.authenticateAdmin(getAdmindata().getAdmin_user_name(),encryptedText);
		if(adminList.size()!=1){
		  setMessage("Invalid Login details");
		  return LOGIN;
		}else{
		session.put("admin_user",adminList.get(0).getAdmin_name());
		admindata.setAdmin_name(adminList.get(0).getAdmin_name());
		admindata.setAdmin_id(adminList.get(0).getAdmin_id());
		return SUCCESS;
	 }
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
/*
	public String loginOfAdmin(){
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
		//adminList=librarymanager.authenticateAdmin(getAdmindata().getAdmin_user_name(),encryptedText);
    	if(adminList.size()!=1)
			return ERROR;
		else{
			System.out.println(adminList.get(0).getAdmin_id());
			System.out.println(adminList.get(0).getAdmin_name());
			return SUCCESS;
		}
	}
*/
	public String loginOfStudent(){
		librarymanager=new LibraryManager();
		 String encryptedText = "";  
	        try {  
	            MessageDigest md = MessageDigest.getInstance("MD5");  
	            byte encryptedData[] = md.digest(getStudentdata().getPassword().getBytes());  
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
	        studentList=librarymanager.authenticateStudent(getStudentdata().getRoll(),encryptedText);
	        if(studentList.size()!=1){
	  		  setMessage("Invalid Login details");
	  		  return LOGIN;
	  		}else{
	  		session.put("student_user",studentList.get(0).getName());
	  		studentdata.setName(studentList.get(0).getName());
	  		studentdata.setStudent_id(studentList.get(0).getStudent_id());
	  		return SUCCESS;
	  	 }
 }

	
	/*
	public String loginOfStudent(){
		librarymanager=new LibraryManager();
		 String encryptedText = "";  
	        try {  
	            MessageDigest md = MessageDigest.getInstance("MD5");  
	            byte encryptedData[] = md.digest(getStudentdata().getPassword().getBytes());  
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
		studentList=librarymanager.authenticateStudent(getStudentdata().getRoll(),encryptedText);
		if(studentList.size()!=1)
			return ERROR;
		else{
			System.out.println(studentList.get(0).getStudent_id());
			System.out.println(studentList.get(0).getName());
			return SUCCESS;
		}
	}
	*/
	public String studentRegister(){
		System.out.println("request of registration called");
		return SUCCESS;
	}
	
	
	public String registerDone(){
		System.out.println("registration process ");
		librarymanager=new LibraryManager();
		librarymanager.studentRegistration(getStudentdata());
		System.out.println(""+getStudentdata().getName());
		return SUCCESS;
	}
	
	public String studentAvailableBooks(){
		librarymanager=new LibraryManager();
		availList=new ArrayList<AvailableBooks>();
		availList=librarymanager.availableBooks(getStudent_id());
		return SUCCESS;
	}
	public String studentIssueBook(){
		librarymanager=new LibraryManager();
		int status=librarymanager.issueBook(getStudent_id(),getBook_id());
		 if(status>=1)
		  return SUCCESS;
		 else
		  return ERROR;
	}
	
	public String reActivityLogin(){
		librarymanager=new LibraryManager();
		studentList=librarymanager.reActivity(getStudent_id());
		return SUCCESS;
	}
	
	public String issuedBooksView(){
		librarymanager=new LibraryManager();
		//viewBookList=new ArrayList<StudentIssuedDataDto>();
		viewBookList=librarymanager.viewIssueDue(getStudent_id());
		return SUCCESS;
	}
	
	public String returnBookRequest(){ 
		librarymanager=new LibraryManager();
	    viewBookList=librarymanager.BookReturnRequest(getStudent_id(),getBooking_id());
		if(viewBookList.get(0).getStatus()=="Returned"){
			return SUCCESS;
			}
		else{
			return ERROR;
		}
	}
	//View previous due balance and previous issued books by a student
	public String  previousIssuedBooksView(){
		librarymanager=new LibraryManager();
		viewBookReturnList=librarymanager.previousView(getStudent_id());
		return SUCCESS;
	}
	 
	public String approveRegistration(){
		librarymanager=new LibraryManager();
		studentList=librarymanager.approveStudentRegistration(getAdmin_id());
		return SUCCESS;
	}
	
	public String adminApproveBookIssue(){
		librarymanager=new LibraryManager();
		issuingBookList=librarymanager.approveIssueBookRequest(getAdmin_id());
		return SUCCESS;
	}
	public String updateEditBooks(){
		librarymanager=new LibraryManager();
		availList=new ArrayList<AvailableBooks>();
		availList=librarymanager.adminAvailableBooks();
		return SUCCESS;
	}
	public String adminEditThisBook(){
		librarymanager=new LibraryManager();
		setAvailablebookedit(librarymanager.updateBookList(getBook_id()));
		return SUCCESS;
	}
	
	public String adminUpdatedDoneThisBook(){
		librarymanager=new LibraryManager();
		getAdmin_id();
		librarymanager.bookListUpdated(getAvailablebooks(),getBook_id());
		return SUCCESS;
	}
	//View total due List
	public String viewTotalDueList(){
		librarymanager=new LibraryManager();
		issuingDueList=librarymanager.viewTotalDue(getAdmin_id(),getRoll());
		if(issuingDueList.size()>=1){
			return SUCCESS;	
		} 
		return ERROR;
	}
	 
	public String approveStudentLoginData(){ 
		librarymanager=new LibraryManager();
		studentList=librarymanager.approveThisRegistration(getAdmin_id(),getStudent_id());
		return SUCCESS;
	}
	
	public String rejectStudentLoginData(){
		librarymanager=new LibraryManager();
		studentList=librarymanager.rejectThisRegistration(getAdmin_id(),getStudent_id());
		return SUCCESS;
	}
	
	public String approveStudentBookIssue(){
		librarymanager=new LibraryManager();
		issuingBookList=librarymanager.approveThisBook(getAdmin_id(),getBooking_id());
		return SUCCESS;
	}
	
	public String rejectStudentBookIssue(){
		librarymanager=new LibraryManager();
		issuingBookList=librarymanager.rejectThisBook(getAdmin_id(),getBooking_id());
		librarymanager=new LibraryManager();
		return SUCCESS;
	}
	
	public String adminViewReturnList(){
		librarymanager=new LibraryManager();
		issuingBookList=librarymanager.viewBookReturnList(getAdmin_id());
		return SUCCESS;
	}
	
	public String adminApproveBookReturn(){
		librarymanager=new LibraryManager();
		librarymanager.studentBookReturnAccept(getAdmin_id(),getBooking_id());
		return SUCCESS;
	}
	
	public String bookWishlisting(){
		return SUCCESS;
	}
	
	public String addWishlistingBook(){
		librarymanager=new LibraryManager();
		System.out.println(""+getStudentWishlist());
		setStudentWishlist(librarymanager.addBookInWishList(getStudentWishlist()));     
		return SUCCESS;
	}
	
	public String adminViewWishlisting(){
		librarymanager=new LibraryManager();
		wishBookList=librarymanager.viewWishListingBook();
		return SUCCESS;
	}
	public AdminData getAdmindata() {
		return admindata;
	}

	public void setAdmindata(AdminData admindata) {
		this.admindata = admindata;
	}

	public List<AdminData> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<AdminData> adminList) {
		this.adminList = adminList;
	}

	public StudentData getStudentdata() {
		return studentdata;
	}

	public void setStudentdata(StudentData studentdata) {
		this.studentdata = studentdata;
	}

	public List<StudentData> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentData> studentList) {
		this.studentList = studentList;
	}

	public List<AvailableBooks> getAvailList() {
		return availList;
	}

	public void setAvailList(List<AvailableBooks> availList) {
		this.availList = availList;
	}

	public long getBook_id() {
		return book_id;
	}

	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}

	public List<StudentIssuedDataDto> getViewBookList() {
		return viewBookList;
	}

	public void setViewBookList(List<StudentIssuedDataDto> viewBookList) {
		this.viewBookList = viewBookList;
	}

	public long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public List<StudentLibraryDto> getIssuingBookList() {
		return issuingBookList;
	}

	public void setIssuingBookList(List<StudentLibraryDto> issuingBookList) {
		this.issuingBookList = issuingBookList;
	}

	public long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}

	public long getRoll() {
		return roll;
	}

	public void setRoll(long roll) {
		this.roll = roll;
	}

	public StudentWishlist getStudentWishlist() {
		return studentWishlist;
	}

	public void setStudentWishlist(StudentWishlist studentWishlist) {
		this.studentWishlist = studentWishlist;
	}

	public List<StudentLibraryDto> getIssuingDueList() {
		return issuingDueList;
	}

	public void setIssuingDueList(List<StudentLibraryDto> issuingDueList) {
		this.issuingDueList = issuingDueList;
	}

	public List<StudentIssuedDataDto> getViewBookReturnList() {
		return viewBookReturnList;
	}

	public void setViewBookReturnList(List<StudentIssuedDataDto> viewBookReturnList) {
		this.viewBookReturnList = viewBookReturnList;
	}
	public AvailableBooks getAvailablebookedit() {
		return availablebookedit;
	}
	public void setAvailablebookedit(AvailableBooks availablebookedit) {
		this.availablebookedit = availablebookedit;
	}
	
	public AvailableBooks getAvailablebooks() {
		return availablebooks;
	}
	public void setAvailablebooks(AvailableBooks availablebooks) {
		this.availablebooks = availablebooks;
	}
	public List<StudentWishlist> getWishBookList() {
		return wishBookList;
	}
	public void setWishBookList(List<StudentWishlist> wishBookList) {
		this.wishBookList = wishBookList;
	}

}
