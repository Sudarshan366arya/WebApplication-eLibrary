package com.library.model;

public class StudentIssuedDataDto {
    private long booking_id;
	private long book_id;
	private String book_name;
	private String author_name;
	private String issued_date;
	private String return_date;
	private long book_semester;
	private double due_balance;
	private String actual_day_of_return;
	private String status;
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getIssued_date() {
		return issued_date;
	}
	public void setIssued_date(String issued_date) {
		this.issued_date = issued_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public long getBook_semester() {
		return book_semester;
	}
	public void setBook_semester(long book_semester) {
		this.book_semester = book_semester;
	}
	public double getDue_balance() {
		return due_balance;
	}
	public void setDue_balance(double due_balance) {
		this.due_balance = due_balance;
	}
	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}
	public long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}
	public String getActual_day_of_return() {
		return actual_day_of_return;
	}
	public void setActual_day_of_return(String actual_day_of_return) {
		this.actual_day_of_return = actual_day_of_return;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
}
