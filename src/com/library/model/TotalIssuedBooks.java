package com.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "total_issued_books", schema = "public")
public class TotalIssuedBooks {

	private long booking_id;
	//private long issuing_id_foreign;
	//private long book_id_foreign; 
	private Date issued_date;  
	private boolean is_granted_issue;   
	private Date return_date;
	private double due_balance;
	private boolean is_rejected_issue;
	private boolean is_book_returned;
	//private int approoved_or_rejected_by;
	private StudentIssuedData studentIssuedData1;
	private AvailableBooks availableBooks1;
	private AdminData adminData2;
 
	
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="total_issued_books_booking_id")})
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name = "booking_id", unique = true, nullable = false)
	public long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}
	
	/*
	public long getIssuing_id_foreign() {
		return issuing_id_foreign;
	}
	public void setIssuing_id_foreign(long issuing_id_foreign) {
		this.issuing_id_foreign = issuing_id_foreign;
	}
	
	
	public long getBook_id_foreign() {
		return book_id_foreign;
	}
	public void setBook_id_foreign(long book_id_foreign) {
		this.book_id_foreign = book_id_foreign;
	}
	*/
	
	@Temporal(TemporalType.DATE)
	@Column(name = "issued_date",length=13)
	public Date getIssued_date() {
		return issued_date;
	}
	public  void setIssued_date(Date issued_date) {
		this.issued_date = issued_date;
	}
	
	@Column(name = "is_granted_issue")
	public boolean isIs_granted_issue() {
		return is_granted_issue;
	}
	public void setIs_granted_issue(boolean is_granted_issue) {
		this.is_granted_issue = is_granted_issue;
	}
	
	@Column(name = "is_book_returned")
	public boolean isIs_book_returned() {
		return is_book_returned;
	}
	public void setIs_book_returned(boolean is_book_returned) {
		this.is_book_returned = is_book_returned;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "return_date",length=13)
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
	@ManyToOne
	@JoinColumn(name="issuing_id_foreign")
	public StudentIssuedData getStudentIssuedData1() {
		return studentIssuedData1;
	}
	public void setStudentIssuedData1(StudentIssuedData studentIssuedData1) {
		this.studentIssuedData1 = studentIssuedData1;
	}
	
	@ManyToOne
	@JoinColumn(name="book_id_foreign")
	public AvailableBooks getAvailableBooks1() {
		return availableBooks1;
	}
	public void setAvailableBooks1(AvailableBooks availableBooks1) {
		this.availableBooks1 = availableBooks1;
	}
	@Column(name = "due_balance")
	public double getDue_balance() {
		return due_balance;
	}
	public void setDue_balance(double due_balance) {
		this.due_balance = due_balance;
	}
	
	@Column(name = "is_rejected_issue",nullable = false)
	public boolean isIs_rejected_issue() {
		return is_rejected_issue;
	}
	public void setIs_rejected_issue(boolean is_rejected_issue) {
		this.is_rejected_issue = is_rejected_issue;
	}
	
	@ManyToOne
	@JoinColumn(name="approved_or_rejected_by")
	public AdminData getAdminData2() {
		return adminData2;
	}
	public void setAdminData2(AdminData adminData2) {
		this.adminData2 = adminData2;
	}
	
}
