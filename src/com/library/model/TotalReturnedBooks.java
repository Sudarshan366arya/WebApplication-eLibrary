package com.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "total_returned_books", schema = "public")
public class TotalReturnedBooks {
	
	private long booking_id;
	//private long issuing_id_foreign;
	//private long book_id_foreign;
	//private long approved_by_admin;
	private Date issued_date;    
	private Date return_date;
	private double due_balance;
	private Date actual_return_date;
	private boolean is_return_accepted;
	
	private StudentIssuedData studentIssuedData5;
	private AvailableBooks availableBooks5;
	private AdminData adminData5;
	@Id
	@Column(name = "booking_id", unique = true, nullable = false)
	public long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "issued_date",length=13)
	public Date getIssued_date() {
		return issued_date;
	}
	public void setIssued_date(Date issued_date) {
		this.issued_date = issued_date;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "return_date",length=13)
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
	@Column(name = "due_balance")
	public double getDue_balance() {
		return due_balance;
	}
	public void setDue_balance(double due_balance) {
		this.due_balance = due_balance;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "actual_return_date",length=13)
	public Date getActual_return_date() {
		return actual_return_date;
	}
	public void setActual_return_date(Date actual_return_date) {
		this.actual_return_date = actual_return_date;
	}
	
	@Column(name = "is_return_accepted")
	public boolean isIs_return_accepted() {
		return is_return_accepted;
	}
	public void setIs_return_accepted(boolean is_return_accepted) {
		this.is_return_accepted = is_return_accepted;
	}
	
	@ManyToOne
	@JoinColumn(name="issuing_id_foreign")
	public StudentIssuedData getStudentIssuedData5() {
		return studentIssuedData5;
	}
	public void setStudentIssuedData5(StudentIssuedData studentIssuedData5) {
		this.studentIssuedData5 = studentIssuedData5;
	}
	
	@ManyToOne
	@JoinColumn(name="book_id_foreign")
	public AvailableBooks getAvailableBooks5() {
		return availableBooks5;
	}
	public void setAvailableBooks5(AvailableBooks availableBooks5) {
		this.availableBooks5 = availableBooks5;
	}
	
	@ManyToOne
	@JoinColumn(name="approved_by_admin")
	public AdminData getAdminData5() {
		return adminData5;
	}
	public void setAdminData5(AdminData adminData5) {
		this.adminData5 = adminData5;
	}
}
