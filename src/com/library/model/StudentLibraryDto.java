package com.library.model;

public class StudentLibraryDto {

	private long branch_id;
	private String branch_name;
	private long student_id;
	private long roll;
	private String name;
	private long batch;
	private long book_id;
	private String book_name;
	private String book_author;
	private String publisher;
	private long book_semester;
	private long issuing_id;
	private long booking_id;
	private long number_of_available_books;
	private long number_of_books_issued;
	private double total_due_balance;
	public long getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(long branch_id) {
		this.branch_id = branch_id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	public long getRoll() {
		return roll;
	}
	public void setRoll(long roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBatch() {
		return batch;
	}
	public void setBatch(long batch) {
		this.batch = batch;
	}
	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public long getBook_semester() {
		return book_semester;
	}
	public void setBook_semester(long book_semester) {
		this.book_semester = book_semester;
	}
	public long getIssuing_id() {
		return issuing_id;
	}
	public void setIssuing_id(long issuing_id) {
		this.issuing_id = issuing_id;
	}
	public long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}
	public long getNumber_of_available_books() {
		return number_of_available_books;
	}
	public void setNumber_of_available_books(long number_of_available_books) {
		this.number_of_available_books = number_of_available_books;
	}
	public double getTotal_due_balance() {
		return total_due_balance;
	}
	public void setTotal_due_balance(double total_due_balance) {
		this.total_due_balance = total_due_balance;
	}
	public long getNumber_of_books_issued() {
		return number_of_books_issued;
	}
	public void setNumber_of_books_issued(long number_of_books_issued) {
		this.number_of_books_issued = number_of_books_issued;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
	
}
