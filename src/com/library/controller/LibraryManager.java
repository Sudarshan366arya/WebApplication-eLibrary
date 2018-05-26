package com.library.controller;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.library.model.AdminData;
import com.library.model.AvailableBooks;
import com.library.model.StudentData;
import com.library.model.StudentIssuedData;
import com.library.model.StudentIssuedDataDto;
import com.library.model.StudentLibraryDto;
import com.library.model.StudentWishlist;
import com.library.model.TotalIssuedBooks;
import com.library.model.TotalReturnedBooks;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import java.util.Calendar;
import com.library.util.HibernateUtil;

public class LibraryManager extends HibernateUtil {
	

	
	//Admin login credentials check
	@SuppressWarnings("unchecked")
	public List<AdminData> authenticateAdmin(String username,String password){
		final List<AdminData> NULL = null;
		List<AdminData> adminList=new ArrayList<AdminData>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			if(username!=""||password!=""){
			adminList=session.createQuery("from AdminData where admin_user_name='"+username+"' and admin_password='"+password+"'").list();
			}else{
				return NULL;
			}
			}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		  return adminList; 
		}
	
		
	/*public List<AdminData> authenticateAdmin(String username,String password){
		List<AdminData> adminList=new ArrayList<AdminData>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			adminList=session.createQuery("from AdminData where admin_user_name='"+username+"' and admin_password='"+password+"'").list();
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return adminList;
	}*/

	//Student Login credentials check
	@SuppressWarnings("unchecked")
	public List<StudentData> authenticateStudent(long roll,String password){
		List<StudentData> studentList=new ArrayList<StudentData>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			studentList=session.createQuery("from StudentData where roll='"+roll+"' and password='"+password+"' and is_approved='"+true+"'").list();
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return studentList;
	}
    //Registration Of student
	public void studentRegistration(StudentData studentdata){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		System.out.println(""+studentdata.getName());
		try{
			System.out.println(""+studentdata.getName());
			String encryptedText = "";  
	        try {  
	            MessageDigest md = MessageDigest.getInstance("MD5");  
	            byte encryptedData[] = md.digest(studentdata.getPassword().getBytes());  
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
			studentdata.setPassword(encryptedText);
			session.save(studentdata);
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	//Available books in library for a student
	public List<AvailableBooks>  availableBooks(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<AvailableBooks> availList=new ArrayList<AvailableBooks>();
		try{
			long branch_id=(long) session.createQuery(" select bt1.branch_id from StudentData sd inner join sd.branchType1 bt1 where sd.student_id='"+id+"'").list().get(0);
			@SuppressWarnings("unchecked")
			List<Object[]> availableBookList=session.createQuery("select book_id,book_name,book_author,book_description,is_book_available,book_semester from AvailableBooks where branchType2='"+branch_id+"' ").list();
			for(Object[] object:availableBookList){
				AvailableBooks availableBooks=new AvailableBooks(Integer.valueOf(object[0].toString()),object[1].toString(),object[2].toString(),object[3].toString(),Boolean.valueOf(object[4].toString()),Integer.valueOf(object[5].toString()));
				availList.add(availableBooks);
			}
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//session.getTransaction().commit();
		return availList;
	}
	//Book edit update by admin
	@SuppressWarnings("unchecked")
	public List<AvailableBooks> adminAvailableBooks(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<AvailableBooks> availList=new ArrayList<AvailableBooks>();
		try{
		List<Object[]> availableBookList=session.createQuery("select book_id,book_name,book_author,is_book_available,book_description,book_semester,number_of_available_books from AvailableBooks").list();
		for(Object[] object:availableBookList){
			String book_branch_type=(String)session.createQuery(" select branchType2.branch_name from AvailableBooks av where book_id='"+Integer.valueOf(object[0].toString())+"'").list().get(0);
			//System.out.println(""+book_branch_type+object[1].toString()+object[2].toString());
			AvailableBooks availableBooks=new AvailableBooks(book_branch_type,Integer.valueOf(object[0].toString()),object[1].toString(),object[2].toString(),Boolean.valueOf(object[3].toString()),object[4].toString(),Integer.valueOf(object[5].toString()),Integer.valueOf(object[6].toString()));
			availList.add(availableBooks);
		}
		}catch(HibernateException e){
		e.printStackTrace();
		session.getTransaction().rollback();
	}
	session.getTransaction().commit();
	return availList;	
	}
	//Update book list by admin
	public AvailableBooks updateBookList(long book_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		AvailableBooks availablebookedit=(AvailableBooks) session.load(AvailableBooks.class, book_id);
		if(null!=availablebookedit){
			System.out.println(availablebookedit.getBook_id());
			System.out.println(""+availablebookedit.getBook_name()); 
					}
		session.getTransaction().commit();
		return availablebookedit;
	}
	//Book List Update Done by Admin
	public AvailableBooks bookListUpdated(AvailableBooks avbs,long book_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		session.update(avbs);
		session.getTransaction().commit();
		return avbs;
	}
	
	//BOOK ISSUE BY A STUDENT
	@SuppressWarnings({ "unchecked"})
	public int issueBook(long student_id,long book_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		int number_of_books_issued=0;
		List<Object[]> issuedDataList,issuedDataList1;
		try{
			issuedDataList1=session.createQuery("select sid.issuing_id,sid.number_of_books_issued from StudentIssuedData sid inner join sid.studentData1 sd1 where sd1.student_id='"+student_id+"'").list();
			if(issuedDataList1.size()==0){       
		    	StudentData STD = (StudentData)session.load(StudentData.class,student_id);
			 StudentIssuedData SID=new StudentIssuedData();
			 SID.setStudentData1(STD);
			 SID.setNumber_of_books_issued(0);
			 SID.setPrevious_total_due(0);
			 SID.setTotal_due_balance(0);
			 session.save(SID);
		    }
			issuedDataList=session.createQuery("select sid.issuing_id,sid.number_of_books_issued from StudentIssuedData sid inner join sid.studentData1 sd1 where sd1.student_id='"+student_id+"'").list();
			for(Object[] object:issuedDataList){
				if(Integer.valueOf(object[1].toString())<=3&&Integer.valueOf(object[1].toString())>=0){
					Calendar calendar = Calendar.getInstance();
					Date d1 =  calendar.getTime();
					TotalIssuedBooks totalIssuedBooks=new TotalIssuedBooks();
					StudentIssuedData sid=(StudentIssuedData) session.load(StudentIssuedData.class, Long.valueOf(object[0].toString()));
					AvailableBooks ab=(AvailableBooks)session.load(AvailableBooks.class,book_id);
					totalIssuedBooks.setStudentIssuedData1(sid);
					totalIssuedBooks.setAvailableBooks1(ab);
					totalIssuedBooks.setIs_granted_issue(false);
					totalIssuedBooks.setIs_rejected_issue(false);
					totalIssuedBooks.setIssued_date(d1);
					totalIssuedBooks.setReturn_date(d1);
					session.save(totalIssuedBooks);
				    sid.setNumber_of_books_issued(Long.valueOf(object[1].toString())+1);
					session.update(sid);
					number_of_books_issued=1;
				}			
		}
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return number_of_books_issued;
	}

	//Student reactivity
	@SuppressWarnings("unchecked")
	public List<StudentData> reActivity(long student_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<StudentData> studentList=new ArrayList<StudentData>();
		session.beginTransaction();
		try{
			studentList=session.createQuery("from StudentData where student_id='"+student_id+"'").list();
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return studentList;
	}

	//View current due balance and current issued books by a student
	@SuppressWarnings("unchecked")
	public List<StudentIssuedDataDto>  viewIssueDue(long student_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		long issuing_id=0;
		double total_due;
		int number_of_books_issued;
		List<StudentIssuedDataDto> viewBookList=new ArrayList<StudentIssuedDataDto>();
		session.beginTransaction();
		try{
			List<Object[]> objList=session.createQuery("select sid.issuing_id,sid.total_due_balance,number_of_books_issued from StudentIssuedData sid  where sid.studentData1='"+student_id+"'").list();
			for(Object[] object:objList){
				issuing_id=Long.valueOf(object[0].toString());
				total_due=Double.valueOf(object[1].toString());
				number_of_books_issued=Integer.valueOf(object[2].toString());
			}
			// List<Object[]> BookIdDateList =session.createQuery("select availableBooks1,tid.issued_date,tid.return_date from TotalIssuedBooks tib inner join tib.studentIssuedData1 sid1 where sid1.issuing_id='"+issuing_id+"' and tib.is_granted_issue='"+true+"'").list();
			List<Object[]> BookIdDateList=session.createQuery("select ab.book_id,ab.book_name,ab.book_author,ab.book_semester,tib.booking_id,tib.is_granted_issue,tib.issued_date,tib.return_date,tib.due_balance from AvailableBooks ab inner join ab.totalIssuedBookss tib inner join tib.studentIssuedData1 sid1 where sid1.issuing_id='"+issuing_id+"' and tib.is_rejected_issue='"+false+"'and tib.is_book_returned='"+false+"'").list();
			for(Object[] object:BookIdDateList){
				StudentIssuedDataDto sidd=new StudentIssuedDataDto();
				sidd.setBook_id(Integer.valueOf(object[0].toString()));
				sidd.setBook_name(object[1].toString());
				sidd.setAuthor_name(object[2].toString());
				sidd.setBook_semester(Integer.valueOf(object[3].toString()));
				sidd.setBooking_id(Long.valueOf(object[4].toString()));
				if(Boolean.valueOf(object[5].toString())==false){
					sidd.setStatus("Pending");
				}
				else{
					sidd.setStatus("Granted");
				}
				sidd.setIssued_date(object[6].toString());
				sidd.setReturn_date(object[7].toString());
				sidd.setDue_balance(Double.valueOf(object[8].toString()));
				viewBookList.add(sidd);
			}
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//session.getTransaction().commit();
		return viewBookList;
	}

	 //Book Returning request of a student
	public List<StudentIssuedDataDto>  BookReturnRequest(long student_id,long booking_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentIssuedDataDto> SidDTOList=new ArrayList<StudentIssuedDataDto>();
		StudentIssuedDataDto SidDTO=new StudentIssuedDataDto();
		TotalIssuedBooks tib=(TotalIssuedBooks)session.load(TotalIssuedBooks.class,booking_id);
		if(tib.isIs_granted_issue()==true){
		     tib.setIs_book_returned(true);
		     session.update(tib);
		     SidDTO.setBook_id(tib.getAvailableBooks1().getBook_id());
		     SidDTO.setBook_name(tib.getAvailableBooks1().getBook_name());
		     SidDTO.setBook_semester(tib.getAvailableBooks1().getBook_semester());
		     SidDTO.setAuthor_name(tib.getAvailableBooks1().getBook_author());
		     SidDTO.setStatus("Returned");
		     SidDTOList.add(SidDTO);
		}
		else if(tib.isIs_granted_issue()==false){
			 SidDTO.setBook_id(tib.getAvailableBooks1().getBook_id());
		     SidDTO.setBook_name(tib.getAvailableBooks1().getBook_name());
		     SidDTO.setBook_semester(tib.getAvailableBooks1().getBook_semester());
		     SidDTO.setAuthor_name(tib.getAvailableBooks1().getBook_author());
		     SidDTO.setStatus("Not Accepted");
		     SidDTOList.add(SidDTO);
		}
		session.getTransaction().commit();
		return SidDTOList;
	}
	
	
	//View previous due balance and previous issued books by a student
	@SuppressWarnings("unchecked")
	public List<StudentIssuedDataDto> previousView(long student_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentIssuedDataDto> viewBookList=new ArrayList<StudentIssuedDataDto>();
		try{
			long issuing_id=(long)session.createQuery("select sid.issuing_id from StudentIssuedData sid  where sid.studentData1='"+student_id+"'").list().get(0);
			
			// List<Object[]> BookIdDateList =session.createQuery("select availableBooks1,tid.issued_date,tid.return_date from TotalIssuedBooks tib inner join tib.studentIssuedData1 sid1 where sid1.issuing_id='"+issuing_id+"' and tib.is_granted_issue='"+true+"'").list();
			List<Object[]> BookIdDateList=session.createQuery("select ab.book_id,ab.book_name,ab.book_author,ab.book_semester,tib.issued_date,tib.return_date,tib.due_balance from AvailableBooks ab inner join ab.totalIssuedBookss tib inner join tib.studentIssuedData1 sid1 where sid1.issuing_id='"+issuing_id+"' and tib.is_rejected_issue='"+false+"'and tib.is_book_returned='"+true+"'").list();
			if(BookIdDateList.size()>0){
			for(Object[] object:BookIdDateList){
				StudentIssuedDataDto sidd=new StudentIssuedDataDto();
				sidd.setBook_id(Integer.valueOf(object[0].toString()));
				sidd.setBook_name(object[1].toString());
				sidd.setAuthor_name(object[2].toString());
				sidd.setBook_semester(Integer.valueOf(object[3].toString()));
				sidd.setStatus("Pending");
				sidd.setIssued_date(object[4].toString());
				sidd.setReturn_date(object[5].toString());
				sidd.setDue_balance(Double.valueOf(object[6].toString()));
				sidd.setActual_day_of_return(null);
				viewBookList.add(sidd);
			 }
			}
	
			List<Object[]> BookIdDateList1=session.createQuery("select ab.book_id,ab.book_name,ab.book_author,ab.book_semester,trb.issued_date,trb.return_date,trb.actual_return_date,trb.due_balance from AvailableBooks ab inner join ab.totalReturnedBookss trb inner join trb.studentIssuedData5 sid5 where sid5.issuing_id='"+issuing_id+"' and trb.is_return_accepted='"+true+"'").list();
		   System.out.println(""+BookIdDateList1.size());
		   for(Object[] object:BookIdDateList1){
		     StudentIssuedDataDto sidd=new StudentIssuedDataDto();
		     sidd.setBook_id(Integer.valueOf(object[0].toString()));
			 sidd.setBook_name(object[1].toString());
			 sidd.setAuthor_name(object[2].toString());
			 sidd.setBook_semester(Integer.valueOf(object[3].toString()));
			 sidd.setStatus("Accepted");
			 sidd.setIssued_date(object[4].toString());
			 sidd.setReturn_date(object[5].toString());
			 sidd.setActual_day_of_return(object[6].toString());
			 sidd.setDue_balance(Double.valueOf(object[7].toString()));
			 viewBookList.add(sidd);
		   }
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//session.getTransaction().commit();
		return viewBookList;
	}
	//Approve Student Login Credential by Admin
	@SuppressWarnings("unchecked")
	public List<StudentData> approveStudentRegistration(long admin_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentData> studntApprovalList=new ArrayList<StudentData>();
		try{
			studntApprovalList=session.createQuery("from StudentData where is_approved='"+false+"' and is_rejected='"+false+"'").list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return studntApprovalList;
	}

	//Approve book issue request list
	@SuppressWarnings("unchecked")
	public List<StudentLibraryDto> approveIssueBookRequest(long admin_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentLibraryDto> issuingBookList=new ArrayList<StudentLibraryDto>();
		try{
			List<Object[]> approveObjList=session.createQuery("select tib.booking_id,sid.issuing_id,sid.number_of_books_issued,sd.student_id,sd.name,bt.branch_name,sd.roll," +
					"  sd.batch,ab.book_id,ab.book_name,ab.book_author,ab.book_semester,ab.number_of_available_books from TotalIssuedBooks tib inner join " +
					" tib.studentIssuedData1 sid inner join sid.studentData1 sd inner join sd.branchType1 bt inner join tib.availableBooks1 ab where tib.is_granted_issue='"+false+"' and tib.is_rejected_issue='"+false+"'").list();
			for(Object[] object:approveObjList){
				StudentLibraryDto sld=new StudentLibraryDto();
				sld.setBooking_id(Long.valueOf(object[0].toString()));
				sld.setIssuing_id(Long.valueOf(object[1].toString()));
				sld.setNumber_of_books_issued(Long.valueOf(object[2].toString()));
				sld.setStudent_id(Long.valueOf(object[3].toString()));
				sld.setName(object[4].toString());
				sld.setBranch_name(object[5].toString());
				sld.setRoll(Long.valueOf(object[6].toString()));
				sld.setBatch(Integer.valueOf(object[7].toString()));
				sld.setBook_id(Integer.valueOf(object[8].toString()));
				sld.setBook_name(object[9].toString());
				sld.setBook_author(object[10].toString());
				sld.setBook_semester(Integer.valueOf(object[11].toString()));
				sld.setNumber_of_available_books(Integer.valueOf(object[12].toString()));
				issuingBookList.add(sld);
			}
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}System.out.println(""+5);
		//session.getTransaction().commit();
		return issuingBookList;
	}
	//Approve particular book issue by Admin
	   public List<StudentLibraryDto> approveThisBook(long admin_id,long booking_id){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			System.out.println(""+1);
			List<StudentLibraryDto> issuingBookList=new ArrayList<StudentLibraryDto>();
			try{
				Date today = new Date(); 
				Calendar cal = Calendar.getInstance(); 
				cal.add(Calendar.DAY_OF_MONTH, 15); 
				Date nextday = cal.getTime();
				AdminData ad=(AdminData) session.load(AdminData.class,admin_id);
				TotalIssuedBooks tib=(TotalIssuedBooks)session.load(TotalIssuedBooks.class,booking_id);
				tib.setIs_granted_issue(true);
				tib.setIs_rejected_issue(false); 
				tib.setAdminData2(ad);
				tib.setIssued_date(today);
				tib.setReturn_date(nextday);
				session.update(tib);
				
				long book_id=(long)session.createQuery("select ab.book_id from AvailableBooks ab inner join ab.totalIssuedBookss tib where tib.booking_id='"+booking_id+"'").list().get(0);
				
				AvailableBooks abs=(AvailableBooks)session.load(AvailableBooks.class,book_id);
				if(null!=ad){
					System.out.println(""+ad.getAdmin_id());
				}
				if(null!=tib){
					System.out.println(""+tib.getBooking_id());
				}
				if(null!=abs){
					System.out.println(""+tib.getBooking_id());
				}
				long number_of_available_books=abs.getNumber_of_available_books();
				
				 if(number_of_available_books==1){
					abs.setNumber_of_available_books(0);
					abs.setIs_book_available(false);
					 }
				else if(number_of_available_books>=2){
					abs.setNumber_of_available_books(number_of_available_books-1);
					abs.setIs_book_available(true);
				}
				session.update(abs);
				issuingBookList= approveIssueBookRequest(admin_id);
			 }catch(Exception e){
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();
			return issuingBookList;
		}
	//View Total Due BalanceList
	@SuppressWarnings("unchecked")
	public List<StudentLibraryDto> viewTotalDue(long admin_id,long roll){
		calculateTotalDue();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentLibraryDto> issuingBookList=new ArrayList<StudentLibraryDto>();
		try{
            if(roll==0&&roll<=10){
				List<Object[]> vieDueList=session.createQuery("select sd.student_id,sd.roll,sd.name,sd.branchType1.branch_name,sd.batch,sid.total_due_balance,sid.previous_total_due from StudentData sd inner join sd.studentIssuedData sid").list();
				for(Object[] object:vieDueList){
					StudentLibraryDto sld=new StudentLibraryDto();
					sld.setStudent_id(Long.valueOf(object[0].toString()));
					sld.setRoll(Long.valueOf(object[1].toString()));
					sld.setName(object[2].toString());
					sld.setBranch_name(object[3].toString());
					sld.setBatch(Integer.valueOf(object[4].toString()));
					sld.setTotal_due_balance(Double.valueOf(object[5].toString())+Double.valueOf(object[6].toString()));
					issuingBookList.add(sld);
                 }//System.out.println(""+issuingBookList.size());
			}else{
				List<Object[]> vieDueList=session.createQuery("select sd.student_id,sd.name,sd.branchType1.branch_name,sd.batch,sid.total_due_balance,sid.previous_total_due from StudentData sd inner join sd.studentIssuedData sid where sd.roll='"+roll+"'").list();
				for(Object[] object:vieDueList){
					StudentLibraryDto sld=new StudentLibraryDto();
					sld.setStudent_id(Long.valueOf(object[0].toString()));
					sld.setRoll(roll);
					sld.setName(object[1].toString());
					sld.setBranch_name(object[2].toString());
					sld.setBatch(Integer.valueOf(object[3].toString()));
					sld.setTotal_due_balance(Double.valueOf(object[4].toString())+Double.valueOf(object[5].toString()));
					issuingBookList.add(sld);
					System.out.println(""+issuingBookList.size());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		 return issuingBookList;
	}
		
	//calculate individual due;
	@SuppressWarnings({ "unchecked" })
	public void calculateTotalDue(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Object[]> tibooksList=session.createQuery("select booking_id,return_date from TotalIssuedBooks where is_granted_issue='"+true+"' and is_rejected_issue='"+false+"'").list();
		List<Long> siDataList=session.createQuery("select issuing_id from StudentIssuedData").list();
		for(Object[] object:tibooksList){
			Date today=new Date();
			Date return_date=java.sql.Date.valueOf(object[1].toString());
			long today_Second=today.getTime();
			long return_Second=return_date.getTime();
			long booking_id=Long.valueOf(object[0].toString());
            if(today_Second<return_Second){
				TotalIssuedBooks tibs=(TotalIssuedBooks)session.load(TotalIssuedBooks.class,booking_id); 
				tibs.setDue_balance(0.0);
				System.out.println(""+tibs.getDue_balance());
				session.update(tibs);
			}
			else{
				long days=(today_Second-return_Second)/(1000*3600*24);
				Double due_amount=days*.25;
				TotalIssuedBooks tibs=(TotalIssuedBooks)session.load(TotalIssuedBooks.class,booking_id); 
				tibs.setDue_balance(due_amount);
				System.out.println(""+due_amount);
				session.update(tibs);
			}
		}
		for(int j=0;j<siDataList.size();j++){
			List<Object[]> individualDue=(List<Object[]>)session.createQuery("select tib.due_balance,tib.is_granted_issue from StudentIssuedData sid inner join sid.totalIssuedBooks tib where sid.issuing_id='"+siDataList.get(j)+"'").list();
			Double Total_dues=0.0;
			for(Object[] object:individualDue){
				Total_dues=Total_dues+Double.valueOf(object[0].toString());
			}
			StudentIssuedData sids=(StudentIssuedData)session.load(StudentIssuedData.class,siDataList.get(j));
			sids.setTotal_due_balance(Total_dues);
			session.update(sids);	
		} 
		session.getTransaction().commit();
	}
	
	//Approve Particular Student Data
	@SuppressWarnings("unchecked")
	public List<StudentData> approveThisRegistration(long admin_id,long student_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentData> studntApprovalList=new ArrayList<StudentData>();
		try{
			AdminData ad=(AdminData) session.createQuery("from AdminData where admin_id='"+admin_id+"'").list().get(0);
			StudentData sd=(StudentData)session.createQuery("from StudentData where student_id='"+student_id+"'").list().get(0);
			sd.setIs_approved(true);
			sd.setIs_rejected(false);
			sd.setAdminData3(ad);
			session.update(sd);
			studntApprovalList=session.createQuery("from StudentData where is_approved='"+false+"' and is_rejected='"+false+"'").list();
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return studntApprovalList;
	}

	//Reject Particular Student Data
	@SuppressWarnings("unchecked")
	public List<StudentData> rejectThisRegistration(long admin_id,long student_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentData> studntApprovalList=new ArrayList<StudentData>();
		try{
			AdminData ad=(AdminData) session.load(AdminData.class,admin_id);
			StudentData sd=(StudentData) session.load(StudentData.class,student_id);
			sd.setIs_approved(false);
			sd.setIs_rejected(true);
			sd.setAdminData3(ad);
			session.update(sd);
			studntApprovalList=session.createQuery("from StudentData where is_approved='"+false+"' and is_rejected='"+false+"'").list();
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return studntApprovalList;	
	}

	//Reject particular book issue by Admin
	public List<StudentLibraryDto> rejectThisBook(long admin_id,long booking_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentLibraryDto> issuingBookList=new ArrayList<StudentLibraryDto>();
		try{
			AdminData ad=(AdminData) session.load(AdminData.class,admin_id);
			TotalIssuedBooks tib=(TotalIssuedBooks) session.load(TotalIssuedBooks.class,booking_id);
			tib.setIs_granted_issue(false);
			tib.setIs_rejected_issue(true);
			tib.setAdminData2(ad);
			session.update(tib);
			long issuing_id=(long)session.createQuery("select sid.issuing_id from TotalIssuedBooks tib inner join tib.studentIssuedData1 sid where tib.booking_id='"+booking_id+"'").list().get(0);
			StudentIssuedData sid=(StudentIssuedData)session.load(StudentIssuedData.class,issuing_id);
			long number_of_books_issued=sid.getNumber_of_books_issued();
			sid.setNumber_of_books_issued(number_of_books_issued-1);
			session.update(sid);

			issuingBookList= approveIssueBookRequest(admin_id);
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return issuingBookList;
	}
	
	//Admin view book return request list
	@SuppressWarnings("unchecked")
	public List<StudentLibraryDto> viewBookReturnList(long admin_id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentLibraryDto>issuingBookList=new ArrayList<StudentLibraryDto>();
		try{
			List<Object[]> approveObjList=session.createQuery("select tib.booking_id,sd.student_id,sd.name,bt.branch_name,sd.roll," +
					"  sd.batch,ab.book_id,ab.book_name,ab.book_author,ab.book_semester from TotalIssuedBooks tib inner join " +
					" tib.studentIssuedData1 sid inner join sid.studentData1 sd inner join sd.branchType1 bt inner join tib.availableBooks1 ab where tib.is_granted_issue='"+true+"' and tib.is_rejected_issue='"+false+"' and tib.is_book_returned='"+true+"'").list();
			for(Object[] object:approveObjList){
				StudentLibraryDto sld=new StudentLibraryDto();
				sld.setBooking_id(Long.valueOf(object[0].toString()));
				sld.setStudent_id(Long.valueOf(object[1].toString()));
				sld.setName(object[2].toString());
				sld.setBranch_name(object[3].toString());
				sld.setRoll(Long.valueOf(object[4].toString()));
				sld.setBatch(Integer.valueOf(object[5].toString()));
				sld.setBook_id(Integer.valueOf(object[6].toString()));
				sld.setBook_name(object[7].toString());
				sld.setBook_author(object[8].toString());
				sld.setBook_semester(Integer.valueOf(object[9].toString()));
				issuingBookList.add(sld);
			}
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return issuingBookList;
	}
	
	
	//Book returning approval by admin
		public void studentBookReturnAccept(long admin_id,long booking_id){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			List<StudentIssuedDataDto> viewBookList=new ArrayList<StudentIssuedDataDto>();
			session.beginTransaction();
	        try{
	        	double due_balance;
	        	long number_of_books_issued;
	        	double previous_total_due;
	        	long number_of_available_books;	        	
	        	Date actual_return_date=new Date();
	        	TotalIssuedBooks tib=(TotalIssuedBooks)session.load(TotalIssuedBooks.class,booking_id);
	        	StudentIssuedData sid=tib.getStudentIssuedData1();
	        	AvailableBooks ab=tib.getAvailableBooks1();
	        	
	        	StudentIssuedData sid1=(StudentIssuedData)session.load(StudentIssuedData.class,sid.getIssuing_id());
	        	AvailableBooks ab1=(AvailableBooks)session.load(AvailableBooks.class,ab.getBook_id());
	        	
	        	due_balance=tib.getDue_balance();
	        	number_of_books_issued=sid1.getNumber_of_books_issued();
	        	previous_total_due=sid1.getPrevious_total_due();
	        	number_of_available_books=ab1.getNumber_of_available_books();
	        	
	        	sid1.setNumber_of_books_issued(number_of_books_issued-1);
	        	sid1.setPrevious_total_due(previous_total_due+due_balance);
	        	ab1.setNumber_of_available_books(number_of_available_books+1);
	        	if(ab1.isIs_book_available()==false){
	        		ab1.setIs_book_available(true); 
	        		}
	        	session.update(ab1);
	        	session.update(sid1);
	        	TotalReturnedBooks trb=new TotalReturnedBooks();
	        	trb.setBooking_id(tib.getBooking_id());
	        	
	        	StudentIssuedData sid2=(StudentIssuedData)session.load(StudentIssuedData.class,tib.getStudentIssuedData1().getIssuing_id());
	        	trb.setStudentIssuedData5(sid2);
	        	
	        	AvailableBooks ab2=(AvailableBooks) session.load(AvailableBooks.class, tib.getAvailableBooks1().getBook_id());
	        	trb.setAvailableBooks5(ab2);
	        	trb.setIssued_date(tib.getIssued_date());
	        	trb.setReturn_date(tib.getReturn_date());
	        	trb.setActual_return_date(actual_return_date);
	        	trb.setDue_balance(due_balance);
	        	trb.setIs_return_accepted(true);
	        	
	        	AdminData ad2=(AdminData) session.load(AdminData.class, admin_id);
	        	trb.setAdminData5(ad2);
	        	session.save(trb);
	        	session.delete(tib);
	        	session.getTransaction().commit();
	        	calculateTotalDue();
	        }catch(Exception e){
	        	e.printStackTrace();
	        	session.getTransaction().rollback();
	        }
		}
	public StudentWishlist addBookInWishList(StudentWishlist swl){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(swl);
		session.getTransaction().commit();
		return swl;
	}
	//view book wishlisting by admin
	@SuppressWarnings("unchecked")
	public List<StudentWishlist> viewWishListingBook(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<StudentWishlist> wishList=new ArrayList<StudentWishlist>();
		try{
			wishList=session.createQuery("from StudentWishlist").list(); 
			System.out.println(""+wishList.size());
		}catch(Exception e){
        	e.printStackTrace();
        	session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return wishList;
	}
}
